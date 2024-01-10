package pic.poc.archexample.mvc

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import pic.poc.archexample.common.Book
import pic.poc.archexample.common.SortMethod

class MvcModel() : MVC.Model {

    private val _shouldFinishScreen = MutableStateFlow(false)
    override val shouldFinishScreen: StateFlow<Boolean> = _shouldFinishScreen

    private val _updateBooksList = MutableStateFlow(emptyList<Book>())
    override val updateBooksList: StateFlow<List<Book>> = _updateBooksList

    private val _showLoading = MutableStateFlow(false)
    override val showLoading: StateFlow<Boolean> = _showLoading

    override fun closeScreen() {
        _shouldFinishScreen.value = true
    }

    override fun addBook(book: Book) {
        _updateBooksList.value = _updateBooksList.value + book
    }

    override fun deleteBook(position: Int) {
        _updateBooksList.value = _updateBooksList.value - _updateBooksList.value[position]
    }

    override fun sortBooksList(sortMethod: SortMethod) {
        _updateBooksList.value = when (sortMethod) {
            SortMethod.BY_TITLE -> _updateBooksList.value.sortedBy { it.title }
            SortMethod.BY_AUTHOR -> _updateBooksList.value.sortedBy { it.author }
            SortMethod.BY_YEAR -> _updateBooksList.value.sortedBy { it.year }
        }
    }

    override fun showLoading(isLoading: Boolean) {
        _showLoading.value = isLoading
    }
}
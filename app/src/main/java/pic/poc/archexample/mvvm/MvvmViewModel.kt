package pic.poc.archexample.mvvm

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import pic.poc.archexample.common.Book
import pic.poc.archexample.common.SortMethod

class MvvmViewModel : MVVM.ViewModel {

    private val model = MvvmModel()

    private val _shouldFinishScreen = MutableStateFlow(false)
    override val shouldFinishScreen: StateFlow<Boolean>
        get() = _shouldFinishScreen

    private val _updateBooksList = MutableStateFlow(emptyList<Book>())
    override val updateBooksList: StateFlow<List<Book>>
        get() = _updateBooksList

    private val _showLoading = MutableStateFlow(false)
    override val showLoading: StateFlow<Boolean>
        get() = _showLoading

    override fun onBackClicked() {
        _shouldFinishScreen.value = true
    }

    override fun onAddBookClicked(book: Book) {
        val updatedBooksList = model.addBook(book)
        _updateBooksList.value = updatedBooksList
    }

    override fun onDeleteBookClicked(position: Int) {
        val updatedBooksList = model.removeBook(position)
        _updateBooksList.value = updatedBooksList
    }

    override fun onSortBookClicked(sortMethod: SortMethod) {
        val sortedList = when (sortMethod) {
            SortMethod.BY_TITLE -> model.getBooksList().sortedBy { it.title }
            SortMethod.BY_AUTHOR -> model.getBooksList().sortedBy { it.author }
            SortMethod.BY_YEAR -> model.getBooksList().sortedBy { it.year }
        }
        _updateBooksList.value = sortedList
    }
}
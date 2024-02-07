package pic.poc.archexample.mvp

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import pic.poc.archexample.common.Book
import pic.poc.archexample.common.SortMethod

class MvpPresenter : MVP.Presenter {

    private val model = MvpModel()

    private val _shouldFinishScreen = MutableStateFlow(false)
    override val shouldFinishScreen: StateFlow<Boolean>
        get() = _shouldFinishScreen

    private val _updateBooksList = MutableStateFlow<List<Book>>(model.getBooksList())
    override val updateBooksList: StateFlow<List<Book>>
        get() = _updateBooksList

    private val _showLoading = MutableStateFlow(false)
    override val showLoading: StateFlow<Boolean>
        get() = _showLoading

    override fun onAddBookClicked(book: Book) {
        val updatedList = model.addBook(book)
        _updateBooksList.value = updatedList
    }

    override fun onBackClicked() {
        _shouldFinishScreen.value = true
    }

    override fun onDeleteBookClicked(position: Int) {
        val updatedList = model.removeBook(position)
        _updateBooksList.value = updatedList
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
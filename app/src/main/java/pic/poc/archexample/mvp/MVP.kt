package pic.poc.archexample.mvp

import kotlinx.coroutines.flow.StateFlow
import pic.poc.archexample.common.Book
import pic.poc.archexample.common.SortMethod

interface MVP {
    interface Model {
        fun getBooksList(): List<Book>
        fun addBook(book: Book): List<Book>
        fun removeBook(position: Int): List<Book>
    }

    interface View

    interface Presenter {
        val shouldFinishScreen: StateFlow<Boolean>
        val updateBooksList: StateFlow<List<Book>>
        val showLoading: StateFlow<Boolean>
        fun onBackClicked()
        fun onAddBookClicked(book: Book)
        fun onDeleteBookClicked(position: Int)
        fun onSortBookClicked(sortMethod: SortMethod)
    }
}
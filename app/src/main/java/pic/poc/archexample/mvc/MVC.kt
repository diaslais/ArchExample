package pic.poc.archexample.mvc

import kotlinx.coroutines.flow.StateFlow
import pic.poc.archexample.common.Book
import pic.poc.archexample.common.SortMethod

interface MVC {
    interface Model {
        val shouldFinishScreen: StateFlow<Boolean>
        val updateBooksList: StateFlow<List<Book>>
        val showLoading: StateFlow<Boolean>

        fun closeScreen()
        fun addBook(book: Book)
        fun deleteBook(position: Int)
        fun sortBooksList(sortMethod: SortMethod)
        fun showLoading(isLoading: Boolean)
    }

    interface View

    interface Controller {
        fun onBackClicked()
        fun onAddClicked(book: Book)
        fun onDeleteClicked(position: Int)
        fun onSortClicked(sortMethod: SortMethod)
    }
}
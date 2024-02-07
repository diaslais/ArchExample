package pic.poc.archexample.mvp

import pic.poc.archexample.common.Book
import pic.poc.archexample.common.SortMethod

interface MVP {
    interface Model {
        fun getBooksList(): List<Book>
        fun addBook(book: Book): List<Book>
        fun removeBook(position: Int): List<Book>
    }

    interface View {
        fun closeScreen()
        fun updateBooksList(books: List<Book>)
        fun showLoading(isLoading: Boolean)
    }

    interface Presenter {
        fun onBackClicked()
        fun onAddBookClicked(book: Book)
        fun onDeleteBookClicked(position: Int)
        fun onSortBookClicked(sortMethod: SortMethod)
    }
}
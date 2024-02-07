package pic.poc.archexample.mvvm

import pic.poc.archexample.common.Book

class MvvmModel: MVVM.Model {

    private var booksList = emptyList<Book>()

    override fun getBooksList(): List<Book> {
        return booksList
    }

    override fun addBook(book: Book): List<Book> {
        booksList = booksList + book
        return booksList
    }

    override fun removeBook(position: Int): List<Book> {
        booksList = booksList - booksList[position]
        return booksList
    }
}
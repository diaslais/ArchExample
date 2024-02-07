package pic.poc.archexample.mvp

import pic.poc.archexample.common.Book
import pic.poc.archexample.common.SortMethod

class MvpPresenter : MVP.Presenter {

    private val model = MvpModel()
    private var view: MVP.View? = null

    fun attachView(view: MVP.View) {
        this.view = view
    }

    fun detachView() {
        view = null
    }

    override fun onAddBookClicked(book: Book) {
        val updatedList = model.addBook(book)
        view?.updateBooksList(updatedList)
    }

    override fun onBackClicked() {
        view?.closeScreen()
    }

    override fun onDeleteBookClicked(position: Int) {
        val updatedList = model.removeBook(position)
        view?.updateBooksList(updatedList)
    }

    override fun onSortBookClicked(sortMethod: SortMethod) {
        val sortedList = when (sortMethod) {
            SortMethod.BY_TITLE -> model.getBooksList().sortedBy { it.title }
            SortMethod.BY_AUTHOR -> model.getBooksList().sortedBy { it.author }
            SortMethod.BY_YEAR -> model.getBooksList().sortedBy { it.year }
        }
        view?.updateBooksList(sortedList)
    }
}
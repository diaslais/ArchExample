package pic.poc.archexample.mvc

import pic.poc.archexample.common.Book
import pic.poc.archexample.common.SortMethod

class MvcController(private val model: MVC.Model) : MVC.Controller {

    override fun onBackClicked() {
        model.closeScreen()
    }

    override fun onAddClicked(book: Book) {
        model.showLoading(true)
        model.addBook(book)
        model.showLoading(false)
    }

    override fun onDeleteClicked(position: Int) {
        model.showLoading(true)
        model.deleteBook(position)
        model.showLoading(false)
    }

    override fun onSortClicked(sortMethod: SortMethod) {
        model.showLoading(true)
        model.sortBooksList(sortMethod)
        model.showLoading(false)
    }
}
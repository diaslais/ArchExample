package pic.poc.archexample.mvp

import android.os.Bundle
import pic.poc.archexample.common.Book
import pic.poc.archexample.common.BooksBaseActivity

class MvpActivity : BooksBaseActivity(), MVP.View {

    private val presenter = MvpPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("MVP")
        presenter.attachView(this)
    }

    override fun backClicked() {
        presenter.onBackClicked()
    }

    override fun addClicked() {
        presenter.onAddBookClicked(chooseBook())
    }

    override fun deleteClicked() {
        presenter.onDeleteBookClicked(0)
    }

    override fun sortClicked() {
        presenter.onSortBookClicked(chooseSortMethod())
    }

    override fun closeScreen() {
        finish()
    }

    override fun showLoading(isLoading: Boolean) {
        if (isLoading) showLoading() else hideLoading()
    }

    override fun updateBooksList(books: List<Book>) {
        update(books)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
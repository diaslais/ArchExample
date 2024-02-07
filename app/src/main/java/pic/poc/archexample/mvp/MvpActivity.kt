package pic.poc.archexample.mvp

import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import pic.poc.archexample.common.BooksBaseActivity

class MvpActivity : BooksBaseActivity(), MVP.View {

    private val presenter = MvpPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("MVP")

        lifecycleScope.launch {
            presenter.shouldFinishScreen
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect { if (it) finish() }
        }

        lifecycleScope.launch {
            presenter.showLoading
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect { if (it) showLoading() else hideLoading() }
        }

        lifecycleScope.launch {
            presenter.updateBooksList
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect { update(it) }
        }
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
}
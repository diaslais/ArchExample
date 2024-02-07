package pic.poc.archexample.mvvm

import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import pic.poc.archexample.common.BooksBaseActivity

class MvvmActivity : BooksBaseActivity(), MVVM.View {

    private val viewModel = MvvmViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("MVVM")

        lifecycleScope.launch {
            viewModel.shouldFinishScreen
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {
                    if (it) finish()
                }
        }

        lifecycleScope.launch {
            viewModel.updateBooksList
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {
                    update(it)
                }
        }

        lifecycleScope.launch {
            viewModel.showLoading
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {
                    if (it) showLoading() else hideLoading()
                }
        }
    }

    override fun backClicked() = viewModel.onBackClicked()
    override fun addClicked() = viewModel.onAddBookClicked(chooseBook())
    override fun deleteClicked() = viewModel.onDeleteBookClicked(0)
    override fun sortClicked() = viewModel.onSortBookClicked(chooseSortMethod())
}
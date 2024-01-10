package pic.poc.archexample.mvc

import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import pic.poc.archexample.common.BooksBaseActivity
import pic.poc.archexample.common.SortMethod

class MvcActivity : BooksBaseActivity(), MVC.View {

    private val model: MVC.Model = MvcModel()
    private val controller: MVC.Controller = MvcController(model)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("MVC")
        observeModel()
    }

    private fun observeModel() {
        lifecycleScope.launch {
            model.shouldFinishScreen
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {
                    if (it) finish()
                }
        }

        lifecycleScope.launch {
            model.updateBooksList
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {
                    update(it)
                }
        }

        lifecycleScope.launch {
            model.showLoading
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {
                    if (it) showLoading() else hideLoading()
                }
        }
    }

    override fun backClicked() = controller.onBackClicked()
    override fun addClicked() = controller.onAddClicked(chooseBook())
    override fun deleteClicked() = controller.onDeleteClicked(0)
    override fun sortClicked() = controller.onSortClicked(chooseSortMethod())
}
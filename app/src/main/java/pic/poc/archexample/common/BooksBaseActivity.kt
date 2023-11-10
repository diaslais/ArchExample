package pic.poc.archexample.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import pic.poc.archexample.databinding.ActivityBooksBinding

abstract class BooksBaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBooksBinding
    private val booksAdapter = BooksAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBooksBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBack.setOnClickListener { backClicked() }
        binding.btnAdd.setOnClickListener { addClicked() }
        binding.btnDelete.setOnClickListener { deleteClicked() }
        binding.btnSort.setOnClickListener { sortClicked() }
        with(binding.rvBooks) {
            layoutManager = LinearLayoutManager(context)
            adapter = booksAdapter
        }
    }

    protected fun setTitle(title: String) = with(binding.txtTitle) { text = title }
    protected fun update(books: List<Book>) = booksAdapter.submitList(books)
    protected fun showLoading() = with(binding.loading) { isVisible = true }
    protected fun hideLoading() = with(binding.loading) { isVisible = false }

    protected abstract fun backClicked()
    protected abstract fun addClicked()
    protected abstract fun deleteClicked()
    protected abstract fun sortClicked()
}
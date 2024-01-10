package pic.poc.archexample.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import pic.poc.archexample.databinding.ActivityBooksBinding

abstract class BooksBaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBooksBinding
    private val booksAdapter = BooksAdapter()
    private var sortMethod: SortMethod = SortMethod.BY_TITLE

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
    protected fun chooseSortMethod(): SortMethod {
        sortMethod = if (sortMethod == SortMethod.BY_TITLE) {
            SortMethod.BY_YEAR
        } else {
            SortMethod.BY_TITLE
        }
        return sortMethod
    }

    private val books = mutableListOf<Book>(
        Book(1, "The Lord of the Rings", "J. R. R. Tolkien", "1990"),
        Book(2, "The Hobbit", "J. R. R. Tolkien", "1992"),
        Book(3, "The Fellowship of the Ring", "J. R. R. Tolkien", "1993"),
        Book(4, "The Two Towers", "J. R. R. Tolkien", "1994"),
        Book(5, "The Return of the King", "J. R. R. Tolkien", "1995"),
        Book(6, "The Silmarillion", "J. R. R. Tolkien", "1996"),
        Book(7, "The Children of Húrin", "J. R. R. Tolkien", "1997"),
        Book(8, "Unfinished Tales", "J. R. R. Tolkien", "1998"),
        Book(9, "The Fall of Gondolin", "J. R. R. Tolkien", "1999"),
        Book(10, "The Book of Lost Tales", "J. R. R. Tolkien", "2000"),
    )

    protected fun chooseBook(): Book {
        val book = books.random()
        books.remove(book)
        return book
    }
}
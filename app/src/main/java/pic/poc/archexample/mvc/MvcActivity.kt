package pic.poc.archexample.mvc

import android.os.Bundle
import pic.poc.archexample.common.Book
import pic.poc.archexample.common.BooksBaseActivity

class MvcActivity : BooksBaseActivity(), MVC.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("MVC")
    }

    //TODO: Implement properly
    override fun backClicked() = finish()
    override fun addClicked() = update(
        listOf(
            Book("Oi0", "Tchau", "2001"),
            Book("Oi1", "Tchau", "2001"),
            Book("Oi2", "Tchau", "2001"),
            Book("Oi3", "Tchau", "2001"),
            Book("Oi4", "Tchau", "2001"),
            Book("Oi5", "Tchau", "2001"),
            Book("Oi6", "Tchau", "2001"),
            Book("Oi7", "Tchau", "2001"),
            Book("Oi8", "Tchau", "2001"),
            Book("Oi9", "Tchau", "2001")
        )
    )
    override fun deleteClicked() = update(emptyList())
    override fun sortClicked() = Unit
}
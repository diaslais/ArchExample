package pic.poc.archexample.mvp

import android.os.Bundle
import pic.poc.archexample.common.Book
import pic.poc.archexample.common.BooksBaseActivity

class MvpActivity : BooksBaseActivity(), MVP.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("MVP")
    }

    //TODO: Implement properly
    override fun backClicked() = finish()
    override fun addClicked() = Unit
    override fun deleteClicked() = Unit
    override fun sortClicked() = Unit
}
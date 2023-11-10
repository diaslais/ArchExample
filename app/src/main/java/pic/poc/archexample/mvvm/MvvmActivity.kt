package pic.poc.archexample.mvvm

import android.os.Bundle
import pic.poc.archexample.common.BooksBaseActivity

class MvvmActivity : BooksBaseActivity(), MVVM.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("MVVM")
    }

    //TODO: Implement properly
    override fun backClicked() = finish()
    override fun addClicked() = Unit
    override fun deleteClicked() = Unit
    override fun sortClicked() = Unit
}
package pic.poc.archexample.mvc

import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import pic.poc.archexample.common.Book
import pic.poc.archexample.common.SortMethod

class MvcControllerTest {

    private val model: MvcModel = mockk(relaxed = true)
    private val controller = MvcController(model)

    @Test
    fun `onBackClicked should call model's closeScreen`() {
        // When
        controller.onBackClicked()

        // Then
        verify {
            model.closeScreen()
        }
    }

    @Test
    fun `onAddClicked should call model's showLoading and addBook`() {
        // Given
        val book = Book(0, "Title", "Author", "2021")

        // When
        controller.onAddClicked(book)

        // Then
        verify {
            model.showLoading(true)
            model.addBook(book)
            model.showLoading(false)
        }
    }

    @Test
    fun `onDeleteClicked should call model's showLoading and deleteBook`() {
        // When
        controller.onDeleteClicked(0)

        // Then
        verify {
            model.showLoading(true)
            model.deleteBook(0)
            model.showLoading(false)
        }
    }

    @Test
    fun `onSortClicked should call model's showLoading and sortBooksList`() {
        // Given
        val sortMethod = SortMethod.BY_TITLE

        // When
        controller.onSortClicked(sortMethod)

        // Then
        verify {
            model.showLoading(true)
            model.sortBooksList(sortMethod)
            model.showLoading(false)
        }
    }
}
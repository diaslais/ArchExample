package pic.poc.archexample.mvp

import org.junit.Assert.assertEquals
import org.junit.Test
import pic.poc.archexample.common.Book

class MvpModelTest {

    private val model = MvpModel()

    @Test
    fun `getBooksList should return a list of books`() {
        // Given
        val book = Book(1, "Title", "Author", "2021")
        val updatedBooksList = listOf(book)
        model.addBook(book)

        // When
        val booksList = model.getBooksList()

        // Then
        assertEquals(updatedBooksList, booksList)
    }

    @Test
    fun `addBook should add a book to the list`() {
        // Given
        val book = Book(1, "Title", "Author", "2021")
        val updatedBooksList = listOf(book)

        // When
        model.addBook(book)

        // Then
        assertEquals(updatedBooksList, model.getBooksList())
    }

    @Test
    fun `removeBook should remove a book from the list`() {
        // Given
        val book = Book(1, "Title", "Author", "2021")
        model.addBook(book)

        // When
        model.removeBook(0)

        // Then
        assertEquals(emptyList<Book>(), model.getBooksList())
    }
}
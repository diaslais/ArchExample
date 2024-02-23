package pic.poc.archexample.mvvm

import org.junit.Assert.assertEquals
import org.junit.Test
import pic.poc.archexample.common.Book

class MvvmModelTest {

    private val model = MvvmModel()

    @Test
    fun `getBooksList should return the list of books`() {
        // Given
        val book = Book(1, "Title", "Author", "2021")
        val updatedBooksList = listOf(book)
        model.addBook(book)

        // When
        val result = model.getBooksList()

        // Then
        assertEquals(updatedBooksList, result)
    }

    @Test
    fun `addBook should add a book to the list and return the updated list`() {
        // Given
        val book = Book(1, "Title", "Author", "2021")
        val updatedBooksList = listOf(book)

        // When
        val result = model.addBook(book)

        // Then
        assertEquals(updatedBooksList, result)
    }

    @Test
    fun `removeBook should remove a book from the list and return the updated list`() {
        // Given
        val book = Book(1, "Title", "Author", "2021")
        model.addBook(book)
        val updatedBooksList = emptyList<Book>()

        // When
        val result = model.removeBook(0)

        // Then
        assertEquals(updatedBooksList, result)
    }
}
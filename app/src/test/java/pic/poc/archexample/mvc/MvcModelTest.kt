package pic.poc.archexample.mvc

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import pic.poc.archexample.common.Book
import pic.poc.archexample.common.SortMethod

class MvcModelTest {

    private val model = MvcModel()

    @Test
    fun `closeScreen should set shouldFinishScreen to true`() = runTest {
        // When
        model.closeScreen()

        // Then
        assertTrue(model.shouldFinishScreen.value)
    }

    @Test
    fun `addBook should add a book to the list`() = runTest {
        // Given
        val book = Book(1, "Title", "Author", "2021")
        val updatedBooksList = listOf(book)

        // When
        model.addBook(book)

        // Then
        assertEquals(updatedBooksList, model.updateBooksList.value)
    }

    @Test
    fun `deleteBook should remove a book from the list`() = runTest {
        // Given
        val book = Book(1, "Title", "Author", "2021")
        model.addBook(book)

        // When
        model.deleteBook(0)

        // Then
        assertEquals(emptyList<Book>(), model.updateBooksList.value)
    }

    @Test
    fun `sortBooksList should sort the list by title`() = runTest {
        // Given
        val book1 = Book(1, "B", "Author", "2021")
        val book2 = Book(2, "A", "Author", "2021")
        val book3 = Book(3, "C", "Author", "2021")
        val sortedBooksList = listOf(book2, book1, book3)

        // When
        model.addBook(book1)
        model.addBook(book2)
        model.addBook(book3)
        model.sortBooksList(SortMethod.BY_TITLE)

        // Then
        assertEquals(sortedBooksList, model.updateBooksList.value)
    }

    @Test
    fun `sortBooksList should sort the list by author`() = runTest {
        // Given
        val book1 = Book(1, "Title", "B", "2021")
        val book2 = Book(2, "Title", "A", "2021")
        val book3 = Book(3, "Title", "C", "2021")
        val sortedBooksList = listOf(book2, book1, book3)

        // When
        model.addBook(book1)
        model.addBook(book2)
        model.addBook(book3)
        model.sortBooksList(SortMethod.BY_AUTHOR)

        // Then
        assertEquals(sortedBooksList, model.updateBooksList.value)
    }

    @Test
    fun `sortBooksList should sort the list by year`() = runTest {
        // Given
        val book1 = Book(1, "Title", "Author", "2021")
        val book2 = Book(2, "Title", "Author", "2020")
        val book3 = Book(3, "Title", "Author", "2022")
        val sortedBooksList = listOf(book2, book1, book3)

        // When
        model.addBook(book1)
        model.addBook(book2)
        model.addBook(book3)
        model.sortBooksList(SortMethod.BY_YEAR)

        // Then
        assertEquals(sortedBooksList, model.updateBooksList.value)
    }

    @Test
    fun `showLoading should set showLoading to true`() = runTest {
        // When
        model.showLoading(true)

        // Then
        assertTrue(model.showLoading.value)
    }
}
package pic.poc.archexample.mvvm

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import pic.poc.archexample.common.Book
import pic.poc.archexample.common.SortMethod

class MvvmViewModelTest {

    private val viewModel = MvvmViewModel()

    @Test
    fun `onBackClicked should set shouldFinishScreen to true`() = runTest {
        // When
        viewModel.onBackClicked()

        // Then
        assertTrue(viewModel.shouldFinishScreen.value)
    }

    @Test
    fun `onAddBookClicked should add a book to the list`() = runTest {
        // Given
        val book = Book(1, "Title", "Author", "2021")
        val updatedBooksList = listOf(book)

        // When
        viewModel.onAddBookClicked(book)

        // Then
        assertEquals(updatedBooksList, viewModel.updateBooksList.value)
    }

    @Test
    fun `onDeleteBookClicked should remove a book from the list`() = runTest {
        // Given
        val book = Book(1, "Title", "Author", "2021")
        viewModel.onAddBookClicked(book)

        // When
        viewModel.onDeleteBookClicked(0)

        // Then
        assertEquals(emptyList<Book>(), viewModel.updateBooksList.value)
    }

    @Test
    fun `onSortBookClicked should sort the list by title`() = runTest {
        // Given
        val book1 = Book(1, "B", "Author", "2021")
        val book2 = Book(2, "A", "Author", "2021")
        val book3 = Book(3, "C", "Author", "2021")
        val sortedBooksList = listOf(book2, book1, book3)
        viewModel.onAddBookClicked(book1)
        viewModel.onAddBookClicked(book2)
        viewModel.onAddBookClicked(book3)

        // When
        viewModel.onSortBookClicked(SortMethod.BY_TITLE)

        // Then
        assertEquals(sortedBooksList, viewModel.updateBooksList.value)
    }

    @Test
    fun `onSortBookClicked should sort the list by author`() = runTest {
        // Given
        val book1 = Book(1, "Title", "B", "2021")
        val book2 = Book(2, "Title", "A", "2021")
        val book3 = Book(3, "Title", "C", "2021")
        val sortedBooksList = listOf(book2, book1, book3)
        viewModel.onAddBookClicked(book1)
        viewModel.onAddBookClicked(book2)
        viewModel.onAddBookClicked(book3)

        // When
        viewModel.onSortBookClicked(SortMethod.BY_AUTHOR)

        // Then
        assertEquals(sortedBooksList, viewModel.updateBooksList.value)
    }

    @Test
    fun `onSortBookClicked should sort the list by year`() = runTest {
        // Given
        val book1 = Book(1, "Title", "Author", "2021")
        val book2 = Book(2, "Title", "Author", "2020")
        val book3 = Book(3, "Title", "Author", "2022")
        val sortedBooksList = listOf(book2, book1, book3)
        viewModel.onAddBookClicked(book1)
        viewModel.onAddBookClicked(book2)
        viewModel.onAddBookClicked(book3)

        // When
        viewModel.onSortBookClicked(SortMethod.BY_YEAR)

        // Then
        assertEquals(sortedBooksList, viewModel.updateBooksList.value)
    }
}
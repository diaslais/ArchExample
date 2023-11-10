package pic.poc.archexample.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import pic.poc.archexample.databinding.ItemBookBinding
import pic.poc.archexample.common.BooksAdapter.BookViewHolder

class BooksAdapter : ListAdapter<Book, BookViewHolder>(DiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): BookViewHolder =
        BookViewHolder(ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) =
        holder bind currentList[position]

    override fun getItemViewType(position: Int) = position

    class BookViewHolder(private val binding: ItemBookBinding) : ViewHolder(binding.root) {
        infix fun bind(book: Book) = with(binding) {
            txtTitle.text = book.title
            txtAuthor.text = book.author
            txtDate.text = book.date
        }
    }

    class DiffUtil : ItemCallback<Book>() {
        override fun areItemsTheSame(old: Book, new: Book) = old == new
        override fun areContentsTheSame(old: Book, new: Book) = old == new
        override fun getChangePayload(old: Book, new: Book): Any {
            val diff = Bundle()
            if (old.title != new.title) diff.putString("title", new.title)
            if (old.author != new.author) diff.putString("author", new.author)
            if (old.date != new.date) diff.putString("date", new.date)
            return diff
        }
    }
}

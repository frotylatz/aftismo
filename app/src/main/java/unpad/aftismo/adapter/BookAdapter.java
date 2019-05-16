package unpad.aftismo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import unpad.aftismo.R;
import unpad.aftismo.model.BookResult;
import unpad.aftismo.utils.Common;

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder> {

    Context context;
    List<BookResult> bookList;

    public BookAdapter(Context context, List<BookResult> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.book_item_layout,viewGroup,false);
        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder bookViewHolder, int i) {
        bookViewHolder.bookId.setText(new StringBuilder("#").append(bookList.get(i).getBook_id()));
        bookViewHolder.bookPrice.setText(new StringBuilder("Rp ").append(bookList.get(i).getBook_price()));
        bookViewHolder.bookName.setText(bookList.get(i).getBook_tutor());
        bookViewHolder.bookDate.setText(bookList.get(i).getBook_date());
        bookViewHolder.bookTime.setText(bookList.get(i).getBook_time());
        bookViewHolder.bookStatus.setText(new StringBuilder("Order Status: ").append(Common.convertCodeToStatus(bookList.get(i).getBook_status())));
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
}

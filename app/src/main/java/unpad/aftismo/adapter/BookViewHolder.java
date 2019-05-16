package unpad.aftismo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import unpad.aftismo.R;
public class BookViewHolder extends RecyclerView.ViewHolder{
    public TextView bookId, bookPrice, bookName, bookDate, bookTime, bookStatus;

    public BookViewHolder(View itemView) {
        super(itemView);
        bookId = itemView.findViewById(R.id.bookId);
        bookPrice = itemView.findViewById(R.id.bookPrice);
        bookName = itemView.findViewById(R.id.bookName);
        bookDate = itemView.findViewById(R.id.bookDate);
        bookTime = itemView.findViewById(R.id.bookTime);
        bookStatus = itemView.findViewById(R.id.bookStatus);
    }

}

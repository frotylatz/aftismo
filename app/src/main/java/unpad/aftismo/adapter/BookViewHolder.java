package unpad.aftismo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import unpad.aftismo.ItemClickListener;
import unpad.aftismo.R;
public class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView bookId, bookPrice, bookName, bookDate, bookTime, bookStatus, bookLoc;
    public ImageView bookImg;
    ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public BookViewHolder(View itemView) {
        super(itemView);
        //bookId = itemView.findViewById(R.id.bookId);
        bookLoc = itemView.findViewById(R.id.bookLocation);
        //bookPrice = itemView.findViewById(R.id.bookPrice);
        bookImg = itemView.findViewById(R.id.bookImg);
        bookName = itemView.findViewById(R.id.bookName);
        bookDate = itemView.findViewById(R.id.bookDate);
        bookTime = itemView.findViewById(R.id.bookTime);
        bookStatus = itemView.findViewById(R.id.bookStatus);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v);
    }

}

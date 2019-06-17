package unpad.aftismo.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.net.URLEncoder;
import java.util.List;

import okhttp3.internal.Util;
import unpad.aftismo.BookTutorActivity;
import unpad.aftismo.ItemClickListener;
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
        View itemView = LayoutInflater.from(context).inflate(R.layout.book_item_layout, viewGroup, false);
        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder bookViewHolder, int i) {
        //bookViewHolder.bookId.setText(new StringBuilder("#").append(bookList.get(i).getBook_id()));
        //bookViewHolder.bookPrice.setText(new StringBuilder("Rp ").append(bookList.get(i).getBook_price()));
        bookViewHolder.bookName.setText(bookList.get(i).getBook_tutor());
        bookViewHolder.bookLoc.setText(bookList.get(i).getBook_tutorloc());
        bookViewHolder.bookDate.setText(bookList.get(i).getBook_date());
        bookViewHolder.bookTime.setText(bookList.get(i).getBook_time());
        bookViewHolder.bookStatus.setText(Common.convertCodeToStatus(bookList.get(i).getBook_status()));
        Picasso.get()
                .load("https://www.flynz.co.nz/wp-content/uploads/profile-placeholder.png")
                .into(bookViewHolder.bookImg);

        if (bookList.get(i).getBook_status() == 1) {
            bookViewHolder.setItemClickListener(new ItemClickListener() {
                @Override
                public void onClick(View view) {
                    PackageManager packageManager = context.getPackageManager();
                    Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                    String phone = bookList.get(i).getTutor_phone();
                    String message = "Halo " + bookList.get(i).getBook_tutor();

                    try {
                        String url = "https://api.whatsapp.com/send?phone=" + phone + "&text=" + URLEncoder.encode(message, "UTF-8");
                        sendIntent.setPackage("com.whatsapp");
                        sendIntent.setData(Uri.parse(url));
                        if (sendIntent.resolveActivity(packageManager) != null) {
                            context.startActivity(sendIntent);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
        } else if (bookList.get(i).getBook_status() == 1) {
            bookViewHolder.setItemClickListener(new ItemClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Pertemuanmu belum disetujui!", Toast.LENGTH_SHORT).show();
                }
            });
        } else if (bookList.get(i).getBook_status() == 3) {
            bookViewHolder.setItemClickListener(new ItemClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Pertemuanmu ditolak!", Toast.LENGTH_SHORT).show();
                }
            });
        } else if (bookList.get(i).getBook_status() == 2) {
            bookViewHolder.setItemClickListener(new ItemClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Pertemuanmu sudah selesai!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
}

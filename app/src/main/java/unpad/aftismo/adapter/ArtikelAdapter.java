package unpad.aftismo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import unpad.aftismo.BookTutorActivity;
import unpad.aftismo.R;
import unpad.aftismo.model.Artikel;

public class ArtikelAdapter extends RecyclerView.Adapter<ArtikelViewHolder> {

    Context context;
    List<Artikel> artikelList;

    public ArtikelAdapter(Context context, List<Artikel> artikelList) {
        this.context = context;
        this.artikelList = artikelList;
    }

    @NonNull
    @Override
    public ArtikelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.artikel_item_layout, viewGroup, false);
        return new ArtikelViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtikelViewHolder artikelViewHolder, int i) {
        //Load image
        Picasso.get()
                .load(artikelList.get(i).Picture)
                .into(artikelViewHolder.imgArtikel);

        artikelViewHolder.judulArtikel.setText(artikelList.get(i).Judul);
        artikelViewHolder.judulArtikel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ArtikelActivity.class);
                intent.putExtra("link", artikelList.get(i).Link);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return artikelList.size();
    }
}
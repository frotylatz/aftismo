package unpad.aftismo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.joooonho.SelectableRoundedImageView;

import unpad.aftismo.R;

public class ArtikelViewHolder extends RecyclerView.ViewHolder{
    SelectableRoundedImageView imgArtikel;
    TextView judulArtikel;

    public ArtikelViewHolder(@NonNull View itemView) {
        super(itemView);

        imgArtikel = itemView.findViewById(R.id.imgArtikel);
        judulArtikel = itemView.findViewById(R.id.judulArtikel);
    }
}

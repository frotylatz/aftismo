package unpad.aftismo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.joooonho.SelectableRoundedImageView;

import unpad.aftismo.ItemClickListener;
import unpad.aftismo.R;

public class ArtikelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    SelectableRoundedImageView imgArtikel;
    TextView judulArtikel;

    ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public ArtikelViewHolder(@NonNull View itemView) {
        super(itemView);

        imgArtikel = itemView.findViewById(R.id.imgArtikel);
        judulArtikel = itemView.findViewById(R.id.judulArtikel);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v);
    }
}

package unpad.aftismo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import unpad.aftismo.ItemClickListener;
import unpad.aftismo.R;

public class TutorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    CircleImageView imgTutor;
    TextView namaTutor, hargaTutor, lokasiTutor, tvSkill1, tvSkill2, skillPlus3, skillPlus2, skillPlus1;
    Button btnBook;
    ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public TutorViewHolder (View itemView){
        super(itemView);

        imgTutor = itemView.findViewById(R.id.imgTutor);
        namaTutor = itemView.findViewById(R.id.namaTutor);
        hargaTutor = itemView.findViewById(R.id.hargaTutor);
        lokasiTutor = itemView.findViewById(R.id.lokasiTutor);
        btnBook = itemView.findViewById(R.id.btnBook);
        tvSkill1 = itemView.findViewById(R.id.tvSkill1);
        tvSkill2 = itemView.findViewById(R.id.tvSkill2);
        skillPlus1 = itemView.findViewById(R.id.skillPlus1);
        skillPlus2 = itemView.findViewById(R.id.skillPlus2);
        skillPlus3 = itemView.findViewById(R.id.skillPlus3);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v);
    }

}

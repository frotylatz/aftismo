package unpad.aftismo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import unpad.aftismo.R;

public class TutorViewHolder extends RecyclerView.ViewHolder{
    CircleImageView imgTutor;
    TextView namaTutor, hargaTutor, lokasiTutor;

    public TutorViewHolder (View itemView){
        super(itemView);

        imgTutor = itemView.findViewById(R.id.imgTutor);
        namaTutor = itemView.findViewById(R.id.namaTutor);
        hargaTutor = itemView.findViewById(R.id.hargaTutor);
        lokasiTutor = itemView.findViewById(R.id.lokasiTutor);
    }

}

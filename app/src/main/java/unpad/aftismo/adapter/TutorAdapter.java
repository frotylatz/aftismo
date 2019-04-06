package unpad.aftismo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import unpad.aftismo.R;
import unpad.aftismo.model.Tutor;

public class TutorAdapter extends RecyclerView.Adapter<TutorViewHolder> {

    Context context;
    List<Tutor> tutorList;

    public TutorAdapter(Context context, List<Tutor> tutorList) {
        this.context = context;
        this.tutorList = tutorList;
    }

    @NonNull
    @Override
    public TutorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.tutor_item_layout, viewGroup, false);
        return new TutorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TutorViewHolder tutorViewHolder, int i) {
        //Load image
        Picasso.get()
                .load(tutorList.get(i).Picture)
                .into(tutorViewHolder.imgTutor);

        NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMAN);
        DecimalFormat df = (DecimalFormat)nf;

        DecimalFormat kursIdr = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp ");
        formatRp.setGroupingSeparator('.');
        kursIdr.setDecimalFormatSymbols(formatRp);

        tutorViewHolder.namaTutor.setText(tutorList.get(i).Nama);
        tutorViewHolder.hargaTutor.setText(kursIdr.format(Long.valueOf(tutorList.get(i).Price)) + " / jam");
        tutorViewHolder.lokasiTutor.setText(tutorList.get(i).Lokasi);
    }

    @Override
    public int getItemCount() {
        return tutorList.size();
    }
}

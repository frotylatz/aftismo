package unpad.aftismo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import unpad.aftismo.BookTutorActivity;
import unpad.aftismo.ItemClickListener;
import unpad.aftismo.MainActivity;
import unpad.aftismo.R;
import unpad.aftismo.RegisterAcitivity;
import unpad.aftismo.model.Tutor;
import unpad.aftismo.utils.Common;

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
        tutorViewHolder.tvSkill1.setText(tutorList.get(i).SkillSatu);
        tutorViewHolder.tvSkill2.setText(tutorList.get(i).SkillDua);

        String skill1 = tutorList.get(i).getSkillSatu();
        String skill2 = tutorList.get(i).getSkillDua();
        String skill3 = tutorList.get(i).getSkillTiga();
        String skill4 = tutorList.get(i).getSkillEmpat();
        String skill5 = tutorList.get(i).getSkillLima();

        if (!skill5.isEmpty()){
            tutorViewHolder.skillPlus3.setVisibility(View.VISIBLE);
        } else if (!skill4.isEmpty()&& skill5.isEmpty()){
            tutorViewHolder.skillPlus2.setVisibility(View.VISIBLE);
        } else if (!skill3.isEmpty() && skill4.isEmpty()){
            tutorViewHolder.skillPlus1.setVisibility(View.VISIBLE);
        }


        if(skill2.equals("")){
            tutorViewHolder.tvSkill2.setVisibility(View.INVISIBLE);
        } else if (skill1.equals("")){
            tutorViewHolder.tvSkill1.setVisibility(View.INVISIBLE);
            tutorViewHolder.tvSkill2.setVisibility(View.INVISIBLE);
        }

        tutorViewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view) {
                showTutorDetail(i);
            }
        });
    }

    private void showTutorDetail(int i) {
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMAN);
        DecimalFormat df = (DecimalFormat)nf;

        DecimalFormat kursIdr = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp ");
        formatRp.setGroupingSeparator('.');
        kursIdr.setDecimalFormatSymbols(formatRp);

        Intent intent = new Intent(context, BookTutorActivity.class);
        intent.putExtra("nama", tutorList.get(i).Nama);
        intent.putExtra("tutorphone", tutorList.get(i).Tutor_Phone);
        intent.putExtra("harga", kursIdr.format(Long.valueOf(tutorList.get(i).Price)) + " / jam");
        intent.putExtra("hargatok", tutorList.get(i).Price);
        intent.putExtra("lokasi", tutorList.get(i).Lokasi);
        intent.putExtra("gambar", String.valueOf(tutorList.get(i).Picture));
        intent.putExtra("skill1", tutorList.get(i).SkillSatu);
        intent.putExtra("skill2", tutorList.get(i).SkillDua);
        intent.putExtra("skill3", tutorList.get(i).SkillTiga);
        intent.putExtra("skill4", tutorList.get(i).SkillEmpat);
        intent.putExtra("skill5", tutorList.get(i).SkillLima);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return tutorList.size();
    }
}

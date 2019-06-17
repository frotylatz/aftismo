package unpad.aftismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import unpad.aftismo.R;

public class BookTutorActivity extends AppCompatActivity {

    String nama, harga, lokasi, gambar, tutorphone, hargatok, skill1, skill2, skill3, skill4, skill5;
    TextView namaBookTutor, hargaBookTutor, lokasiBookTutor, tvSkill1, tvSkill2, tvSkill3, tvSkill4, tvSkill5;
    ImageView imgBookTutor;
    Button btnBookSekarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_tutor);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent i = getIntent();
        nama = i.getStringExtra("nama");
        harga = i.getStringExtra("harga");
        tutorphone = i.getStringExtra("tutorphone");
        hargatok = i.getStringExtra("hargatok");
        lokasi = i.getStringExtra("lokasi");
        gambar = i.getStringExtra("gambar");
        skill1 = i.getStringExtra("skill1");
        skill2 = i.getStringExtra("skill2");
        skill3 = i.getStringExtra("skill3");
        skill4 = i.getStringExtra("skill4");
        skill5 = i.getStringExtra("skill5");

        namaBookTutor = findViewById(R.id.namaBookTutor);
        hargaBookTutor = findViewById(R.id.hargaBookTutor);
        lokasiBookTutor = findViewById(R.id.lokasiBookTutor);
        imgBookTutor = findViewById(R.id.imgBookTutor);
        btnBookSekarang = findViewById(R.id.btnBookSekarang);
        tvSkill1 = findViewById(R.id.tvSkill1);
        tvSkill2 = findViewById(R.id.tvSkill2);
        tvSkill3 = findViewById(R.id.tvSkill3);
        tvSkill4 = findViewById(R.id.tvSkill4);
        tvSkill5 = findViewById(R.id.tvSkill5);
        btnBookSekarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookTutorActivity.this, BookingActivity.class);
                intent.putExtra("nama", nama);
                intent.putExtra("hargatok", hargatok);
                intent.putExtra("lokasi", lokasi);
                intent.putExtra("tutorphone", tutorphone);
                startActivity(intent);
            }
        });

        namaBookTutor.setText(nama);
        hargaBookTutor.setText(harga);
        lokasiBookTutor.setText(lokasi);
        Picasso.get()
                .load(gambar)
                .into(imgBookTutor);
        tvSkill1.setText(skill1);
        tvSkill2.setText(skill2);
        tvSkill3.setText(skill3);
        tvSkill4.setText(skill4);
        tvSkill5.setText(skill5);

        if(skill2.equals("")){
            tvSkill2.setVisibility(View.INVISIBLE);
            tvSkill3.setVisibility(View.INVISIBLE);
            tvSkill4.setVisibility(View.INVISIBLE);
            tvSkill5.setVisibility(View.INVISIBLE);
        } else if (skill3.equals("")){
            tvSkill3.setVisibility(View.INVISIBLE);
            tvSkill4.setVisibility(View.INVISIBLE);
            tvSkill5.setVisibility(View.INVISIBLE);
        } else if (skill4.equals("")){
            tvSkill4.setVisibility(View.INVISIBLE);
            tvSkill5.setVisibility(View.INVISIBLE);
        } else if (skill5.equals("")){
            tvSkill5.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

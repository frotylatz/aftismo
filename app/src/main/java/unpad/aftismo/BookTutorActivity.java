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

    String nama, harga, lokasi, gambar, hargatok;
    TextView namaBookTutor, hargaBookTutor, lokasiBookTutor;
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
        hargatok = i.getStringExtra("hargatok");
        lokasi = i.getStringExtra("lokasi");
        gambar = i.getStringExtra("gambar");

        namaBookTutor = findViewById(R.id.namaBookTutor);
        hargaBookTutor = findViewById(R.id.hargaBookTutor);
        lokasiBookTutor = findViewById(R.id.lokasiBookTutor);
        imgBookTutor = findViewById(R.id.imgBookTutor);
        btnBookSekarang = findViewById(R.id.btnBookSekarang);
        btnBookSekarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookTutorActivity.this, BookingActivity.class);
                intent.putExtra("nama", nama);
                intent.putExtra("hargatok", hargatok);
                startActivity(intent);
            }
        });

        namaBookTutor.setText(nama);
        hargaBookTutor.setText(harga);
        lokasiBookTutor.setText(lokasi);
        Picasso.get()
                .load(gambar)
                .into(imgBookTutor);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

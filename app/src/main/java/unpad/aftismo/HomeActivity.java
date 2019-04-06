package unpad.aftismo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import unpad.aftismo.adapter.ArtikelAdapter;
import unpad.aftismo.model.Artikel;
import unpad.aftismo.retrofit.ApiInterface;
import unpad.aftismo.utils.Common;

public class HomeActivity extends AppCompatActivity {

    ImageView ivTutor;
    ApiInterface mService;
    CompositeDisposable compositeDisposable;
    RecyclerView listArtikel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        compositeDisposable = new CompositeDisposable();
        mService = Common.getApi();

        BottomNavigationView bottomNavigationView= findViewById(R.id.navigation);

        ivTutor = findViewById(R.id.btnTutor);
        ivTutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ListTutorActivity.class));
            }
        });

        listArtikel = findViewById(R.id.list_artikel);
        listArtikel.setLayoutManager(new LinearLayoutManager(this));
        listArtikel.setHasFixedSize(true);

        getArtikel();
    }

    private void getArtikel() {
        compositeDisposable.add(mService.getArtikel()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(new Consumer<List<Artikel>>() {
            @Override
            public void accept(List<Artikel> artikels) throws Exception {
                displayArtikelList(artikels);
            }
        }));
    }

    private void displayArtikelList(List<Artikel> artikels) {
        ArtikelAdapter adapter = new ArtikelAdapter(this, artikels);
        listArtikel.setAdapter(adapter);
    }
}

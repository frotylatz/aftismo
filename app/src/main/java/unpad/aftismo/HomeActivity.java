package unpad.aftismo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.squareup.picasso.Picasso;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import unpad.aftismo.adapter.ArtikelAdapter;
import unpad.aftismo.model.Artikel;
import unpad.aftismo.retrofit.ApiInterface;
import unpad.aftismo.utils.Common;

public class HomeActivity extends AppCompatActivity {

    ImageView ivTutor, ivPecs;
    ApiInterface mService;
    CompositeDisposable compositeDisposable;
    RecyclerView listArtikel;
    Button logoutBtn;
    private Context mContext = HomeActivity.this;
    private static final int ACTIVITY_NUM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setUpBottomNavigationView();

        compositeDisposable = new CompositeDisposable();
        mService = Common.getApi();

        JCVideoPlayerStandard jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.videoplayer);
        jcVideoPlayerStandard.setUp("http://coinbkt.com/aftismo/pecs.mp4"
                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "");

        Picasso.get()
                .load("https://i.ytimg.com/vi/Hs-412lhXb0/hqdefault.jpg?sqp=-oaymwEZCPYBEIoBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLDY4Hkyd5ZM6BWMLbObRt4FfK5_0g")
                .into(jcVideoPlayerStandard.thumbImageView);

        ivTutor = findViewById(R.id.btnTutor);
        ivTutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ListTutorActivity.class));
            }
        });

        ivPecs = findViewById(R.id.btnPecs);
        ivPecs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, PecsActivity.class));
                finish();
            }
        });

        listArtikel = findViewById(R.id.list_artikel);
        listArtikel.setLayoutManager(new LinearLayoutManager(this));
        listArtikel.setHasFixedSize(true);

        getArtikel();
    }

    private void setUpBottomNavigationView() {
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.navigation);
        Common.setupBottomNavigationView(bottomNavigationViewEx);
        Common.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
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

    //Exit when BACK buton clicked
    boolean isBackButtonClicked = false;

    @Override
    public void onBackPressed() {
        if(isBackButtonClicked) {
            super.onBackPressed();
            return;
        }
        else if (JCVideoPlayer.backPress()) {
            return;
        }
        this.isBackButtonClicked = true;
        Toast.makeText(this, "Please click BACK again to exit this application", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        isBackButtonClicked = false;
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}

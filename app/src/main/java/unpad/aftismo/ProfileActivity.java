package unpad.aftismo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.accountkit.Account;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitCallback;
import com.facebook.accountkit.AccountKitError;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import unpad.aftismo.model.CheckUserResponse;
import unpad.aftismo.model.User;
import unpad.aftismo.retrofit.ApiInterface;
import unpad.aftismo.utils.Common;

import static org.json.JSONObject.NULL;

public class ProfileActivity extends AppCompatActivity {

    Button logoutBtn;
    Context mContext = ProfileActivity.this;
    private static final int ACTIVITY_NUM = 3;
    TextView tvNama, tvNomorHp, tvAlamat, tvUbah, tvAlamatAda;
    SwipeRefreshLayout swipeRefreshLayout;
    ApiInterface mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbarProfile);
        setSupportActionBar(toolbar);

        setUpBottomNavigationView();

        logoutBtn = findViewById(R.id.logoutBtn);
        logoutBtn.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
            builder.setTitle("Exit Application");
            builder.setMessage("Do you want to exit this application?");

            builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    AccountKit.logOut();

                    //Clear all activities
                    Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            });

            builder.setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });

            builder.show();
        });

        tvNama = findViewById(R.id.tvNama);
        tvNomorHp = findViewById(R.id.tvNomorHp);
        tvAlamatAda = findViewById(R.id.tvAlamatAda);
        tvAlamat = findViewById(R.id.tvAlamat);
        tvUbah = findViewById(R.id.tvUbah);
        tvUbah.setOnClickListener(view -> startActivity(new Intent(ProfileActivity.this, EditProfileActivity.class)));

        tvNama.setText(Common.currentUser.getName());
        tvNomorHp.setText(Common.currentUser.getPhone());
        if (!Common.currentUser.getAddress().equals("")) {
            tvAlamatAda.setText(Common.currentUser.getAddress());
            tvAlamatAda.setVisibility(View.VISIBLE);
            tvAlamat.setVisibility(View.INVISIBLE);
        } else {
            tvAlamatAda.setVisibility(View.INVISIBLE);
            tvAlamat.setVisibility(View.VISIBLE);
        }
            }

    private void setUpBottomNavigationView() {
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.navigation);
        Common.setupBottomNavigationView(bottomNavigationViewEx);
        Common.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

}

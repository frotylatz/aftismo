package unpad.aftismo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.accountkit.AccountKit;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import unpad.aftismo.utils.Common;

import static org.json.JSONObject.NULL;

public class ProfileActivity extends AppCompatActivity {

    Button logoutBtn;
    Context mContext = ProfileActivity.this;
    private static final int ACTIVITY_NUM = 3;
    TextView tvNama, tvNomorHp, tvAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbarProfile);
        setSupportActionBar(toolbar);

        setUpBottomNavigationView();

        logoutBtn = findViewById(R.id.logoutBtn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
            }
        });

        tvNama = findViewById(R.id.tvNama);
        tvNomorHp = findViewById(R.id.tvNomorHp);
        tvAlamat = findViewById(R.id.tvAlamat);

        tvNama.setText(Common.currentUser.getName());
        tvNomorHp.setText(Common.currentUser.getPhone());
        if(!Common.currentUser.getAddress().equals("")){
            tvAlamat.setText(Common.currentUser.getAddress());
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

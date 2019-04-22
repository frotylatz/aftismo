package unpad.aftismo.utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import unpad.aftismo.HomeActivity;
import unpad.aftismo.PecsActivity;
import unpad.aftismo.ProfileActivity;
import unpad.aftismo.R;
import unpad.aftismo.model.User;
import unpad.aftismo.retrofit.ApiClient;
import unpad.aftismo.retrofit.ApiInterface;

public class Common {
    private static final String BASE_URL = "http://coinbkt.com/aftismo/";

    public static User currentUser = null;

    public static ApiInterface getApi(){
        return ApiClient.getApiClient(BASE_URL).create(ApiInterface.class);
    }

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        Log.d("BottomNavigationViewHel", "Setting up navigation view");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_home:
                        Intent intent1 = new Intent(context, HomeActivity.class);
                        context.startActivity(intent1);
                        break;

                    case R.id.navigation_akun:
                        Intent intent2 = new Intent(context, ProfileActivity.class);
                        context.startActivity(intent2);
                        break;

                    case R.id.navigation_pecs:
                        Intent intent3 = new Intent(context, PecsActivity.class);
                        context.startActivity(intent3);
                        break;
                }

                return false;
            }
        });
    }
}

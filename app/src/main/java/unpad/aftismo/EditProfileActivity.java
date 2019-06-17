package unpad.aftismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.rengwuxian.materialedittext.MaterialEditText;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import unpad.aftismo.retrofit.ApiInterface;
import unpad.aftismo.utils.Common;

public class EditProfileActivity extends AppCompatActivity {

    Button btnSaveEdt;
    MaterialEditText edtName, edtAddress, edtNomorHp;

    ApiInterface mService;

    CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Toolbar toolbar = findViewById(R.id.toolbarEditProfile);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btnSaveEdt = findViewById(R.id.saveEdtBtn);
        edtName = findViewById(R.id.edtNama);
        edtAddress = findViewById(R.id.edtAlamat);
        edtNomorHp = findViewById(R.id.edtNomorHp);

        mService = Common.getApi();
        compositeDisposable = new CompositeDisposable();

        displayData();

        btnSaveEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUser();
            }
        });
    }

    private void updateUser() {
        Log.d("UserInfo1: ", Common.currentUser.getId() + Common.currentUser.getName()+ Common.currentUser.getPhone() + Common.currentUser.getAddress());
        if(!edtName.getText().toString().isEmpty() && !edtNomorHp.getText().toString().isEmpty()){
            compositeDisposable.add(mService.updateUser(Common.currentUser.getId(),
                    Common.currentUser.getPhone(),
                    edtName.getText().toString(),
                    edtAddress.getText().toString())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Consumer<String>() {
                        @Override
                        public void accept(String s) throws Exception {
                            Toast.makeText(EditProfileActivity.this, s, Toast.LENGTH_SHORT).show();

                            Log.d("UserInfo2: ", Common.currentUser.getId() + Common.currentUser.getName()+ Common.currentUser.getPhone() + Common.currentUser.getAddress());
                            finish();
                        }
                    }));

        }
    }

    private void displayData(){
        if(Common.currentUser != null){
            edtName.setText(Common.currentUser.getName());
            edtNomorHp.setText(Common.currentUser.getPhone());
            edtAddress.setText(Common.currentUser.getAddress());
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
}

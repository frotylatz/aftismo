package unpad.aftismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import unpad.aftismo.model.User;
import unpad.aftismo.retrofit.ApiInterface;
import unpad.aftismo.utils.Common;

public class RegisterAcitivity extends AppCompatActivity {

    MaterialEditText inputNama;
    Button btnRegister;
    ApiInterface mService;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_acitivity);
        Intent i = getIntent();
        phone = i.getStringExtra("phone");

        mService = Common.getApi();

        inputNama = findViewById(R.id.inputNama);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(inputNama.getText().toString()))
                {
                    Toast.makeText(RegisterAcitivity.this, "Tolong masukkan nama kamu", Toast.LENGTH_SHORT).show();
                    return;
                }

                final android.app.AlertDialog waitingDialog = new SpotsDialog(RegisterAcitivity.this);
                waitingDialog.show();
                waitingDialog.setMessage("Please wait...");

                mService.registerNewUser(phone,
                        inputNama.getText().toString())
                        .enqueue(new Callback<User>() {
                            @Override
                            public void onResponse(Call<User> call, Response<User> response) {
                                waitingDialog.dismiss();
                                User user = response.body();
                                if(TextUtils.isEmpty(user.getError_msg())){
                                    Toast.makeText(RegisterAcitivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                                    Common.currentUser = response.body();
                                    //Start HomeActivity
                                    startActivity(new Intent(RegisterAcitivity.this, MainActivity.class));
                                    finish();
                                }
                            }

                            @Override
                            public void onFailure(Call<User> call, Throwable t) {
                                waitingDialog.dismiss();
                            }
                        });
            }
        });
    }
}

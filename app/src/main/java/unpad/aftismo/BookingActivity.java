package unpad.aftismo;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import unpad.aftismo.model.BookResult;
import unpad.aftismo.retrofit.ApiInterface;
import unpad.aftismo.utils.Common;

public class BookingActivity extends AppCompatActivity {

    Button btnTanggal, btnSelanjutnya;
    MaterialEditText etTanggal;
    LinearLayout ll;
    String nama, hargatok;
    final Calendar myCalendar = Calendar.getInstance();
    CompositeDisposable compositeDisposable;
    ApiInterface mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        compositeDisposable = new CompositeDisposable();

        mService = Common.getApi();

        etTanggal = findViewById(R.id.etTanggal);
        ll = findViewById(R.id.llWaktu);
        btnTanggal = findViewById(R.id.buttonTanggal);

        Intent i = getIntent();
        nama = i.getStringExtra("nama");
        hargatok = i.getStringExtra("hargatok");

        btnTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        myCalendar.set(Calendar.YEAR, i);
                        myCalendar.set(Calendar.MONTH, i1);
                        myCalendar.set(Calendar.DAY_OF_MONTH, i2);
                        updateLabel();
                    }
                };

                new DatePickerDialog(BookingActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btnSelanjutnya = findViewById(R.id.btnSelanjutnya);
        btnSelanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                placeOrder();
            }
        });
    }

    private void placeOrder() {
        //Submit Order
        mService.submitOrder(Float.valueOf(hargatok),nama,Common.currentUser.getAddress(),Common.currentUser.getName(),
                Common.currentUser.getPhone(),myCalendar.getTime().toString(),"09.00")
                .enqueue(new Callback<BookResult>() {
                    @Override
                    public void onResponse(Call<BookResult> call, Response<BookResult> response) {

                        Toast.makeText(BookingActivity.this,"Book submitted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<BookResult> call, Throwable t) {
                        Toast.makeText(BookingActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etTanggal.setText(sdf.format(myCalendar.getTime()));
        ll.setVisibility(View.VISIBLE);

    }
}

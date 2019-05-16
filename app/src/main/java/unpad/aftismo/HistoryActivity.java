package unpad.aftismo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import unpad.aftismo.adapter.BookAdapter;
import unpad.aftismo.model.BookResult;
import unpad.aftismo.retrofit.ApiInterface;
import unpad.aftismo.utils.Common;

public class HistoryActivity extends AppCompatActivity {

    private static final int ACTIVITY_NUM = 2;
    private Context mContext = HistoryActivity.this;
    RecyclerView recycler_book;
    CompositeDisposable compositeDisposable;
    ApiInterface mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mService = Common.getApi();

        compositeDisposable = new CompositeDisposable();

        setUpBottomNavigationView();

        recycler_book = findViewById(R.id.recycler_book);
        recycler_book.setLayoutManager(new LinearLayoutManager(this));
        recycler_book.setHasFixedSize(true);

        loadBook();
    }

    private void loadBook() {
        compositeDisposable.add(mService.getAllBook()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(new Consumer<List<BookResult>>() {
            @Override
            public void accept(List<BookResult> bookResults) throws Exception {
                displayBook(bookResults);
            }
        }));
    }

    private void displayBook(List<BookResult> bookResults) {
        BookAdapter adapter = new BookAdapter(this,bookResults);
        recycler_book.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadBook();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
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

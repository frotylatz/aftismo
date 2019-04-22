package unpad.aftismo.adapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import unpad.aftismo.R;

public class ArtikelActivity extends AppCompatActivity {

    WebView wv;
    String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView myWebView = new WebView(ArtikelActivity.this);
        setContentView(myWebView);
        Intent i = getIntent();
        link = i.getStringExtra("link");
        myWebView.loadUrl(link);
    }
}

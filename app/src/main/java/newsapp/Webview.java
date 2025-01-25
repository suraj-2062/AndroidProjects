package newsapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorconverter.R;

public class Webview extends AppCompatActivity {
    WebView webview;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        webview=findViewById(R.id.webview);

        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        if(url!=null){
            webview.loadUrl(url);
        }
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
    }
}
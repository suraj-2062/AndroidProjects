package newsapp;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorconverter.R;

public class WebviewActivity extends AppCompatActivity {
    WebView webview;
    ProgressBar progress_bar;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        progress_bar=findViewById(R.id.progress_bar);
        webview=findViewById(R.id.webview);

        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading please wait.....");
        progressDialog.setCancelable(false);
        progressDialog.show();
        new Handler().postDelayed(() ->progressDialog.dismiss(),1000);

        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        if(url!=null){
            webview.loadUrl(url);
        }
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
    }
}
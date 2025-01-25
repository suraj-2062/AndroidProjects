package com.example.calculatorconverter;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Webview extends AppCompatActivity {
    WebView webview;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        webview=findViewById(R.id.webview);

//        ProgressDialog progressDialog=new ProgressDialog(Webview.this);
//        progressDialog.setTitle("Page Loading....");
//        progressDialog.setMessage("Page is loading please wait ....");
//        progressDialog.setCancelable(false);

//        webview.getSettings().setPluginState(WebSettings.PluginState.ON);
//        webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
//        webview.getSettings().setSupportMultipleWindows(true);
//
//        webview.getSettings().setSupportZoom(true);
//        webview.getSettings().setBuiltInZoomControls(true);

        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);

        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        if(url!=null){
            webview.loadUrl(url);
        }

    }
}
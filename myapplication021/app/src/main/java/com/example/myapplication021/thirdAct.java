package com.example.myapplication021;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class thirdAct extends Activity {

    long lastTimeBackpressed;
    WebView webView2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);
        webView2 = (WebView)findViewById(R.id.webview);
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.loadUrl("https://rightwearyform.heartj31.repl.co/");
        webView2.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView2.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView2.setWebChromeClient(new WebChromeClient());
    }

    @Override
    public void onBackPressed() {

        if(webView2.canGoBack()){
            webView2.goBack();
        }
        else{
            if(System.currentTimeMillis() - lastTimeBackpressed <1500){
                finish();
                return;
            }
            lastTimeBackpressed = System.currentTimeMillis();
            Toast.makeText(this, "한번 더 누르면 종료됩니다", Toast.LENGTH_SHORT).show();
        }
    }

}

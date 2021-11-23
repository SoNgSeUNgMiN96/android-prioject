package com.example.myapplication021;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class secondAct extends Activity {

    long lastTimeBackpressed;
    WebView aa;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);
        aa = (WebView)findViewById(R.id.webview);
        aa.getSettings().setJavaScriptEnabled(true);
        aa.loadUrl("https://daeryuk.github.io/map/");
        aa.setWebViewClient(new WebViewClient());
        WebSettings webSettings = aa.getSettings();
        webSettings.setJavaScriptEnabled(true);
        aa.setWebChromeClient(new WebChromeClient());
    }

    @Override
    public void onBackPressed() {

        if(aa.canGoBack()){
            aa.goBack();
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

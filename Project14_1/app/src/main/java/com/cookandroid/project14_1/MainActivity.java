package com.cookandroid.project14_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Intent intent1 , intent2;
    Button btnStart, btnStop , btnMyintentStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button)findViewById(R.id.btnServiceStart);
        btnStop = (Button)findViewById(R.id.btnServiceStop);
        btnMyintentStart = (Button)findViewById(R.id.btnStartIntService);
        intent1 = new Intent(getApplicationContext(), MyService.class);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("서비스 테스트","MainActivity: startService() called");
                startService(intent1);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("서비스 테스트","MainActivity: stopService() called");
                stopService(intent1);
            }
        });

        intent2 = new Intent(getApplicationContext() , MyIntentService.class);

        btnMyintentStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("서비스 테스트","MainActivity: startService(Intent2) called");
                startService(intent2);
            }
        });
    }
}

package com.cookandroid.example10_16_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import javax.xml.transform.Result;

public class SubActivity extends AppCompatActivity {

    Button btnReturn;
    TextView tv1;

    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);
        int sum;
        btnReturn = (Button)findViewById(R.id.btnreturn);
        tv1 = (TextView)findViewById(R.id.text1);

        ActionBar actionBar = getSupportActionBar();        //상단바 숨기
        actionBar.hide();


        Intent intent = getIntent();
        sum = intent.getExtras().getInt("Num1") - intent.getExtras().getInt("Num2");
        String result = "계산결과 : "+intent.getExtras().getInt("Num1")+" - "+intent.getExtras().getInt("Num2")+" = "+sum;
        tv1.setText(result);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Subresult",result);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });


    }

}

package com.cookandroid.project10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnNewActivity;
    RadioGroup Rgroup1;
    RadioButton RdSecond, RdThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNewActivity = (Button)findViewById(R.id.btnNewActivity);
        Rgroup1 = (RadioGroup)findViewById(R.id.Rgroup1);
        RdSecond = (RadioButton)findViewById(R.id.RdSecond);
        RdThird = (RadioButton)findViewById(R.id.RdThird);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (Rgroup1.getCheckedRadioButtonId()) {
                    case R.id.RdSecond:
                        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.RdThird:
                        Intent intent2 = new Intent(getApplicationContext(), ThirdActivity.class);

                        String name = "Alice";
                        Integer age = 33;

                        intent2.putExtra("Name", name);
                        intent2.putExtra("Age", age);


                        startActivity(intent2);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "액티비티 먼저 선택하세요", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }
}

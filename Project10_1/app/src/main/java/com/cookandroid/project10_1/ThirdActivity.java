package com.cookandroid.project10_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends Activity {


    Button finish;
    EditText editName  , editAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        finish = (Button)findViewById(R.id.btnReturn);

        Intent rxIntent = getIntent();
        Bundle extras = rxIntent.getExtras();

        String rxName = extras.getString("Name");
        Integer rxAge = extras.getInt("Age");

        editName = (EditText)findViewById(R.id.editName);
        editAge = (EditText)findViewById(R.id.editAge);
        editName.setText(rxName);
        editAge.setText(rxAge.toString());

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

package com.cookandroid.example10_16_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1 , edit2 , editResult;
    RadioGroup rdgroup1;
    RadioButton rdAdd, rdSub, rdMul;
    Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        ActionBar actionBar = getSupportActionBar();        //상단바 숨기
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText)findViewById(R.id.editNum1);
        edit2 = (EditText)findViewById(R.id.editNum2);
        editResult =  (EditText)findViewById(R.id.editResult);
        rdgroup1 = (RadioGroup)findViewById(R.id.Rgroup1);
        rdAdd = (RadioButton)findViewById(R.id.RdoAdd);
        rdSub = (RadioButton)findViewById(R.id.RdoSub);
        rdMul = (RadioButton)findViewById(R.id.RdoMul);
        btn1 = (Button)findViewById(R.id.btnSelect);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(rdgroup1.getCheckedRadioButtonId()){

                    case R.id.RdoAdd:
                        Intent intent1 = new Intent(getApplicationContext(), AddActivity.class);
                        try{
                            intent1.putExtra("Num1", Integer.parseInt(edit1.getText().toString()));
                            intent1.putExtra("Num2", Integer.parseInt(edit2.getText().toString()));
                            startActivityForResult(intent1,1001);
                        }
                        catch (NumberFormatException e){
                            Toast.makeText(getApplicationContext(),"숫자를 입력해주세요",Toast.LENGTH_LONG).show();
                        }



                        break;

                    case R.id.RdoSub:

                        Intent intent2 = new Intent(getApplicationContext(), SubActivity.class);
                        try{
                            intent2.putExtra("Num1", Integer.parseInt(edit1.getText().toString()));
                            intent2.putExtra("Num2", Integer.parseInt(edit2.getText().toString()));
                            startActivityForResult(intent2,1002);
                        }
                        catch (NumberFormatException e){
                            Toast.makeText(getApplicationContext(),"숫자를 입력해주세요",Toast.LENGTH_LONG).show();
                        }

                        break;

                    case R.id.RdoMul:
                        Intent intent3 = new Intent(getApplicationContext(), MulActivity.class);
                        try{
                            intent3.putExtra("Num1", Integer.parseInt(edit1.getText().toString()));
                            intent3.putExtra("Num2", Integer.parseInt(edit2.getText().toString()));
                            startActivityForResult(intent3,1003);
                        }
                        catch (NumberFormatException e){
                            Toast.makeText(getApplicationContext(),"올바른 숫자를 입력해주세요",Toast.LENGTH_LONG).show();
                        }
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"연산을 선택해주세요",Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {



        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1001:
                if (resultCode == RESULT_OK)
                    editResult.setText(data.getExtras().getString("Addresult"));
                break;
            case 1002:
                if (resultCode == RESULT_OK)
                    editResult.setText(data.getExtras().getString("Subresult"));
                break;
            case 1003:
                if (resultCode == RESULT_OK)
                    editResult.setText(data.getExtras().getString("Mulresult"));
                break;

        }
    }
}
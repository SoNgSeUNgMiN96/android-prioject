package com.cookandroid.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1,editText2 ;
    TextView textView1;
    Button btn0, btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9 ,btnadd,btnsub,btnmul,btndiv;
    String num1, num2,answer;
    int oneortwo=0;
    int number1,number2;
    double divnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Calculator");

        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        btn0 =(Button)findViewById(R.id.btn0);
        btn1 =(Button)findViewById(R.id.btn1);
        btn2 =(Button)findViewById(R.id.btn2);
        btn3 =(Button)findViewById(R.id.btn3);
        btn4 =(Button)findViewById(R.id.btn4);
        btn5 =(Button)findViewById(R.id.btn5);
        btn6 =(Button)findViewById(R.id.btn6);
        btn7 =(Button)findViewById(R.id.btn7);
        btn8 =(Button)findViewById(R.id.btn8);
        btn9 =(Button)findViewById(R.id.btn9);
        btnadd = (Button)findViewById(R.id.btnadd);
        btnsub = (Button)findViewById(R.id.btnsub);
        btnmul = (Button)findViewById(R.id.btnmul);
        btndiv = (Button)findViewById(R.id.btndiv);
        textView1 = (TextView)findViewById(R.id.textView1);


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oneortwo==1){
                    num1 = editText1.getText().toString();
                    editText1.setText(num1+"0");
                }
                else if(oneortwo==2){
                    num2 = editText2.getText().toString();
                    editText2.setText(num2+"0");
                }else {
                    Toast.makeText(getApplicationContext(), "EditText를 선택하세요",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oneortwo==1){
                    num1 = editText1.getText().toString();
                    editText1.setText(num1+"1");
                }
                else if(oneortwo==2){
                    num2 = editText2.getText().toString();
                    editText2.setText(num2+"1");
                }else {
                    Toast.makeText(getApplicationContext(), "EditText를 선택하세요",Toast.LENGTH_SHORT).show();
                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oneortwo==1){
                    num1 = editText1.getText().toString();
                    editText1.setText(num1+"2");
                }
                else if(oneortwo==2){
                    num2 = editText2.getText().toString();
                    editText2.setText(num2+"2");
                }else {
                    Toast.makeText(getApplicationContext(), "EditText를 선택하세요",Toast.LENGTH_SHORT).show();
                }

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oneortwo==1){
                    num1 = editText1.getText().toString();
                    editText1.setText(num1+"3");
                }
                else if(oneortwo==2){
                    num2 = editText2.getText().toString();
                    editText2.setText(num2+"3");
                }else {
                    Toast.makeText(getApplicationContext(), "EditText를 선택하세요",Toast.LENGTH_SHORT).show();
                }

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oneortwo==1){
                    num1 = editText1.getText().toString();
                    editText1.setText(num1+"4");
                }
                else if(oneortwo==2){
                    num2 = editText2.getText().toString();
                    editText2.setText(num2+"4");
                }else {
                    Toast.makeText(getApplicationContext(), "EditText를 선택하세요",Toast.LENGTH_SHORT).show();
                }

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oneortwo==1){
                    num1 = editText1.getText().toString();
                    editText1.setText(num1+"5");
                }
                else if(oneortwo==2){
                    num2 = editText2.getText().toString();
                    editText2.setText(num2+"5");
                }else {
                    Toast.makeText(getApplicationContext(), "EditText를 선택하세요",Toast.LENGTH_SHORT).show();
                }

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oneortwo==1){
                    num1 = editText1.getText().toString();
                    editText1.setText(num1+"6");
                }
                else if(oneortwo==2){
                    num2 = editText2.getText().toString();
                    editText2.setText(num2+"6");
                }else {
                    Toast.makeText(getApplicationContext(), "EditText를 선택하세요",Toast.LENGTH_SHORT).show();
                }

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oneortwo==1){
                    num1 = editText1.getText().toString();
                    editText1.setText(num1+"7");
                }
                else if(oneortwo==2){
                    num2 = editText2.getText().toString();
                    editText2.setText(num2+"7");
                }else {
                    Toast.makeText(getApplicationContext(), "EditText를 선택하세요",Toast.LENGTH_SHORT).show();
                }

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oneortwo==1){
                    num1 = editText1.getText().toString();
                    editText1.setText(num1+"8");
                }
                else if(oneortwo==2){
                    num2 = editText2.getText().toString();
                    editText2.setText(num2+"8");
                }else {
                    Toast.makeText(getApplicationContext(), "EditText를 선택하세요",Toast.LENGTH_SHORT).show();
                }

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oneortwo==1){
                    num1 = editText1.getText().toString();
                    editText1.setText(num1+"9");
                }
                else if(oneortwo==2){
                    num2 = editText2.getText().toString();
                    editText2.setText(num2+"9");
                }else {
                    Toast.makeText(getApplicationContext(), "EditText를 선택하세요",Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(editText1.getText().toString().equals("")||editText2.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "값을 입력하세요", Toast.LENGTH_SHORT).show();
                    }else {
                        number1 = Integer.parseInt(editText1.getText().toString());
                        number2 = Integer.parseInt(editText2.getText().toString());
                        textView1.setText("계산 결과: " +(number1+number2));
                    }
                }catch (Exception e){
                    textView1.setText("계산 결과: " +" \n\n error!! error :"+e);
                }finally{
                    //무조건 수행
                }

            }
        });


        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(editText1.getText().toString().equals("")||editText2.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "값을 입력하세요", Toast.LENGTH_SHORT).show();
                    }else {
                        number1 = Integer.parseInt(editText1.getText().toString());
                        number2 = Integer.parseInt(editText2.getText().toString());
                        textView1.setText("계산 결과: " + (number1 - number2));
                    }
                }catch (Exception e){
                    textView1.setText("계산 결과: " +" \n\n error!! error :"+e);
                }finally{
                    //무조건 수행
                }

            }
        });

        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(editText1.getText().toString().equals("")||editText2.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "값을 입력하세요", Toast.LENGTH_SHORT).show();
                    }else {
                        number1 = Integer.parseInt(editText1.getText().toString());
                        number2 = Integer.parseInt(editText2.getText().toString());
                        textView1.setText("계산 결과: " + (number1 * number2));
                    }
                }catch (Exception e){
                    textView1.setText("계산 결과: " +" \n\n error!! error :"+e);
                }finally{
                    //무조건 수행
                }

            }
        });

        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(editText1.getText().toString().equals("")||editText2.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "값을 입력하세요", Toast.LENGTH_SHORT).show();
                    }else {
                        number1 = Integer.parseInt(editText1.getText().toString());
                        divnum = Integer.parseInt(editText2.getText().toString());
                        if(divnum==0){
                            Toast.makeText(getApplicationContext(), "0으로 나눌 수 없음", Toast.LENGTH_SHORT).show();
                        }else{
                            textView1.setText("계산 결과: " +(number1/divnum));
                        }
                    }
                }catch (Exception e){
                    textView1.setText("계산 결과: " +" \n\n error!! error :"+e);
                }finally{
                    //무조건 수행
                }
            }
        });


        editText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                oneortwo =1;
            }
        });

        editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                oneortwo =2;
            }
        });

    }
}

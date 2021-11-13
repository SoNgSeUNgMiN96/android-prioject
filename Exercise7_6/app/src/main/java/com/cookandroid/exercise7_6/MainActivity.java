package com.cookandroid.exercise7_6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup Rgroup1;
    RadioButton RdoDog, RdoCat , RdoRabbit;
    Button button1;
    View dialogView;
    private ImageView mDialog;

    public void Toast_Nomal(){
        View view = View.inflate(MainActivity.this , R.layout.toast,null);
        Toast toast = new Toast(MainActivity.this);
        toast.setView(view);
        toast.setGravity(Gravity.BOTTOM,0,100);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.button1);
        Rgroup1 = (RadioGroup)findViewById(R.id.Rgroup1);
        RdoDog = (RadioButton)findViewById(R.id.RdoDog);
        RdoCat = (RadioButton)findViewById(R.id.RdoCat);
        RdoRabbit = (RadioButton)findViewById(R.id.RdoRabbit);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                switch (Rgroup1.getCheckedRadioButtonId()){
                    case R.id.RdoDog:
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast_Nomal();
                                dialog.cancel();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        LayoutInflater inflater = getLayoutInflater();
                        View dialogLayout = inflater.inflate(R.layout.dialog1, null);
                        dialog.setView(dialogLayout);
                        dialog.setTitle("강아지");
                        dialog.setIcon(R.drawable.ic_baseline_group_24);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog.show();
                        break;

                    case R.id.RdoCat:
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                        builder2.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast_Nomal();
                                dialog.cancel();
                            }
                        });
                        AlertDialog dialog2 = builder2.create();
                        LayoutInflater inflater2 = getLayoutInflater();
                        View dialogLayout2 = inflater2.inflate(R.layout.dialog2, null);
                        dialog2.setView(dialogLayout2);
                        dialog2.setTitle("고양이");
                        dialog2.setIcon(R.drawable.ic_baseline_group_24);
                        dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog2.show();


                        break;
                    case R.id.RdoRabbit:
                        AlertDialog.Builder builder3 = new AlertDialog.Builder(MainActivity.this);
                        builder3.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast_Nomal();
                                dialog.cancel();
                            }
                        });
                        AlertDialog dialog3 = builder3.create();
                        LayoutInflater inflater3 = getLayoutInflater();
                        View dialogLayout3 = inflater3.inflate(R.layout.dialog3, null);
                        dialog3.setView(dialogLayout3);
                        dialog3.setTitle("토끼");
                        dialog3.setIcon(R.drawable.ic_baseline_group_24);
                        dialog3.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog3.show();
                        break;

                    default:
                        Toast.makeText(getApplicationContext(),"동물 먼저 선택하세요",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}

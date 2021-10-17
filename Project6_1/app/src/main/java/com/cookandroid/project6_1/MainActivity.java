package com.cookandroid.project6_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chrono;
    Button btnStart , btnEnd;
    RadioButton radioCal ,radioTime;
    CalendarView calView;
    TimePicker tPicker;
    TextView tvYear , tvMonth , tvDay ,tvHour, tvMinute;
    int selectYear , selectMonth , selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("시간 에약");

        btnStart = (Button)findViewById(R.id.btnstart);
        btnEnd = (Button)findViewById(R.id.btnEnd);
        chrono = (Chronometer)findViewById(R.id.chronometer1);
        radioCal = (RadioButton)findViewById(R.id.radioCal);
        radioTime = (RadioButton)findViewById(R.id.radioTime);
        tPicker = (TimePicker)findViewById(R.id.timePicher1);
        calView  = (CalendarView)findViewById(R.id.calendarView1);
        tvYear = (TextView)findViewById(R.id.tvYear);
        tvMonth = (TextView)findViewById(R.id.tvMonth);
        tvMinute = (TextView)findViewById(R.id.tvMinute);
        tvHour = (TextView)findViewById(R.id.tvHour);
        tvDay = (TextView)findViewById(R.id.tvDay);

        tPicker.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);

        radioCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.VISIBLE);
            }
        });

        radioTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.VISIBLE);
                calView.setVisibility(View.INVISIBLE);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });



        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);
                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
            }
        });

        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectDay = dayOfMonth;
                selectYear = year;
                selectMonth = month +1;
            }
        });




    }
}

package com.example.myapplication021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.RequestQueue;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.commons.text.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends Activity {


    //private MccCalendarView maccCalendarView;
    //CalendarView calendarView;

    static Map<String,String> sub1[];
    static int status=1;      // 1 은 최초 2 는 크롤링중 3은 성공
    static int count =0;
    private  CalendarView calendarView;
    ImageButton gosecondAct;
    ImageButton gothirdAct;
    ImageButton gologinAct;
    static JSONObject tasks[];
    static JSONArray taskarry;
    Button caladd;
    TextView textView;
    static String loginid;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text2);

        calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String temp1;
                temp1 =  Integer.toString(year)+"."+String.format("%02d", month+1)+"."+String.format("%02d", dayOfMonth);
                if (status ==3) {
                    compare(temp1);
                }
                else if (status ==2){
                    try {
                        Thread.sleep(60000);
                    }
                    catch (Exception e){

                    }

                }else{

                }

            }


        });



        //두번째 엑트로 넘어가는 버튼
        gosecondAct = findViewById(R.id.nextAct1);
        gosecondAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), secondAct.class);
                startActivity(intent);
            }
        });



        //세번째 액트
        gothirdAct = findViewById(R.id.nextAct2);
        gothirdAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), thirdAct.class);
                startActivity(intent);
            }
        });

        //로그인 액트로 넘어가는 버튼
        gologinAct = findViewById(R.id.logingo);
        gologinAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), loginAct.class);
                startActivity(intent);
            }
        });
    }

    private void compare(String temp1) {
        textView.setText("");
        for (int i=0;i<taskarry.length();i++) {
            try {
                String bitbit[] = taskarry.getJSONObject(i).getString("deadline").split(" ");
                if (bitbit[0].equals(temp1)) {
                    textView.append(taskarry.getJSONObject(i).getString("course") + "\n");
                    textView.append(taskarry.getJSONObject(i).getString("message") + "\n");
                    textView.append(taskarry.getJSONObject(i).getString("deadline") + "\n\n");
                }
            } catch (JSONException e) {

            }
        }

    }


    static void applyJson(String json) {

        //List<String> list = new ArrayList();
        taskarry = new JSONArray();

        String cd[] = json.split("\\[");
        //login_response_data.setText(cd[1]);

        cd[1] = cd[1].replace("[", "");
        cd[1] = cd[1].replace("]", "");

        String bits[] = cd[1].split("\\},");


        for (int i = 0; i < bits.length; i++) {
            bits[i] = bits[i] + "}";
        }

        for (int i = 0; i < bits.length; i++) {
            try {
                JSONObject temp = new JSONObject(bits[i]);
                taskarry.put(temp);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    private void sendLoginGetRequest() {
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url = "https://kuf1h967mc.execute-api.us-east-2.amazonaws.com/mcc/assignment/status?userId=" +MainActivity.loginid;
        StringRequest stringrequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            public void onResponse(String response) {
                String ab = StringEscapeUtils.unescapeJava(response);
                MainActivity.applyJson(ab);
                if (ab.contains("Job")){
                    MainActivity.status = 2;
                    Toast.makeText(getApplicationContext(), "크롤링중입니다.", Toast.LENGTH_LONG).show();
                }
                else if (ab.contains("assignment")){
                    MainActivity.status = 3;
                    Toast.makeText(getApplicationContext(), "로그인성공!", Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(stringrequest);
    }

}



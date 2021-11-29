package com.example.myapplication021;

import java.io.IOException;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.JsonObjectRequest;

import androidx.annotation.Nullable;

import org.apache.commons.text.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class loginAct extends AppCompatActivity {

    private TextView get_response_text, login_response_data;
    private EditText loginid;
    private EditText loginpwd;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutlogin);

        Button loginbtn = findViewById(R.id.loginbtn);
        loginid = findViewById(R.id.loginid);
        loginpwd = findViewById(R.id.loginpwd);
        login_response_data = findViewById(R.id.login_response_data);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendLoginGetRequest();
            }
        });

    }

    private void sendLoginGetRequest() {
        RequestQueue queue = Volley.newRequestQueue(loginAct.this);
        MainActivity.loginid = loginid.getText().toString();
        String url = "https://kuf1h967mc.execute-api.us-east-2.amazonaws.com/mcc/assignment/get?userId=" +MainActivity.loginid + "&passwd=" + loginpwd.getText().toString();
        StringRequest stringrequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            public void onResponse(String response) {
                String ab = StringEscapeUtils.unescapeJava(response);
                MainActivity.applyJson(ab);
                if(ab.contains("Updating")||ab.contains("Working")){
                    MainActivity.status = 1;
                    Toast.makeText(getApplicationContext(), "최초로그인입니다.", Toast.LENGTH_LONG).show();
                }
                else if (ab.contains("Job")){
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
                login_response_data.setText("Data : response fail");
            }
        });
        queue.add(stringrequest);
    }
}

   /* public void sendpostjson() {
        JSONObject requestJsonObject = new JSONObject();
        try {
            requestJsonObject.put("userid",loginid.getText().toString());
            requestJsonObject.put("passwd",loginpwd.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // 2. RequestQueue 선언
        RequestQueue requestQueue = Volley.newRequestQueue(loginAct.this);

        // 3. 서버 IP와 받을 경로
        String url = "https://kuf1h967mc.execute-api.us-east-2.amazonaws.com/mcc/assignment/get?userId=" + loginid.getText().toString() + "&passwd=" + loginpwd.getText().toString();
        JsonObjectRequest R_Object = new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONArray J_JsonArray = new JSONArray();
                try {
                    J_JsonArray = response.getJSONArray("assignment");

                    for (int i=0; i< J_JsonArray.length();i++){
                        JSONObject dataObj = J_JsonArray.getJSONObject(i);
                        String course = dataObj.getString("course");
                        String message = dataObj.getString("message");
                        String deadline = dataObj.getString("deadline");
                        login_response_data.append(course+","+message+","+deadline+"\n");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(R_Object);
    }
}*/




   /* private void sendPostRequest() {
        RequestQueue queue = Volley.newRequestQueue(loginAct.this);
        String url = "https://kuf1h967mc.execute-api.us-east-2.amazonaws.com/mcc/assignment/get/";
        StringRequest stringrequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            public void onResponse(String response) {
                login_response_data.setText(StringEscapeUtils.unescapeJava(response));
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                login_response_data.setText("에러인것같습니다");
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> params = new HashMap<String, String>();
            params.put("userid", loginid.getText().toString());
            params.put("passwd", loginpwd.getText().toString());
            return params;
            }
        };
    }
*/


//Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//Toast.makeText(getApplicationContext(),"과제정보를 긁어옵니다",Toast.LENGTH_SHORT).show();
//startActivity(intent);
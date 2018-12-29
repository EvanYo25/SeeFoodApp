package com.evanyo.cameraplusalbum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView no1 = (TextView) findViewById(R.id.no1);
        TextView no2 = (TextView) findViewById(R.id.no2);
        TextView no3 = (TextView) findViewById(R.id.no3);

        Intent intent = getIntent();
        String str = intent.getStringExtra("ret");
        try {
            JSONObject jsonObj = new JSONObject(str);
            String result = jsonObj.getString("label");
            JSONArray arr = jsonObj.getJSONArray("label");
            Log.v("adamNO1toLOCAL", result);

            no1.setText("no1: "+arr.get(0));
            no2.setText("no2: "+arr.get(1));
            no3.setText("no3: "+arr.get(2));
        } catch (JSONException e) {
            //some exception handler code.
            Log.v("adamNO1toLOCAL2", "error");
        }

    }
}

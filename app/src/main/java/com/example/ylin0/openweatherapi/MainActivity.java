package com.example.ylin0.openweatherapi;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    TextView mTitle;
    TextView mtemperature;
    TextView mweather;
    Button mbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = (TextView) findViewById(R.id.city_field);
        mtemperature = (TextView) findViewById(R.id.current_temperature_field);
        mweather = (TextView) findViewById(R.id.weather);
        mbutton = (Button) findViewById(R.id.button);
    }

    public void onClickBtn(View v) {
        getWeather();
    }

    private void getWeather() {
        FetchRemote fR = new FetchRemote();
        JSONObject data = fR.getJSON(this);
        String temperature, weather;

        try {
            temperature = data.getJSONObject("main").getString("temp");
            weather = data.getJSONObject("weather").getString("description");
            mtemperature.setText(temperature);
            mweather.setText(weather);
            mtemperature.setVisibility(View.VISIBLE);
            mweather.setVisibility(View.VISIBLE);
            mTitle.setVisibility(View.VISIBLE);

        } catch (JSONException e) {
            e.printStackTrace();
        }



    }
}

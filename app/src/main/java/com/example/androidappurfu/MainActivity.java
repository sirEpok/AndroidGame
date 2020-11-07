package com.example.androidappurfu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences pref;
    private final String save_key = "save_key";
    private TextView tvMain, tvRes;
    private ActionBar actionBar;
    private int number1;
    private int number2;
    private int numberFalse;
    private int numberRes;
    private int numberIndex;
    private int max = 20;
    private int min = 0;
    private int maxFalse = 40;
    private int minFalse = 10;
    private long startTime = 0;
    private long currentTime = 0;
    private float timeResult = 0.0f;
    private int trueAnswer = 0;
    private int maxTrueAnswer = 5;
    private boolean isTrueAnswer = false;
    public String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        startTime = System.currentTimeMillis();
        pref = getSharedPreferences("Test", MODE_PRIVATE);
        tvMain = findViewById(R.id.tvMain);
        tvRes = findViewById(R.id.tvRes);
        actionBar = getSupportActionBar();
        numbers();
    }

    private void numbers() {
        number1 = (int) (Math.random() * (max - min));
        number2 = (int) (Math.random() * (max - min));
        numberFalse = (int) (Math.random() * (maxFalse - minFalse));
        numberIndex = (int) (Math.random() * 3);
        numberRes = number1 + number2;
        tvRes.setText(String.valueOf(trueAnswer));
        String text;
        if(numberIndex == 3 || numberIndex == 1) {
            text = number1 + " + " + number2 + " = " + numberRes;
            isTrueAnswer = true;
        } else {
            text = number1 + " + " + number2 + " = " + numberFalse;
            isTrueAnswer = false;
        }
        tvMain.setText(text);
        if (trueAnswer >= maxTrueAnswer) {
            Intent i = new Intent(MainActivity.this, FinalActivity.class);
            startActivity(i);
        }
    }

    public void onClickTrue(View view) {
        if(isTrueAnswer) {
            trueAnswer++;
            numbers();
            currentTime = System.currentTimeMillis();
            timeResult = (float) (currentTime - startTime) / 1000;
            time = "Time: " + timeResult;
            actionBar.setTitle(time);
        } else {
            numbers();
            currentTime = System.currentTimeMillis();
            timeResult = (float) (currentTime - startTime) / 1000;
            time = "Time: " + timeResult;
            actionBar.setTitle(time);
        }
        tvRes.setText(String.valueOf(trueAnswer));
    }
    public void onClickFalse(View view) {
        if(!isTrueAnswer) {
            trueAnswer++;
            numbers();
            currentTime = System.currentTimeMillis();
            timeResult = (float) (currentTime - startTime) / 1000;
            time = "Time: " + timeResult;
            actionBar.setTitle(time);
        } else {
            numbers();
            currentTime = System.currentTimeMillis();
            timeResult = (float) (currentTime - startTime) / 1000;
            time = "Time: " + timeResult;
            actionBar.setTitle(time);
        }
        tvRes.setText(String.valueOf(trueAnswer));
    }
}
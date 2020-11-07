package com.example.androidappurfu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class FinalActivity extends Activity {
    private TextView tvTitle, tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_layout);
        tvTitle = findViewById(R.id.tvTitle);
    }
    public void onClickFinish(View view) {
        Intent i = new Intent(FinalActivity.this, StartActivity.class);
        startActivity(i);
    }
}

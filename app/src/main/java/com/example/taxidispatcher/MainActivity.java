package com.example.taxidispatcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT = "com.example.taxidispatcher.EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openStreetActivity(View v) {
        Button button = (Button) v;
        String text = button.getText().toString();
        Intent intent = new Intent(this, StreetActivity.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }
}
package com.example.suchin.simpleui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Debug", "Hello log");
        textview = (TextView)findViewById(R.id.textview);// the function findViewById output Class  is View, need to downcasting to TextView.
        textview.setText("Hello TextView");
    }
}

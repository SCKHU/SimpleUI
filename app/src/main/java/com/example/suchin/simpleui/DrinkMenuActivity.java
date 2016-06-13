package com.example.suchin.simpleui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DrinkMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_menu);
    }


    // 2016.06.13 the activity life cycle
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Debug", "DrinkMenu onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Debug", "DrinkMenu onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Debug", "DrinkMenu onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Debug", "DrinkMenu onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Debug", "DrinkMenu onRestart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Debug", "DrinkMenu onResume");
    }

}

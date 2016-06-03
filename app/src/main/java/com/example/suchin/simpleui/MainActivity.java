package com.example.suchin.simpleui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textview;
    EditText editview;
    RadioGroup radiogroup;
    String gender = "Female";
    CheckBox checkbox;
    String name = "";
    String HideGender = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2016.05.30
        Log.d("Debug", "Hello log");


        textview = (TextView) findViewById(R.id.textview);// the function findViewById output Class  is View, need to downcasting to TextView.
        //2016.06.02
        editview = (EditText) findViewById(R.id.editText);
        radiogroup = (RadioGroup) findViewById(R.id.radioGroup);
        checkbox = (CheckBox) findViewById(R.id.checkBox);
        //2016.06.02 Anonymouse Function
        editview.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN)//when enter pressed
                {
                    click(v);

                    return true; //block the "Enter" key, or the textUI would increase one line
                }
                return false;
            }
        });

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.MaleRadioButton) {
                    gender = "Male";
                } else if (checkedId == R.id.FemaleRadioButton) {
                    gender = "Female";
                }
            }
        });

        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeTextView();
            }
        });
    }

    public void click(View view) // here class buttonview also valid
    {
        name = editview.getText().toString();
        changeTextView();
        editview.setText("");
    }

    public void changeTextView() {
        if (name.equals(""))
            return;
        if (checkbox.isChecked()) {


            textview.setText(name);
        } else {

            String content = "Name: "+name + ", Gender: " + gender;
            textview.setText(content);
        }


    }
}

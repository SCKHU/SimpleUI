package com.example.suchin.simpleui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView textview;
    EditText editview;
    RadioGroup radiogroup;
    CheckBox checkbox;
    //    String gender = "Female";
//    String name = "";
//    String HideGender = "";
    String drinkName = "Black Tea";
    ListView listView;
    ArrayList<Order> orders = new ArrayList<>();
    Spinner storeSpinner;

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
        listView = (ListView) findViewById(R.id.listView);
        storeSpinner = (Spinner) findViewById(R.id.spinner);

        setupSpinner();
        setupListView();
//        editview.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN)//when enter pressed
//                {
//                    click(v);
//
//                    return true; //block the "Enter" key, or the textUI would increase one line
//                }
//                return false;
//            }
//        });

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if (checkedId == R.id.MaleRadioButton) {
//                    gender = "Male";
//                } else if (checkedId == R.id.FemaleRadioButton) {
//                    gender = "Female";
//                }
                RadioButton radiobutton = (RadioButton) findViewById(checkedId);
                drinkName = radiobutton.getText().toString();
            }
        });


//        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                changeTextView();
//            }
//        });
//    }


    }

    public void click(View view) // here class buttonview also valid
    {
        String note = editview.getText().toString();
        //textview.setText(drinkName);
        Order order = new Order();
        order.note = note;
        order.drinkName = drinkName;
        orders.add(order);
        setupListView();
//        changeTextView();
//        editview.setText("");
    }

//    public void changeTextView() {
//        if (name.equals(""))
//            return;
//        if (checkbox.isChecked()) {
//
//
//            textview.setText(name);
//        } else {
//
//            String content = "Name: "+name + ", Gender: " + gender;
//            textview.setText(content);
//        }
//    }

    void setupListView() {
//2016.06.06  adapter1
//        String[] data = new String[]{"123", "Helllo", "234", "Hi", "ABCD"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, drinks);

//2016.06.06  adapter2
//        List<Map<String, String>> data = new ArrayList<>();
//        for (int i = 0; i < orders.size(); i++) {
//            Order order = orders.get(i);
//            Map<String, String> item = new HashMap<>();
//            item.put("note", order.note);
//            item.put("drinkName", order.drinkName);
//            data.add(item);
//
//        }
//        String[] from = {"note", "drinkName"};
//        int[] to = {R.id.noteTextView,R.id.drinkNameTextView};
//
//        SimpleAdapter adapter = new SimpleAdapter(this,data,R.layout.listview_order_item,from, to);
//        listView.setAdapter(adapter);
//2016.06.06 adapter3

        OrderAdapter adapter = new OrderAdapter(this, orders);
        listView.setAdapter(adapter);
    }


    void setupSpinner() {

        String[] data = getResources().getStringArray(R.array.storeInfo);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,data);
        storeSpinner.setAdapter(adapter);
    }

}

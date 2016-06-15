package com.example.suchin.simpleui;

import android.content.Intent;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_CODE_DRINK_MENU_ACTIVITY = 0;
    TextView textview;
    EditText editview;
    RadioGroup radiogroup;
    CheckBox checkbox;
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
        Log.d("Debug", "onCreate");

    }

    public void click(View view) // here class buttonview also valid
    {
        String note = editview.getText().toString();
        //textview.setText(drinkName);
        Order order = new Order();
        order.note = note;
        order.drinkName = drinkName;
        order.storeInfo = (String) storeSpinner.getSelectedItem().toString();
        orders.add(order);
        setupListView();

    }


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
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        storeSpinner.setAdapter(adapter);
    }

    public void goToMenu(View view) {
        Intent intent = new Intent();
        intent.setClass(this, DrinkMenuActivity.class);
        startActivityForResult(intent, REQUEST_CODE_DRINK_MENU_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_DRINK_MENU_ACTIVITY) {
            if (resultCode == RESULT_OK) {
                textview.setText(data.getStringExtra("results"));
                Toast.makeText(this, "Order done", Toast.LENGTH_LONG).show();//homework
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Order canceled", Toast.LENGTH_LONG).show();//homework
            }
        }
    }

    // 2016.06.13 the activity life cycle
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Debug", "Main Activity onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Debug", "Main Activity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Debug", "Main Activity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Debug", "Main Activity onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Debug", "Main Activity onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Debug", "Main Activity onResume");
    }
}

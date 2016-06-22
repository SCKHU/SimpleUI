package com.example.suchin.simpleui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_CODE_DRINK_MENU_ACTIVITY = 0;
    TextView textView;
    EditText editView;
    RadioGroup radiogroup;
    CheckBox checkbox;
    String drinkName = "Black Tea";
    ListView listView;
    ArrayList<Order> orders = new ArrayList<>();
    Spinner storeSpinner;
    String menuResults = "";


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2016.05.30
        Log.d("Debug", "Hello log");


        textView = (TextView) findViewById(R.id.textView);// the function findViewById output Class  is View, need to downcasting to TextView.
        //2016.06.02
        editView = (EditText) findViewById(R.id.editText);
        radiogroup = (RadioGroup) findViewById(R.id.radioGroup);
        checkbox = (CheckBox) findViewById(R.id.checkBox);
        //2016.06.02 Anonymouse Function
        listView = (ListView) findViewById(R.id.listView);
        storeSpinner = (Spinner) findViewById(R.id.spinner);

        sharedPreferences = getSharedPreferences("setting", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        setupOrdersData();
        setupListView();
        editView.setText(sharedPreferences.getString("editText", ""));
        editView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN)//when enter pressed
                {
                    String text = editView.getText().toString();
                    editor.putString("editText", text);
                    editor.apply();
                    //click(v);

                    return true; //block the "Enter" key, or the textUI would increase one line
                }
                return false;
            }
        });
        textView.setText(sharedPreferences.getString("textView", ""));
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                editor.putString("textView", s.toString());
                editor.apply();
            }
        });
        Log.d("Debug", "Main Activity onCreate");

    }

    public void click(View view) // here class buttonview also valid
    {
        String note = editView.getText().toString();
        //textView.setText(drinkName);
        Order order = new Order();
        order.note = note;
        order.menuResults = menuResults;
        order.storeInfo = (String) storeSpinner.getSelectedItem().toString();
        orders.add(order);

        textView.setText(note);
        menuResults = "";


        setupListView();
        Utils.writeFile(this, "history", order.getJsonObject().toString());

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

    private void setupOrdersData() {
        String content = Utils.readFile(this, "history");
        String[] datas = content.split("\n");
        for (int i = 0; i < datas.length; i++) {
            Order order = Order.newInstanceWithJsonObjectData(datas[i]);
            if(order != null){
                orders.add(order);
            }
        }
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

                menuResults = data.getStringExtra("results");
//                textView.setText(data.getStringExtra("results"));
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

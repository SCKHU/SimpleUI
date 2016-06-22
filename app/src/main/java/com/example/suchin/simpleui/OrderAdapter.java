package com.example.suchin.simpleui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by SuChin.Chiu on 6/6/2016.
 */
public class OrderAdapter extends BaseAdapter {

    ArrayList<Order> orders;
    LayoutInflater inflater;

    public OrderAdapter(Context context, ArrayList<Order> orders) {

        this.orders = orders;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public Object getItem(int position) {
        return orders.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
        //no id in this case, just return position
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_order_item, null);
            TextView drinkNumberTextView = (TextView) convertView.findViewById(R.id.drindNumberTextView);
            TextView noteTextView = (TextView) convertView.findViewById(R.id.noteTextView);
//            TextView store = (TextView) convertView.findViewById(R.id.storeInfoTextView);

            holder.drinkNumber = drinkNumberTextView;
            holder.note = noteTextView;
            holder.storeInfo = (TextView) convertView.findViewById(R.id.storeInfoTextView);
            convertView.setTag(holder);

        } else {

            holder = (Holder) convertView.getTag();
        }
        Order order = orders.get(position);
        int totalNumber = 0;
        try {
            JSONArray jsonArray = new JSONArray(order.menuResults);
            for(int i = 0; i< jsonArray.length();i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                totalNumber += jsonObject.getInt("lNumber")+jsonObject.getInt("mNumber");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        holder.drinkNumber.setText(String.valueOf(totalNumber));
        holder.note.setText(order.note);
        holder.storeInfo.setText(order.storeInfo);
        return convertView;


    }

    //inner class
    class Holder {

        TextView drinkNumber;
        TextView note;
        TextView storeInfo;

    }
}
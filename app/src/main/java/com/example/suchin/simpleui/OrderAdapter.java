package com.example.suchin.simpleui;

import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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
            TextView drinkNameTextView = (TextView) convertView.findViewById(R.id.drinkNameTextView);
            TextView noteTextView = (TextView) convertView.findViewById(R.id.noteTextView);
            TextView storeTextView = (TextView) convertView.findViewById(R.id.storeTextView);

            holder.drinkName = drinkNameTextView;
            holder.note = noteTextView;
            holder.storeInfo = (TextView) convertView.findViewById(R.id.storeTextView);
            convertView.setTag(holder);

        } else {

            holder = (Holder) convertView.getTag();
        }
        Order order = orders.get(position);
        holder.drinkName.setText(order.drinkName);
        holder.note.setText(order.note);
        holder.storeInfo.setText(order.storeInfo);
        return convertView;


    }
//inner class
    class Holder {

        TextView drinkName;
        TextView note;
    TextView storeInfo;

    }
}
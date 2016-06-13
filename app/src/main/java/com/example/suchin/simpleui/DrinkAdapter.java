package com.example.suchin.simpleui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by SuChin.Chiu on 6/13/2016.
 */
public class DrinkAdapter extends BaseAdapter {

    ArrayList<Drink> drinks;
    LayoutInflater inflater;

    public DrinkAdapter(Context context, ArrayList<Drink> drinks) {

        this.drinks = drinks;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return drinks.size();
    }

    @Override
    public Object getItem(int position) {
        return drinks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_dink_item, null);
            holder.drinkNameTextView = (TextView) convertView.findViewById(R.id.drinkNameTextView);
            holder.mPriceTextView = (TextView) convertView.findViewById(R.id.mPriceTextView);
            holder.lPriceTextView = (TextView) convertView.findViewById(R.id.lPriceTextView);
            holder.imageImageView = (ImageView) convertView.findViewById(R.id.drinkImageView);
            convertView.setTag(holder);

        } else {
            holder = (Holder) convertView.getTag();

        }

        Drink drink = drinks.get(position);
        holder.drinkNameTextView.setText(drink.name);
        holder.mPriceTextView.setText(String.valueOf(drink.mPrice));
        holder.lPriceTextView.setText(String.valueOf(drink.lPrice));
        holder.imageImageView.setImageResource(drink.imageId);



        return convertView;
    }

    //inner class
    class Holder {

        ImageView imageImageView;
        TextView drinkNameTextView;
        TextView mPriceTextView;
        TextView lPriceTextView;


    }
}

package com.example.suchin.simpleui;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by SuChin on 2016/6/16.
 */
public class DrinkOrder {
    String drinkName="drink";
    String ice = "正常";
    String sugar = "正常";
    String note = "";
    int lNumber = 0;
    int mNumber = 0;
    int lPrice;
    int mPrice;

    public JSONObject getJsonObject() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("drinkName", drinkName);
            jsonObject.put("ice", ice);
            jsonObject.put("sugar", sugar);
            jsonObject.put("note", note);
            jsonObject.put("lNumber", lNumber);
            jsonObject.put("mNumber", mNumber);
            jsonObject.put("lPrice", lPrice);
            jsonObject.put("mPrice", mPrice);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static DrinkOrder newInstanceWithJsonObjectData(String data) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(data);
            DrinkOrder drinkOrder = new DrinkOrder();
            drinkOrder.ice = jsonObject.getString("ice");
            drinkOrder.drinkName = jsonObject.getString("drinkName");
            drinkOrder.sugar = jsonObject.getString("sugar");
            drinkOrder.note = jsonObject.getString("note");
            drinkOrder.mNumber = jsonObject.getInt("mNumber");
            drinkOrder.lNumber = jsonObject.getInt("lNumber");
            drinkOrder.mPrice = jsonObject.getInt("mPrice");
            drinkOrder.lPrice = jsonObject.getInt("lPrice");
            return drinkOrder;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;


    }

}

package com.example.suchin.simpleui;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by SuChin.Chiu on 6/6/2016.
 */
public class Order {
    String note;
//    String drinkName;
    String menuResults;
    String storeInfo;


    public JSONObject getJsonObject() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("note", note);
            jsonObject.put("menuResults", menuResults);
            jsonObject.put("storeInfo", storeInfo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
    public static Order newInstanceWithJsonObjectData(String data) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(data);
            Order order = new Order();
            order.note = jsonObject.getString("note");
            order.menuResults = jsonObject.getString("menuResults");
            order.storeInfo = jsonObject.getString("storeInfo");
            return order;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;


    }


}



package com.example.suchin.simpleui;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by SuChin.Chiu on 6/13/2016.
 */
public class Drink {
    String name;
    int mPrice;
    int lPrice;
    int imageId;

    public JSONObject getData() {
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("name", name);
            jsonObject.put("price", mPrice);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }
}

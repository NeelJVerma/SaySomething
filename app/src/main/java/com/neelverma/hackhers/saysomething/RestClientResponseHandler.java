package com.neelverma.hackhers.saysomething;

import android.util.Pair;

import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import cz.msebera.android.httpclient.Header;

public class RestClientResponseHandler extends AsyncHttpResponseHandler {
   private MapsActivity mapsActivity;
   private MainActivity mainActivity;
   private static HashMap<Integer, ArrayList<Pair<String, String>>> jsonVals;

   RestClientResponseHandler(MainActivity mainActivity) {
      this.mainActivity = mainActivity;
      jsonVals = new HashMap<>();
   }

   RestClientResponseHandler(MapsActivity mapsActivity) {
      this.mapsActivity = mapsActivity;
      jsonVals = new HashMap<>();
   }

   @Override
   public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
      try {
         JSONObject jsonObject = new JSONObject(new String(responseBody));
         JSONArray jsonArray = jsonObject.getJSONArray("post_data");

         for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            ArrayList<Pair<String, String>> temp = new ArrayList<>();
            temp.add(new Pair<>("desc", jsonObject1.getString("desc")));
            temp.add(new Pair<>("type", jsonObject1.getString("type")));
            temp.add(new Pair<>("time", jsonObject1.getString("time")));
            temp.add(new Pair<>("long", jsonObject1.getString("long")));
            temp.add(new Pair<>("lat", jsonObject1.getString("lat")));

            jsonVals.put(i, temp);
         }

         MapsActivity.setJsonVals(jsonVals);

      } catch (JSONException e) {
         e.printStackTrace();
      }
   }

   @Override
   public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
      error.printStackTrace();
   }

   public static HashMap<Integer, ArrayList<Pair<String, String>>> getJsonVals() {
      return jsonVals;
   }
}
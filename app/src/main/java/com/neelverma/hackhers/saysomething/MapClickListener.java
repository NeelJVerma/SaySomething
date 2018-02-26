package com.neelverma.hackhers.saysomething;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.telephony.SmsManager;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.loopj.android.http.AsyncHttpClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import cz.msebera.android.httpclient.entity.StringEntity;

public class MapClickListener implements GoogleMap.OnMapClickListener {
   private MapsActivity mapsActivity;
   private GoogleMap mapObject;
   private Context context;
   private EditText result1;
   private EditText result2;
   private LatLng latLng;

   MapClickListener(MapsActivity mapsActivity) {
      this.mapsActivity = mapsActivity;
      this.mapObject = this.mapsActivity.getMapObject();
      this.context = this.mapsActivity;
      this.result1 = this.mapsActivity.findViewById(R.id.typeEditText);
      this.result2 = this.mapsActivity.findViewById(R.id.descriptionEditText);
   }

   @Override
   public void onMapClick(LatLng latLng) {
      if (!PostButtonClickHandler.isSelected) {
         return;
      }

      this.latLng = latLng;

      AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
      Date currentTime = Calendar.getInstance().getTime();

      mapObject.addMarker(new MarkerOptions().position(latLng).title(PostButtonClickHandler.result1.getText().toString()).snippet(currentTime.toString()));

      postData(asyncHttpClient);

      result1.setText(null);
      result2.setText(null);

      PostButtonClickHandler.isSelected = false;
   }

   private void postData(AsyncHttpClient asyncHttpClient) {
      MapsActivity.setRequestType(MapsActivity.TYPE_POST);
      JSONObject jsonParams = new JSONObject();

      try {
         jsonParams.put("type", result1.getText());
         jsonParams.put("desc", result2.getText());
         jsonParams.put("long", latLng.longitude);
         jsonParams.put("lat", latLng.latitude);
      } catch (JSONException e) {
         e.printStackTrace();
      }

      StringEntity entity = null;

      try {
         entity = new StringEntity(jsonParams.toString());
      } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
      }

      asyncHttpClient.post(context, "http://173.255.230.88/api/v1/posts", entity, "application/json", new RestClientResponseHandler(mapsActivity));
   }
}
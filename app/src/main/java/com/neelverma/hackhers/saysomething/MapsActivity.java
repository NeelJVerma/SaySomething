package com.neelverma.hackhers.saysomething;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.loopj.android.http.AsyncHttpClient;

import java.util.ArrayList;
import java.util.HashMap;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
   private GoogleMap mapObject;
   public static final int TYPE_GET = 0;
   public static final int TYPE_POST = 1;
   private static int requestType;
   private static HashMap<Integer, ArrayList<Pair<String, String>>> jsonVals = new HashMap<>();

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_maps);
      final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
         .findFragmentById(R.id.map);
      mapFragment.getMapAsync(this);

      requestType = TYPE_GET;

      ImageButton postButton = findViewById(R.id.postButton);
      postButton.setOnClickListener(new PostButtonClickHandler(this));

      ImageButton logButton = findViewById(R.id.logButton);
      logButton.setOnClickListener(new LogButtonClickListener(this));

      ImageButton sendButton = findViewById(R.id.sendButton);
      sendButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + "7323208976"));
            intent.putExtra("sms_body", "TESTING. REAL INFORMATION COMING SOON.");
            startActivity(intent);
         }
      });
   }

   @Override
   public void onMapReady(GoogleMap googleMap) {
      mapObject = googleMap;

      enableMap();
   }

   public GoogleMap getMapObject() {
      return mapObject;
   }

   private void enableMap() {
      LatLng ramapo = new LatLng(41.0815, -74.1746);

      float zoomLevel = 15.5f;

      mapObject.moveCamera(CameraUpdateFactory.newLatLngZoom(ramapo, zoomLevel));
      mapObject.setOnMapClickListener(new MapClickListener(this));
      mapObject.getUiSettings().setMapToolbarEnabled(false);

      for (Integer i : jsonVals.keySet()) {
         double longitude = 0.0;
         double latitude = 0.0;
         String type = null;
         String time = null;

         for (Pair<String, String> p : jsonVals.get(i)) {
            if (p.first.equals("long")) {
               longitude = Double.parseDouble(p.second);
            } else if (p.first.equals("lat")) {
               latitude = Double.parseDouble(p.second);
            } else if (p.first.equals("time")) {
               time = p.second;
            } else if (p.first.equals("type")) {
               type = p.second;
            }
         }

         LatLng latLng = new LatLng(latitude, longitude);
         mapObject.addMarker(new MarkerOptions().position(latLng).title(type).snippet(time));
      }
   }

   public static int getRequestType() {
      return requestType;
   }

   public static void setRequestType(int requestType1) {
      requestType = requestType1;
   }

   public static HashMap<Integer, ArrayList<Pair<String, String>>> getJsonVals() {
      return jsonVals;
   }

   public static void setJsonVals(HashMap<Integer, ArrayList<Pair<String, String>>> jsonVals1) {
      jsonVals = jsonVals1;
   }
}
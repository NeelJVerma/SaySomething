package com.neelverma.hackhers.saysomething;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

import com.loopj.android.http.AsyncHttpClient;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
   private Context context;

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      setContentView(R.layout.activity_main);
      context = this;

      AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

      asyncHttpClient.get("http://173.255.230.88/api/v1/posts", new RestClientResponseHandler(this));

      Button seeMapButton = findViewById(R.id.seeMapButton);
      seeMapButton.setOnClickListener(new SeeMapButtonClickListener(this));
   }
}

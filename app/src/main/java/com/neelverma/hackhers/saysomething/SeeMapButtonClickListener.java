package com.neelverma.hackhers.saysomething;

import android.content.Intent;
import android.util.Pair;
import android.view.View;

import com.loopj.android.http.AsyncHttpClient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class SeeMapButtonClickListener implements View.OnClickListener {
   private MainActivity mainActivity;

   SeeMapButtonClickListener(MainActivity mainActivity) {
      this.mainActivity = mainActivity;
   }

   @Override
   public void onClick(View v) {
      Intent eventInformationIntent = new Intent(mainActivity, MapsActivity.class);

      mainActivity.startActivity(eventInformationIntent);
   }
}
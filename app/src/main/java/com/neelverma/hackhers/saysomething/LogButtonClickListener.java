package com.neelverma.hackhers.saysomething;

import android.content.Intent;
import android.view.View;

public class LogButtonClickListener implements View.OnClickListener {
   private MapsActivity mapsActivity;

   LogButtonClickListener(MapsActivity mapsActivity) {
      this.mapsActivity = mapsActivity;
   }

   @Override
   public void onClick(View v) {
      Intent logIntent = new Intent(mapsActivity, LogActivity.class);

      mapsActivity.startActivity(logIntent);
   }
}

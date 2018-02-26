package com.neelverma.hackhers.saysomething;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class PostButtonClickHandler implements View.OnClickListener {
   private MapsActivity mapsActivity;
   public static EditText result1;
   public static EditText result2;
   public static boolean isSelected;

   PostButtonClickHandler(MapsActivity mapsActivity) {
      this.mapsActivity = mapsActivity;
      this.result1 = this.mapsActivity.findViewById(R.id.typeEditText);
      this.result2 = this.mapsActivity.findViewById(R.id.descriptionEditText);
      isSelected = true;
   }

   @Override
   public void onClick(View v) {
      isSelected = true;
      LayoutInflater li = LayoutInflater.from(mapsActivity);
      View promptsView = li.inflate(R.layout.prompts, null);

      AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
         mapsActivity);

      alertDialogBuilder.setView(promptsView);

      final EditText userInput1 = promptsView
         .findViewById(R.id.editTextDialogUserInput1);

      final EditText userInput2 = promptsView
         .findViewById(R.id.editTextDialogUserInput2);

      alertDialogBuilder
         .setCancelable(false)
         .setPositiveButton("OK",
            new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
                  result1.setText(userInput1.getText());
                  result2.setText(userInput2.getText());
               }
            });

      AlertDialog alertDialog = alertDialogBuilder.create();

      alertDialog.show();
   }
}

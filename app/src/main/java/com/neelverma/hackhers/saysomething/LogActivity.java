package com.neelverma.hackhers.saysomething;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class LogActivity extends AppCompatActivity {
   private Context context;

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_log);
      context = this;

      HashMap<Integer, ArrayList<Pair<String, String>>> jsonVals = MapsActivity.getJsonVals();

      TextView textView1 = findViewById(R.id.textView1);
      int index1 = jsonVals.size() - 1;
      String desc1 = jsonVals.get(index1).get(0).second;
      String type1 = jsonVals.get(index1).get(1).second;
      String overall1 = type1 + " - " + desc1;
      textView1.setText("1: " + overall1);

      TextView textView2 = findViewById(R.id.textView2);
      int index2 = jsonVals.size() - 2;
      String desc2 = jsonVals.get(index2).get(0).second;
      String type2 = jsonVals.get(index2).get(1).second;
      String overall2 = type2 + " - " + desc2;
      textView2.setText("2: " + overall2);

      TextView textView3 = findViewById(R.id.textView3);
      int index3 = jsonVals.size() - 3;
      String desc3 = jsonVals.get(index3).get(0).second;
      String type3 = jsonVals.get(index3).get(1).second;
      String overall3 = type3 + " - " + desc3;
      textView3.setText("3: " + overall3);

      TextView textView4 = findViewById(R.id.textView4);
      int index4 = jsonVals.size() - 4;
      String desc4 = jsonVals.get(index4).get(0).second;
      String type4 = jsonVals.get(index4).get(1).second;
      String overall4 = type4 + " - " + desc4;
      textView4.setText("4: " + overall4);

      TextView textView5 = findViewById(R.id.textView5);
      int index5 = jsonVals.size() - 5;
      String desc5 = jsonVals.get(index5).get(0).second;
      String type5 = jsonVals.get(index5).get(1).second;
      String overall5 = type5 + " - " + desc5;
      textView5.setText("5: " + overall5);

      TextView textView6 = findViewById(R.id.textView6);
      int index6 = jsonVals.size() - 6;
      String desc6 = jsonVals.get(index6).get(0).second;
      String type6 = jsonVals.get(index6).get(1).second;
      String overall6 = type6 + " - " + desc6;
      textView6.setText("6: " + overall6);

      TextView textView7 = findViewById(R.id.textView7);
      int index7 = jsonVals.size() - 7;
      String desc7 = jsonVals.get(index7).get(0).second;
      String type7 = jsonVals.get(index7).get(1).second;
      String overall7 = type7 + " - " + desc7;
      textView7.setText("7: " + overall7);

      TextView textView8 = findViewById(R.id.textView8);
      int index8 = jsonVals.size() - 8;
      String desc8 = jsonVals.get(index8).get(0).second;
      String type8 = jsonVals.get(index8).get(1).second;
      String overall8 = type8 + " - " + desc8;
      textView8.setText("8: " + overall8);

      TextView textView9 = findViewById(R.id.textView9);
      int index9 = jsonVals.size() - 9;
      String desc9 = jsonVals.get(index9).get(0).second;
      String type9 = jsonVals.get(index9).get(1).second;
      String overall9 = type9 + " - " + desc9;
      textView9.setText("9: " + overall9);

      TextView textView10 = findViewById(R.id.textView10);
      int index10 = jsonVals.size() - 10;
      String desc10 = jsonVals.get(index10).get(0).second;
      String type10 = jsonVals.get(index10).get(1).second;
      String overall10 = type10 + " - " + desc10;
      textView10.setText("10: " + overall10);
   }
}
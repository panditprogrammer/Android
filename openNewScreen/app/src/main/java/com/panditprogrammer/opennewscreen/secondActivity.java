package com.panditprogrammer.opennewscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();   // create new getIntent() instance
        String firstScreenValue = intent.getStringExtra(MainActivity.EXTRA_MESSAGE); // set first screen passing value through intent
        TextView textView = findViewById(R.id.secondTextView);  // create new textView variable
        Log.i("myLog", firstScreenValue);
        if(firstScreenValue.length() == 0)
        {
            Toast.makeText(this, "You have Entered Nothing.", Toast.LENGTH_SHORT).show();
            firstScreenValue = "Please Enter something!";
            textView.setText(firstScreenValue);    // set the value
        }
        else {
            textView.setText(firstScreenValue);    // set the value
        }



    }
}
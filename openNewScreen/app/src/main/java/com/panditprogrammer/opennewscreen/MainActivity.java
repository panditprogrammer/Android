package com.panditprogrammer.opennewscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.panditprogrammer.opennewscreen.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void openActivity(View view) {
        Intent intent = new Intent(this,secondActivity.class);  // create new instance of Intent
        EditText editText = (EditText) findViewById(R.id.inputText);   //target the editText field

        String inputValue = editText.getText().toString();  // get the value
        intent.putExtra(EXTRA_MESSAGE, inputValue);    // send the value

        Toast.makeText(this, "Opening", Toast.LENGTH_SHORT).show();
        startActivity(intent);   // finally start the activity
    }
}
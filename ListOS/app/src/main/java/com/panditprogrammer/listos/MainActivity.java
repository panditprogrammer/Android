package com.panditprogrammer.listos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get the id of layout
        ListView osList = findViewById(R.id.oslist); //getting id
        // create an arraylist for data to show in list
        ArrayList<String> operating_system = new ArrayList<String>();
        operating_system.add("MS DOS");
        operating_system.add("Windows");
        operating_system.add("iOS");
        operating_system.add("Android");
        operating_system.add("Kali Linux");
        operating_system.add("Ubuntu");
        operating_system.add("Chrome OS");
        // create an adapter for layout and pass the arrayList
        ArrayAdapter<String> osArray_adaptor = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,operating_system);
        // set the adapter the listview
        osList.setAdapter(osArray_adaptor);
        // set onclick listener
        osList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                type casting  view to textview and get text
                Toast.makeText(MainActivity.this, ((TextView)view).getText().toString()+"- This is an example of an operating system", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

package com.panditprogrammer.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find your recyclerView using it's id
        RecyclerView recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        // our data to show in list
        String[] languages = {"python","C Lanugage", "C++", "Java","PYthon","php","javascript","Kotlin","Ruby","Assembly"};
        // set the adapter in recylerView using Custom TestAdapter
        recyclerView.setAdapter(new TestAdapter(languages));

    }
}
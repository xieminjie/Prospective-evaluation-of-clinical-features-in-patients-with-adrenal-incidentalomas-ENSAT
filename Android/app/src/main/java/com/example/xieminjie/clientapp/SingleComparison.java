package com.example.xieminjie.clientapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.github.mikephil.charting.charts.BarChart;
import com.google.gson.Gson;
import java.util.ArrayList;

public class SingleComparison extends AppCompatActivity {
    private String averageValue;
    private Toolbar toolbar;
    private Gson gson;
    private ChartHandler chartHandler;
    private BarChart barChart;
    private ArrayList<String> xArray;
    private ArrayList<String> yArray;
    private int value;
    private CompareObject data;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String json = intent.getStringExtra("searchComparisonName");
        setContentView(R.layout.activity_single_comparison);
        toolbar = (Toolbar)findViewById(R.id.navbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_single_comparison, menu);
        return true;
    }
    @Override
    protected void onStart(){
        super.onStart();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        if(id==android.R.id.home){
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}

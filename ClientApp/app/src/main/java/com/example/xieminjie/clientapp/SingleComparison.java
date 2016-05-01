package com.example.xieminjie.clientapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.github.mikephil.charting.charts.BarChart;
import com.google.gson.Gson;

import java.util.ArrayList;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;

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
      /*  Log.d("mydata",json);
        gson = new Gson();
        data= gson.fromJson(json,CompareObject.class);
        String individualVal = data.getIndividual();
        String averageVal = data.getAverage();
        Log.d("mydata",individualVal+"indvidual");
        xArray = new ArrayList<>();
        yArray = new ArrayList<>();
        xArray.add("you");
        xArray.add("average");
        yArray.add(individualVal);
        yArray.add(averageVal);


        barChart = (BarChart)findViewById(R.id.singlechart);
        chartHandler = new ChartHandler();*/
      //  chartHandler.createChart(barChart,"compare",xArray,yArray);
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

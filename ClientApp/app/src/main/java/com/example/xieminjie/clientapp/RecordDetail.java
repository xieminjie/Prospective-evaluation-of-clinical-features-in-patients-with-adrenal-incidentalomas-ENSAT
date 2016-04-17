package com.example.xieminjie.clientapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;

public class RecordDetail extends AppCompatActivity implements SearchView.OnQueryTextListener{
    private Toolbar toolbar;
    private SearchView searchView;
    private String query;
    private ArrayList<Record> arrayList;
    private Hashtable hashtable;
    private Record record;
    private int index;
    private BarChart barChart;
    private ChartHandler chartHandler;
    private ArrayList<String> dateArrayList;
    private ArrayList<String> dataArrayList;
    private ArrayList<String> dateArray;
    private ArrayList<String> dataArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_detail);
        toolbar = (Toolbar)findViewById(R.id.navbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);
        searchView = (SearchView)findViewById(R.id.record_SearchView);
        searchView.setOnQueryTextListener(this);
        barChart = (BarChart)findViewById(R.id.chart);
        Intent intent = getIntent();
        query = intent.getStringExtra("searchName");
        index = DataProcessingHandler.getIndex(query);
        chartHandler = new ChartHandler();

        dateArrayList = IOStorageHandler.readData("record.csv", 15, getApplicationContext());
        dataArrayList = IOStorageHandler.readData("record.csv", index, getApplicationContext());
        dateArray = DataProcessingHandler.dateProcessing(dateArrayList);
        dataArray = DataProcessingHandler.dateProcessing(dataArrayList);
        chartHandler.createChart(index, barChart, query,dateArray,dataArray);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_record_detail, menu);
        return true;
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

    @Override
    public boolean onQueryTextSubmit(String s) {
        barChart.clear();
        index = DataProcessingHandler.getIndex(s);
        dateArrayList = IOStorageHandler.readData("record.csv", 15, getApplicationContext());
        dataArrayList = IOStorageHandler.readData("record.csv", index, getApplicationContext());
        dateArray = DataProcessingHandler.dateProcessing(dateArrayList);
        dataArray = DataProcessingHandler.dateProcessing(dataArrayList);
        chartHandler.createChart(index, barChart, query,dateArray,dataArray);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}

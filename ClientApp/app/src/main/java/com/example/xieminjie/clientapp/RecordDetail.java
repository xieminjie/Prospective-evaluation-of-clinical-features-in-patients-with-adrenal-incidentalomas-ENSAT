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

import java.util.ArrayList;
import java.util.Hashtable;

public class RecordDetail extends AppCompatActivity implements SearchView.OnQueryTextListener{
    private Toolbar toolbar;
    private SearchView searchView;
    private String query;
    private ArrayList<Record> arrayList;
    private ArrayList<String> dateArrayList;
    private ArrayList<String> dataArrayList;
    private IOStorageHandler ioStorageHandler;
    private Hashtable hashtable;
    private Record record;
    private int index = 0;
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

        Intent intent = getIntent();
        query = intent.getStringExtra("searchName");
        arrayList = getDate(ioStorageHandler.readRecordLog("record.csv", getApplicationContext()));

        Hashtable<String,String> hashtable = new Hashtable();
        hashtable.put("problem","0");
        hashtable.put("ill","1");
        hashtable.put("palpitations","2");
        hashtable.put("weight_gain","3");
        hashtable.put("high_blood_pressure","4");
        hashtable.put("muscle_weakness","5");
        hashtable.put("sweating","6");
        hashtable.put("flushing","7");
        hashtable.put("headache","8");
        hashtable.put("chest_pain","9");
        hashtable.put("back_pain","10");
        hashtable.put("bruising","11");
        hashtable.put("fatigue","12");
        hashtable.put("panic","13");
        hashtable.put("sadness","14");
        hashtable.put("record_date","15");
        if (hashtable.containsKey(query)){
            index = Integer.parseInt(hashtable.get(query).toString());
        }else{

        }
        //date
        dateArrayList = ioStorageHandler.readData("record.csv", 15, getApplicationContext());
        dataArrayList = ioStorageHandler.readData("record.csv",index,getApplicationContext());
        BarChart barChart = (BarChart)findViewById(R.id.chart);
        BarData data = new BarData(getXAxisValues(dateArrayList),getDataSet(dataArrayList));
        barChart.setData(data);
        barChart.setDescription("My Chart");
        barChart.animateXY(2000, 2000);
        barChart.invalidate();



    }

    private ArrayList getDate(ArrayList<Record> recordArrayList){
        ArrayList dateArrayList = new ArrayList();
        int day = recordArrayList.size();
        if(day<=5){
            for(int i=recordArrayList.size()-1;i>=0;i--){
                dateArrayList.add(recordArrayList.get(i).getRecord_date().toString());
            }
        }else{
            for(int i=recordArrayList.size()-1;i>=recordArrayList.size()-5;i--){
                dateArrayList.add(recordArrayList.get(i).getRecord_date().toString());
            }
        }
        return dateArrayList;
    }

    private ArrayList<IBarDataSet> getDataSet(ArrayList dataArrayList) {
        ArrayList<IBarDataSet> dataSets;
        ArrayList<BarEntry> valueSet = new ArrayList<>();
        for(int i =dataArrayList.size()-1;i>=0;i--){
            BarEntry barEntry = new BarEntry(10,dataArrayList.size()-1-i);
            valueSet.add(barEntry);
        }
        BarDataSet barDataSet = new BarDataSet(valueSet,"brand 1 ");
        barDataSet.setColor(Color.rgb(0,155,0));
        dataSets = new ArrayList<>();
        dataSets.add(barDataSet);
        return dataSets;
    }


    private ArrayList<String> getXAxisValues(ArrayList dateArrayList) {
        ArrayList<String> xAxis = new ArrayList<>();
        for(int i=dateArrayList.size()-1;i>=0;i--){
            xAxis.add(dateArrayList.get(i).toString());
        }
        return xAxis;
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
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}

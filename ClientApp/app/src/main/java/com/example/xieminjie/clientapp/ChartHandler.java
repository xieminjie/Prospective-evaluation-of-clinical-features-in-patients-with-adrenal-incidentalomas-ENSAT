package com.example.xieminjie.clientapp;

import android.graphics.Color;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

/**
 * Created by xieminjie on 13/04/2016.
 */
public class ChartHandler {
    public void createChart(BarChart barChart,String query,ArrayList<String> dateArray,ArrayList<String> dataArray){
        BarData data = new BarData(getXAxisValues(dateArray),getDataSet(dataArray,query));
        barChart.setData(data);
        barChart.setDescription("My Chart");
        barChart.animateXY(2000, 2000);
        barChart.invalidate();

    }
    private ArrayList<IBarDataSet> getDataSet(ArrayList dataArray,String query) {
        ArrayList<IBarDataSet> dataSets;
        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        for (int i=0;i<dataArray.size();i++){
            BarEntry v = new BarEntry(Integer.valueOf(dataArray.get(i).toString()),i);
            valueSet1.add(v);
        }
        BarDataSet barDataSet = new BarDataSet(valueSet1,query);
        barDataSet.setColor(Color.rgb(0, 155, 0));
        dataSets = new ArrayList<>();
        dataSets.add(barDataSet);
        return dataSets;
    }

    private ArrayList<String> getXAxisValues(ArrayList dateArray) {
        ArrayList<String> xAxis = new ArrayList<>();
        for(int i=0;i<dateArray.size();i++){
            xAxis.add(dateArray.get(i).toString());
        }
        return xAxis;
    }
}

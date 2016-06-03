package com.example.xieminjie.clientapp;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by xieminjie on 13/04/2016.
 */
public abstract class DataProcessingHandler {
    // get data of past 5 days
    public static ArrayList<String> dateProcessing(ArrayList a){
        ArrayList<String> array = new ArrayList<>();
        if(a.size()<=5){
            for(int i=0;i<5;i++){
                array.add(a.get(i).toString());
            }
        }else{
            for(int i = a.size()-1;i>=a.size()-5;i--){
                array.add(a.get(i).toString());
            }
        }
        return array;
    }
    // Get index of data in data array
    public static int getIndex(String query){
        Hashtable<String,String> hashtable = new Hashtable();
        int index = 0;
        hashtable.put("problem","0");
        hashtable.put("ill","1");
        hashtable.put("palpitations","2");
        hashtable.put("weightGain","3");
        hashtable.put("highBloodPressure","4");
        hashtable.put("muscleWeakness", "5");
        hashtable.put("sweating", "6");
        hashtable.put("flushing", "7");
        hashtable.put("headache", "8");
        hashtable.put("chestPain", "9");
        hashtable.put("backPain", "10");
        hashtable.put("bruising", "11");
        hashtable.put("fatigue", "12");
        hashtable.put("panic", "13");
        hashtable.put("sadness","14");
        hashtable.put("recordDate", "15");
        if (hashtable.containsKey(query)){
            index = Integer.parseInt(hashtable.get(query).toString());
        }else{
            index = 0;
        }
        return index;
    }
    public static int getItemAverageValue(int index,Context context){
        int average = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList = IOStorageHandler.readData("record.csv",index,context);
        for(int i=0;i<arrayList.size();i++){
            Log.d("mydata",arrayList.get(i));
        }
        return average;
    }
    public static int getAverageValue(int index,Context context){
        int averageValue;
        int overallValue = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList = IOStorageHandler.readData("record.csv", index, context);
        for(int i=0;i<arrayList.size();i++){
            overallValue+=Integer.valueOf(arrayList.get(i));
        }
        averageValue = overallValue/arrayList.size();
        return averageValue;
    }
}

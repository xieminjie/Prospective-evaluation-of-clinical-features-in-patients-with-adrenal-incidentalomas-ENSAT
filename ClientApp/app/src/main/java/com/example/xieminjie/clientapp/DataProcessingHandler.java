package com.example.xieminjie.clientapp;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by xieminjie on 13/04/2016.
 */
public abstract class DataProcessingHandler {
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
}

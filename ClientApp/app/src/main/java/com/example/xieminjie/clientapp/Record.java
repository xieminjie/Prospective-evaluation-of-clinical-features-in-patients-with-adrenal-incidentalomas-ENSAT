package com.example.xieminjie.clientapp;

import java.util.Hashtable;

/**
 * Created by xieminjie on 25/03/2016.
 */
public class Record {
    private int problem;
    private int ill;
    private int palpitations;
    private int weight_gain;
    private int high_blood_pressure;
    private int muscle_weakness;
    private int sweating;
    private int flushing;
    private int headache;
    private int chest_pain;
    private int back_pain;
    private int bruising;
    private int fatigue;
    private int panic;
    private int sadness;
    private String record_date;

    public Record(int problem, int ill, int palpitations, int weight_gain, int high_blood_pressure, int muscle_weakness, int sweating, int flushing, int headache, int chest_pain, int back_pain, int bruising, int fatigue, int panic, int sadness, String record_date) {
        this.problem = problem;
        this.ill = ill;
        this.palpitations = palpitations;
        this.weight_gain = weight_gain;
        this.high_blood_pressure = high_blood_pressure;
        this.muscle_weakness = muscle_weakness;
        this.sweating = sweating;
        this.flushing = flushing;
        this.headache = headache;
        this.chest_pain = chest_pain;
        this.back_pain = back_pain;
        this.bruising = bruising;
        this.fatigue = fatigue;
        this.panic = panic;
        this.sadness = sadness;
        this.record_date = record_date;
    }

    public Hashtable getRecordHashTable(){
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
        return hashtable;
    }
    public int getProblem() {
        return problem;
    }

    public void setProblem(int problem) {
        this.problem = problem;
    }

    public int getIll() {
        return ill;
    }

    public void setIll(int ill) {
        this.ill = ill;
    }

    public int getPalpitations() {
        return palpitations;
    }

    public void setPalpitations(int palpitations) {
        this.palpitations = palpitations;
    }

    public int getWeight_gain() {
        return weight_gain;
    }

    public void setWeight_gain(int weight_gain) {
        this.weight_gain = weight_gain;
    }

    public int getHigh_blood_pressure() {
        return high_blood_pressure;
    }

    public void setHigh_blood_pressure(int high_blood_pressure) {
        this.high_blood_pressure = high_blood_pressure;
    }

    public int getMuscle_weakness() {
        return muscle_weakness;
    }

    public void setMuscle_weakness(int muscle_weakness) {
        this.muscle_weakness = muscle_weakness;
    }

    public int getSweating() {
        return sweating;
    }

    public void setSweating(int sweating) {
        this.sweating = sweating;
    }

    public int getFlushing() {
        return flushing;
    }

    public void setFlushing(int flushing) {
        this.flushing = flushing;
    }

    public int getHeadache() {
        return headache;
    }

    public void setHeadache(int headache) {
        this.headache = headache;
    }

    public int getChest_pain() {
        return chest_pain;
    }

    public void setChest_pain(int chest_pain) {
        this.chest_pain = chest_pain;
    }

    public int getBack_pain() {
        return back_pain;
    }

    public void setBack_pain(int back_pain) {
        this.back_pain = back_pain;
    }

    public int getBruising() {
        return bruising;
    }

    public void setBruising(int bruising) {
        this.bruising = bruising;
    }

    public int getFatigue() {
        return fatigue;
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }

    public int getPanic() {
        return panic;
    }

    public void setPanic(int panic) {
        this.panic = panic;
    }

    public int getSadness() {
        return sadness;
    }

    public void setSadness(int sadness) {
        this.sadness = sadness;
    }

    public String getRecord_date() {
        return record_date;
    }

    public void setRecord_date(String record_date) {
        this.record_date = record_date;
    }
}

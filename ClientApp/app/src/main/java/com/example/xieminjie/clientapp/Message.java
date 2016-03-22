package com.example.xieminjie.clientapp;

/**
 * Created by xieminjie on 8/03/2016.
 */
public class Message {
    private int problem;
    private int ill;
    private String user_record;
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
    private int body_hair_growth;
    private String record_date;

    public Message(int problem, int ill,int palpitations, int weight_gain, int high_blood_pressure, int muscle_weakness, int sweating, int flushing, int headache, int chest_pain, int back_pain, int bruising, int fatigue, int panic, int sadness,String user_record) {

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
        this.user_record = user_record;
    }
}

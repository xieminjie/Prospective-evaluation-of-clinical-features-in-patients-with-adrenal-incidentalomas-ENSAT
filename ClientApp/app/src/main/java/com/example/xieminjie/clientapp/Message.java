package com.example.xieminjie.clientapp;

/**
 * Created by xieminjie on 8/03/2016.
 */
public class Message {
    private boolean problem;
    private boolean ill;
    private String user_record;
    private int palpitations;
    private int weight_gain;
    private int high_blood_pressure;
    private int muscle_weakness;
    private int sweating;
    private int flushing;
    private int headache;
    private int chesk_pain;
    private int back_pain;
    private int bruising;
    private int fatigue;
    private int panic;
    private int sadness;
    private int body_hair_growth;
    private String record_date;

    public Message(boolean problem, boolean ill, String user_record, int palpitations, int weight_gain, int high_blood_pressure, int muscle_weakness, int sweating, int flushing, int headache, int chesk_pain, int back_pain, int bruising, int fatigue, int panic, int sadness, int body_hair_growth, String record_date) {
        this.problem = problem;
        this.ill = ill;
        this.user_record = user_record;
        this.palpitations = palpitations;
        this.weight_gain = weight_gain;
        this.high_blood_pressure = high_blood_pressure;
        this.muscle_weakness = muscle_weakness;
        this.sweating = sweating;
        this.flushing = flushing;
        this.headache = headache;
        this.chesk_pain = chesk_pain;
        this.back_pain = back_pain;
        this.bruising = bruising;
        this.fatigue = fatigue;
        this.panic = panic;
        this.sadness = sadness;
        this.body_hair_growth = body_hair_growth;
        this.record_date = record_date;
    }
}

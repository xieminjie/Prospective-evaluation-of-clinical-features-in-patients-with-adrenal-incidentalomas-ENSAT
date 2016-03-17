package com.example.xieminjie.clientapp;

/**
 * Created by xieminjie on 8/03/2016.
 */
public class Message {
    private boolean ifProblem;
    private boolean ifillness;
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
    public Message(){};
    public Message(boolean ifillness,int palpitations){
        this.ifillness = ifillness;
        this.palpitations = palpitations;
    }
    public boolean isIfProblem() {
        return ifProblem;
    }

    public void setIfProblem(boolean ifProblem) {
        this.ifProblem = ifProblem;
    }

    public boolean isIfillness() {
        return ifillness;
    }

    public void setIfillness(boolean ifillness) {
        this.ifillness = ifillness;
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

    public int getChesk_pain() {
        return chesk_pain;
    }

    public void setChesk_pain(int chesk_pain) {
        this.chesk_pain = chesk_pain;
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

    public int getBody_hair_growth() {
        return body_hair_growth;
    }

    public void setBody_hair_growth(int body_hair_growth) {
        this.body_hair_growth = body_hair_growth;
    }
}

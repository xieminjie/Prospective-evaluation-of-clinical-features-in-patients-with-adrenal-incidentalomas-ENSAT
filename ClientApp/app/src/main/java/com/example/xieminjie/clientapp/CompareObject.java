package com.example.xieminjie.clientapp;

/**
 * Created by xieminjie on 1/05/2016.
 */
public class CompareObject {
    private String individual;
    private String average;
    public CompareObject(String individual, String average){
        this.individual = individual;
        this.average = average;
    }

    public String getIndividual() {
        return individual;
    }

    public void setIndividual(String individual) {
        this.individual = individual;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }
}

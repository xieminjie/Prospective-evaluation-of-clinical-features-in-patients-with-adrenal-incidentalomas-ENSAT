package com.example.xieminjie.clientapp;

/**
 * Created by xieminjie on 8/03/2016.
 */
public class User {
    private String sex="Male";
    private int age;
    private String diagnosis;
    public User(){};
    public User(String sex,int age,String diagnosis){
        this.sex = sex;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}

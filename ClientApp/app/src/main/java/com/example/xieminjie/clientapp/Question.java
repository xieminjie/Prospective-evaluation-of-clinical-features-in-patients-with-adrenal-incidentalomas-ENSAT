package com.example.xieminjie.clientapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by xieminjie on 16/03/2016.
 */
public class Question {
    private String name;
    private int mark;
    public Question(String name,int mark){
        this.name = name;
        this.mark = mark;
    }
   public static String[] questionnames = {"if ill","palpitations","weight gain","high blood pressure","muscle weakness","sweating",
            "flushing","headache","chest pain","back pain","bruising","fatigue","panic/anxiety","sadness","body hair growth"};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
   public static ArrayList<Question> getQuestions(){
        ArrayList<Question> questions = new ArrayList<Question>();
        for(int i=0;i<questionnames.length;i++){
            questions.add(new Question(questionnames[i],0));
        }
        return questions;
    }
}

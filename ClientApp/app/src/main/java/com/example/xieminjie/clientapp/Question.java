package com.example.xieminjie.clientapp;

import java.util.ArrayList;

/**
 * Created by xieminjie on 16/03/2016.
 */
public class Question {
    public String displayname;
    public static String[] questionnames = {"palpitations","weight gain","high blood pressure","muscle weakness","sweating",
            "flushing","headache","chest pain","back pain","bruising","fatigue","panic/anxiety","sadness","body hair growth"};
    public Question(String displayname){
        this.displayname = displayname;
    }
    public static ArrayList<Question> getQuestions(){
        ArrayList<Question> questions = new ArrayList<Question>();
        for(int i=0;i<questionnames.length;i++){
            questions.add(new Question(questionnames[i]));
        }
        return questions;
    }
}

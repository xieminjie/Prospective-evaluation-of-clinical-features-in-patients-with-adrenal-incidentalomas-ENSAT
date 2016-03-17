package com.example.xieminjie.clientapp;

import java.util.ArrayList;

/**
 * Created by xieminjie on 16/03/2016.
 */
public class Question {
    public String displayname;
    public Question(String displayname){
        this.displayname = displayname;
    }
    public static ArrayList<Question> getQuestions(){
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(new Question("a"));
        questions.add(new Question("b"));
        questions.add(new Question("c"));
        questions.add(new Question("d"));
        questions.add(new Question("e"));
        questions.add(new Question("f"));
        questions.add(new Question("g"));
        questions.add(new Question("h"));
        questions.add(new Question("i"));

        return questions;
    }
}

package com.example.xieminjie.clientapp;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SurveyDetails extends AppCompatActivity {
    private Toolbar toolbar;
    private String[] surveyQuestion = {"fillness","Palpitations","Weight_gain"};
    private Message message;
    public static final String TAG="myActivity";
    private ListView listView;
    private Question question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_details);
        initInterface();
    }
    private void initInterface(){
        toolbar = (Toolbar)findViewById(R.id.navbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);
        ArrayList<Question> arraylist = new ArrayList<Question>();
        QuestionAdapter questionAdapter = new QuestionAdapter(this,arraylist);
        question = new Question("aasdfa");
        questionAdapter.add(question);
        listView = (ListView)findViewById(R.id.question_listView);
        listView.setAdapter(questionAdapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        if(id==android.R.id.home){
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}

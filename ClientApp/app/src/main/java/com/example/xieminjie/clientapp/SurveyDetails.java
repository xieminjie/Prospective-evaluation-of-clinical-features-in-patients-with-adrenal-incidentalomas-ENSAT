package com.example.xieminjie.clientapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;

import io.socket.client.Socket;

public class SurveyDetails extends AppCompatActivity {
    private Toolbar toolbar;
    public static final String TAG="myActivity";
    private Button sendBtn;
    private Socket socket;
    ArrayList<Question> questions;
    private Message message;
    private DateHandler dateHandler;
    //Message variables
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_details);
        initInterface();
        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                problem = 1;
                ill = questions.get(0).getMark();
                palpitations = questions.get(1).getMark();
                weight_gain = questions.get(2).getMark();
                high_blood_pressure = questions.get(3).getMark();
                muscle_weakness = questions.get(4).getMark();
                sweating = questions.get(5).getMark();
                flushing = questions.get(6).getMark();
                headache = questions.get(7).getMark();
                chest_pain = questions.get(8).getMark();
                back_pain = questions.get(9).getMark();
                bruising = questions.get(10).getMark();
                fatigue = questions.get(11).getMark();
                panic = questions.get(12).getMark();
                sadness = questions.get(13).getMark();
                user_record = "jx";
            //    record_date = dateHandler.getCurrentData();
                message = new Message(problem,ill,palpitations,weight_gain,high_blood_pressure,muscle_weakness,sweating,flushing,headache,chest_pain,back_pain,bruising,fatigue,panic,sadness,user_record);
                String json = ConvertToJson(message);
                sendData(json,socket);
            }
        });
    }
    private void initInterface(){
        toolbar = (Toolbar)findViewById(R.id.navbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);
        questions = Question.getQuestions();
        QuestionAdapter adapter = new QuestionAdapter(this,questions);
        ListView listView = (ListView)findViewById(R.id.question_listView);
        listView.setAdapter(adapter);
        sendBtn = (Button)findViewById(R.id.question_btn);
    }
    private void sendData(String str, Socket socket){
        socket.emit("send question Data",str);
    }
    @Override
    protected void onStart(){
        super.onStart();
        ClientApplication app = (ClientApplication)this.getApplication();
        socket = app.getSocket();
        socket.connect();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        socket.disconnect();
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
    private String ConvertToJson (Message message){
        String str = null;
        Gson gson = new Gson();
        str = gson.toJson(message);
        return str;
    }
}

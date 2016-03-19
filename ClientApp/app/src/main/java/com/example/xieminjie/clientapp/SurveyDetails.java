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

import io.socket.client.Socket;

public class SurveyDetails extends AppCompatActivity {
    private Toolbar toolbar;
    public static final String TAG="myActivity";
    private Button sendBtn;
    private Socket socket;
    ArrayList<Question> questions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_details);
        initInterface();

        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String json = ConvertToJson(questions);
                Log.d(TAG, json);
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
    private String ConvertToJson (ArrayList<Question> arrayList){
        String str = null;
        Gson gson = new Gson();
        str = gson.toJson(arrayList);
        return str;
    }
}

package com.example.xieminjie.clientapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import io.socket.client.Socket;

public class Register extends AppCompatActivity {
    private int age;
    private String sex;
    private String diagnosis;
    private Switch genderSwitch;
    private Toolbar toolbar;
    private EditText ageTextFeild;
    private Button sendBtn;
    private User user;
    private Socket socket;
    public static final String TAG="myActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initInterface();
        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               // sendRegisterData(user, socket);
                Log.d(TAG, "click");
            }
        });
    }
    private void initInterface(){
        toolbar = (Toolbar)findViewById(R.id.main_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);
        genderSwitch = (Switch)findViewById(R.id.genderSwitch);
        ageTextFeild = (EditText)findViewById(R.id.age_editText);
        sendBtn = (Button)findViewById(R.id.send_btn);
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
    private void sendRegisterData(User user,Socket socket){

    }
}

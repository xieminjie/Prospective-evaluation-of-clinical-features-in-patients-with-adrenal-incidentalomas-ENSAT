package com.example.xieminjie.clientapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class Register extends AppCompatActivity {
    private Socket socket;
    private int age;
    private String sex;
    private String diagnosis;
    private Switch genderSwitch;
    private Toolbar toolbar;
    private EditText ageTextFeild;
    private EditText diagnosisTextFeild;
    private Button sendBtn;
    private User user;
    public static final String TAG="myActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initInterface();
        ChatApplication app = (ChatApplication)this.getApplication();
        socket = app.getSocket();
        socket.on("register reply",storeReply);
        socket.connect();
        genderSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    genderSwitch.setText("Female");
                    sex = "Female";

                } else {
                    genderSwitch.setText("Male");
                    sex = "Male";
                }
            }
        });
        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                age = Integer.parseInt(ageTextFeild.getText().toString());
                diagnosis = diagnosisTextFeild.getText().toString();
                user = new User(sex,age,diagnosis);
                Gson gson = new Gson();
                String msg = gson.toJson(user);
                sendRegisterData(msg, socket);
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
        diagnosisTextFeild = (EditText)findViewById(R.id.diagnosis_editText);
        sendBtn = (Button)findViewById(R.id.send_btn);
    }
    private void startToMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private Emitter.Listener storeReply = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject) args[0];
                    try {
                        String result = data.getString("result");
                        if(result.equals("stored")){
                           startToMain();
                        }
                    } catch (JSONException e) {
                        return;
                    }
                }
            });
        }
    };

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
    private void sendRegisterData(String msg,Socket socket){
        socket.emit("send Register Data",msg);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        socket.off("login", storeReply);
    }

}

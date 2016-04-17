package com.example.xieminjie.clientapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class MainActivity extends AppCompatActivity {
    private Socket socket;
    private EditText loginTextField;
    private Button loginBtn;
    private String userid;
    public static final String TAG="myActivity";
    private  ClientApplication app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInterface();
        IOStorageHandler.readRecordLog("record.csv",getApplicationContext());
    }
    @Override
    protected void onStart() {
        super.onStart();

        app = (ClientApplication)getApplication();
        socket = app.getSocket();
        socket.on("login reply", loginReply);
        socket.connect();
    }

    private void initInterface(){
        loginTextField = (EditText)findViewById(R.id.main_loginTextField);
        loginBtn = (Button)findViewById(R.id.main_loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userid = loginTextField.getText().toString();
                socket.emit("send login request", userid);
            }
        });
    }
    private Emitter.Listener loginReply = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject) args[0];
                    try {
                        String result = data.getString("userNum");
                        if (result.equals("1")) {
                            IOStorageHandler.printUserID("user",userid,getApplicationContext());
                            startToLogin();
                        } else {
                            loginTextField.setText("");
                            userid = "";
                            app.getToast("Userid is wrong");
                        }
                    } catch (JSONException e) {
                        return;
                    }
                }
            });
        }
    };
    private void startToLogin(){
        Intent intent = new Intent(this, TabbedDrawer.class);
        startActivity(intent);
    }
}

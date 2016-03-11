package com.example.xieminjie.clientapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import io.socket.client.Socket;

public class MainActivity extends AppCompatActivity {
    private Socket socket;
    private String userID;
    private EditText loginTextField;
    private Button loginBtn;
    private String userid;
    public static final String TAG="myActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ChatApplication app = (ChatApplication)getApplication();
        socket = app.getSocket();
        initInterface();
        socket.connect();
    }
    private void initInterface(){
        loginTextField = (EditText)findViewById(R.id.main_loginTextField);
        loginBtn = (Button)findViewById(R.id.main_loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userid = loginTextField.getText().toString();
                socket.emit("send login request",userid);
                //startToLogin();
            }
        });
    }
    private void startToLogin(){
        Intent intent = new Intent(this, TabbedDrawer.class);
        startActivity(intent);
    }
}

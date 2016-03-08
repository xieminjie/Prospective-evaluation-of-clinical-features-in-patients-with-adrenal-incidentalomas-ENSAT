package com.example.xieminjie.clientapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import io.socket.client.Socket;

public class MainActivity extends AppCompatActivity {
    private Socket socket;
    private String userID;
    private TextView registerTextBtn;
    public static final String TAG="myActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInterface();
    }
    private void initInterface(){
        registerTextBtn = (TextView)findViewById(R.id.register_button);
        registerTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startToRegister();
            }
        });
    }
    private void startToRegister(){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}

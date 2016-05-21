package com.example.xieminjie.clientapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    private EditText loginTextField;
    private Button loginBtn;
    private String userid;
    public static final String TAG="myActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInterface();
    }
    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
    private void initInterface(){
        loginTextField = (EditText)findViewById(R.id.main_loginTextField);
        loginBtn = (Button)findViewById(R.id.main_loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userid = loginTextField.getText().toString();
                NetworkHandler myTask = new NetworkHandler();
                RequestPackage requestPackage = new RequestPackage();
                requestPackage.setMethod("GET");
                requestPackage.setUri(Params.CHAT_SERVER_URL + "/login");
                requestPackage.setParam("login",userid);
                myTask.execute(requestPackage);
            }
        });
    }
    private void startToLogin(){
        Intent intent = new Intent(this, TabbedDrawer.class);
        startActivity(intent);
    }
    private class NetworkHandler extends AsyncTask<RequestPackage,String,String> {
        //has access to Main thread
        @Override
        protected void onPreExecute(){
            //do before task doing in background
        }
        @Override
        protected String doInBackground(RequestPackage... strings) {
            String data = HttpManager.getData(strings[0]);
            return data;
        }
        @Override
        protected void onPostExecute(String result){
            if(result==null){
                Log.d("myData", "null");
            }else{
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(result);
                    String ifAuthen = jsonObject.get("Authentication").toString();
                    if (ifAuthen.equals("true")) {
                        IOStorageHandler.printUserID("user",userid,getApplicationContext());
                        startToLogin();
                    } else {
                        loginTextField.setText("");
                        userid = "";
                        getToast("Userid is wrong");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void getToast(String message){
        Context context = getApplicationContext();
        CharSequence text = message;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}

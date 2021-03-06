package com.example.xieminjie.clientapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.google.gson.Gson;
import io.socket.emitter.Emitter;

public class OverallData extends AppCompatActivity {
    private Toolbar toolbar;
    private Gson gson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overall_data);
        toolbar = (Toolbar)findViewById(R.id.navbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);
    }
    @Override
    protected void onStart(){
        super.onStart();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
    private Emitter.Listener dataReply = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    gson = new Gson();
                    OveralDataClass data = gson.fromJson(args[0].toString(),OveralDataClass.class);
                    System.out.println(data.getBack_pain());

                }
            });
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_overall_data, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id==android.R.id.home){
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}

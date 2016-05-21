package com.example.xieminjie.clientapp;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by xieminjie on 20/05/2016.
 */
public class HttpManager {
    public static String getData(RequestPackage p){
        BufferedReader reader = null;
        String uri = p.getUri();
        if(p.getMethod().equals("GET")){
            uri += "?"+p.getEncodedParams();
        }
        try {
            URL url = new URL(uri);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(p.getMethod());

            if(p.getMethod().equals("POST")){
                con.setDoOutput(true);//allow output some content on body request
                OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
                Log.d("myData", p.getJsonData());
                JSONObject jsonObject = new JSONObject(p.getJsonData());
                writer.write(jsonObject.toString());
                writer.flush();
            }

            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while((line = reader.readLine())!=null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("myData",e.toString());
            return null;
        } finally {
            if(reader!=null){
                try{
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                    Log.d("myData", e.toString());
                    return null;
                }
            }
        }
    }
}

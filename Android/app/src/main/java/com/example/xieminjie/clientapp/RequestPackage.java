package com.example.xieminjie.clientapp;

import android.util.Log;

import com.github.nkzawa.utf8.UTF8;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xieminjie on 20/05/2016.
 */
public class RequestPackage {
    private String uri;
    private String method = "GET";
    private Map<String,String> params = new HashMap<>();
    private String jsonData;

    public void setParam(String key, String value){
        params.put(key,value);
    }


    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getEncodedParams(){
        StringBuilder sb = new StringBuilder();
        String value = null;
        for(String key:params.keySet()){
            try {
                value = URLEncoder.encode(params.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if(sb.length()>0){
                sb.append("&");
            }
            sb.append(key+"="+ value);
        }
        return sb.toString();
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}

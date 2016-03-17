package com.example.xieminjie.clientapp;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by xieminjie on 17/03/2016.
 */
public class QuestionAdapter extends ArrayAdapter<Question> {
    public QuestionAdapter(Context context, ArrayList<Question> arrayList) {
        super(context, 0, arrayList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Question question = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.question_cell, parent, false);
        }
        TextView questionName = (TextView) convertView.findViewById(R.id.question_name);
        Log.d("myActivity", question.displayname);
        questionName.setText(question.displayname);
        questionName.setTextColor(Color.BLACK);
        return convertView;
    }
}

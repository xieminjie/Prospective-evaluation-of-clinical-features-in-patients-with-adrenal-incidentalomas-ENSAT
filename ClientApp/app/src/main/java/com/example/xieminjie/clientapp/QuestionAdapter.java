package com.example.xieminjie.clientapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by xieminjie on 17/03/2016.
 */
public class QuestionAdapter extends ArrayAdapter<Question> {
    private final Context context;
    private final ArrayList<Question> arrayList;

    public QuestionAdapter(Context context, ArrayList<Question> arrayList) {
        super(context, 0, arrayList);
        this.context = context;
        this.arrayList = arrayList;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.question_cell,parent,false);
        TextView questionTextView = (TextView)convertView.findViewById(R.id.question_name);
        questionTextView.setText(arrayList.get(position).getDisplayname());
        return convertView;
    }
}

package com.example.xieminjie.clientapp;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by xieminjie on 17/03/2016.
 */
public class QuestionAdapter extends ArrayAdapter<Question> {
    public QuestionAdapter(Context context, ArrayList<Question> arrayList) {
        super(context, 0, arrayList);
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Question question = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.question_cell, parent, false);
        }
        TextView questionName = (TextView) convertView.findViewById(R.id.question_name);
        questionName.setText(question.getName());
        SeekBar seekBar = (SeekBar)convertView.findViewById(R.id.question_seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                question.setMark(progress);

            }
        });
        return convertView;
    }
}

package com.example.xieminjie.clientapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class SurveyFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    private boolean ifSurvey;
    private boolean ifProblem;
    private LinearLayout linearLayout;
    private LinearLayout myll;
    boolean ifDone;
    private ArrayList<Record> arrayList;
    private IOStorageHandler ioStorageHandler;
    private DateHandler dateHandler;

    // TODO: Rename and change types and number of parameters
    public static SurveyFragment newInstance(String param1, String param2) {
        SurveyFragment fragment = new SurveyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public SurveyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        arrayList = ioStorageHandler.readRecordLog("record.csv",getContext());
        String lastData = arrayList.get(arrayList.size()-1).getRecord_date();
        if (lastData.equals(dateHandler.getCurrentData().toString())){
            ifDone = true;
        }else{
            ifDone = false;
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_survey, container, false);
        linearLayout = (LinearLayout)view.findViewById(R.id.survey_fragment_linearLayout);
        if(ifDone){
            myll = creaateall(getActivity());
        }else {
            myll = createMyll(getActivity());
        }
        linearLayout.addView(myll);
        return view;
    }
    // UI for haven't do survey today
    private LinearLayout createMyll(Activity activity){
        LinearLayout ll = createll(activity);
        Button pBtn = createProblemBtn(activity);
        pBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startToSurveyDetail();
            }
        });
        Button npBtn = createnoProblemBtn(activity);
        ll.addView(pBtn);
        ll.addView(npBtn);
        return ll;
    }
    // UI for have done survey today

    private LinearLayout creaateall(Activity activity){
        LinearLayout ll = createll(activity);
        TextView textView = createText(activity);
        ll.addView(textView);
        return ll;
    }
    private void startToSurveyDetail(){
        Intent intent = new Intent(getActivity(), SurveyDetails.class);
        startActivity(intent);
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }
    // check ifproblem UI
    public LinearLayout createll(Activity activity){
        LinearLayout surveyLayout = new LinearLayout(activity);
        surveyLayout.setOrientation(LinearLayout.VERTICAL);
        surveyLayout.setPadding(0, 0, 0, 0);
        return surveyLayout;
    }
    public TextView createText (Activity activity){
        TextView textView = new TextView(activity);
        textView.setText("You have already finished the survey today");
        return textView;
    }
    public Button createProblemBtn (Activity activity){
        Button problemBtn = new Button(activity);
        problemBtn.setText("Yes");
        return problemBtn;
    }
    public Button createnoProblemBtn (Activity activity){
        Button noproblemBtn = new Button(activity);
        noproblemBtn.setText("No");
        return noproblemBtn;
    }

}

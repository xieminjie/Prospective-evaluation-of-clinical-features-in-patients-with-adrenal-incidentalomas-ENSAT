package com.example.xieminjie.clientapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class RecordFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private LinearLayout linearLayout;
    private LinearLayout myll;
    private IOStorageHandler ioStorageHandler;
    public static RecordFragment newInstance(String param1, String param2) {
        RecordFragment fragment = new RecordFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public RecordFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_record, container, false);
        linearLayout = (LinearLayout)view.findViewById(R.id.report_fragment_linearLayout);
        myll = createMyll(getActivity());
        linearLayout.addView(myll);
        return view;
    }
    private LinearLayout createMyll(Activity activity){
        LinearLayout ll = createll(activity);
        final EditText editText = createText(activity);
        final TextView textView = createaText(activity);
        Button button = createButton(activity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startToShow(editText.getText().toString());
            }
        });
        ll.addView(textView);
        ll.addView(editText);
        ll.addView(button);
        return ll;
    }
    private void startToShow(String msg){
        Intent intent = new Intent(getActivity(), RecordDetail.class);
        intent.putExtra("searchName", msg);
        startActivity(intent);
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public LinearLayout createll(Activity activity){
        LinearLayout surveyLayout = new LinearLayout(activity);
        surveyLayout.setOrientation(LinearLayout.VERTICAL);
        surveyLayout.setPadding(0, 0, 0, 0);
        return surveyLayout;
    }
    public EditText createText (Activity activity){
        EditText textView = new EditText(activity);
        return textView;
    }
    public TextView createaText (Activity activity){
        TextView textView = new TextView(activity);
        textView.setText("Please enter the item");
        textView.setPadding(0,450,0,0);
        return textView;
    }
    public Button createButton (Activity activity){
        Button problemBtn = new Button(activity);
        problemBtn.setText("Confirm");
        return problemBtn;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}

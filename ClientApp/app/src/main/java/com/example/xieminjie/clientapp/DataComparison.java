package com.example.xieminjie.clientapp;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DataComparison.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DataComparison#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DataComparison extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    // UI elements
    private LinearLayout linearLayout;
    private LinearLayout myll;

    private ClientApplication app;
    private Socket socket;
    private Gson gson;
    private CompareObject obj;
    private TextView compareTextView;


    public static DataComparison newInstance(String param1, String param2) {
        DataComparison fragment = new DataComparison();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public DataComparison() {
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
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_data_comparison, container, false);
        linearLayout = (LinearLayout)view.findViewById(R.id.data_comparison_linearlayout);
        myll = createMyll(getActivity());
        linearLayout.addView(myll);
        return view;
    }

    private LinearLayout createMyll(Activity activity){
        LinearLayout ll = createll(activity);
      /*  Button averageDataBtn = createButton(activity,"Average Data");
        averageDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startToShowOveralData();
            }
        });*/
        final EditText comparisonEditInput = createEditText(getActivity());
        Button singleComparisonBtn = createButton(activity, "Single Comparison");
        singleComparisonBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String query = comparisonEditInput.getText().toString();

                startToShowComparisonData(query);
            }
        });
        compareTextView =  createTextView(getActivity());
      //  ll.addView(averageDataBtn);
        ll.addView(comparisonEditInput);
        ll.addView(singleComparisonBtn);
        ll.addView(compareTextView);
        return ll;
    }
    public LinearLayout createll(Activity activity){
        LinearLayout surveyLayout = new LinearLayout(activity);
        surveyLayout.setOrientation(LinearLayout.VERTICAL);
        surveyLayout.setPadding(0, 0, 0, 0);
        return surveyLayout;
    }
    public Button createButton (Activity activity,String text){
        Button button = new Button(activity);
        button.setText(text);
        return button;
    }
    public EditText createEditText(Activity activity){
        EditText editText = new EditText(activity);
        return editText;
    }
    public TextView createTextView(Activity activity){
        compareTextView= new TextView(activity);
        return compareTextView;
    }
    private void startToShowOveralData(){
        Intent intent = new Intent(getActivity(), OverallData.class);
        startActivity(intent);
    }
    private void startToShowComparisonData(String query){
        app = (ClientApplication)getActivity().getApplication();
        socket = app.getSocket();
        socket.connect();
        socket.emit("single data request", query);
        socket.on("reply single data", getOveralData);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        socket.disconnect();
    }
    private Emitter.Listener getOveralData = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
           getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String msg = args[0].toString();
                    if(msg.equals("null")){
                        //alert
                    }else{
                        compareTextView.setText("Average: "+msg);

                    }
                }
            });
        }
    };
    private void intentTodata(String str){
        Intent intent = new Intent(getActivity(),SingleComparison.class);
        intent.putExtra("searchComparisonName",str);
        startActivity(intent);
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}

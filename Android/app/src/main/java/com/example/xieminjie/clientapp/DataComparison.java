package com.example.xieminjie.clientapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
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
        final EditText comparisonEditInput = createEditText(getActivity());
        final TextView textView = createaText(getActivity());
        Button singleComparisonBtn = createButton(activity, "Single Comparison");
        singleComparisonBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String query = comparisonEditInput.getText().toString();

                startToShowComparisonData(query);
            }
        });
        compareTextView =  createTextView(getActivity());
        ll.addView(textView);
        ll.addView(comparisonEditInput);
        ll.addView(singleComparisonBtn);
        ll.addView(compareTextView);
        return ll;
    }
    public TextView createaText (Activity activity){
        TextView textView = new TextView(activity);
        textView.setText("Please enter the item");
        textView.setPadding(0, 450, 0, 0);
        return textView;
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
        NetworkHandler myTask = new NetworkHandler();
        RequestPackage requestPackage = new RequestPackage();
        requestPackage.setMethod("GET");
        requestPackage.setUri(Params.CHAT_SERVER_URL + "/comparison");
        requestPackage.setParam("query", query);
        myTask.execute(requestPackage);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
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
                    compareTextView.setText("Average: " + jsonObject.get("comparisonResult").toString());
                    compareTextView.setTextSize(18);
                    compareTextView.setPadding(400,300,0,0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

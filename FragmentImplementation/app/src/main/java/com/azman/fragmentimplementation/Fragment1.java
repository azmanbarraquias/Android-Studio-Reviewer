package com.azman.fragmentimplementation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Fragment1 extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_1, container, false);

        Button button = view.findViewById(R.id.sendData1btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText = view.findViewById(R.id.fragment1Data);
                Bundle result = new Bundle();
                result.putString("df1",editText.getText().toString());
                getParentFragmentManager().setFragmentResult("dataFrom1",result);
                editText.setText("");
            }
        });

        return view;
    }
}
package com.azman.sundaypractice.fragmenttest;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.azman.sundaypractice.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class fragment3 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment3, container, false);
        Toast.makeText(getActivity(), "OnCreateView was Called", Toast.LENGTH_SHORT).show();

        return view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(getActivity(), "OnCreate was Called", Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Toast.makeText(getActivity(), "OnActivityView was Called", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Toast.makeText(getActivity(), "OnAttach was Called", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toast.makeText(getActivity(), "OnViewCreated was Called", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onStart() {
        super.onStart();

        Toast.makeText(getActivity(), "OnStart was Called", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResume() {
        super.onResume();

        Toast.makeText(getActivity(), "OnResume was Called", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Toast.makeText(getActivity(), "onSaveInstanceState Called", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPause() {
        super.onPause();

        Toast.makeText(getActivity(), "OnPause was Called", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onStop() {
        super.onStop();

        Toast.makeText(getActivity(), "OnStop was Called", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Toast.makeText(getActivity(), "OnDestroyView was Called", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(getActivity(), "OnDestroy was Called", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDetach() {
        super.onDetach();

        Toast.makeText(getActivity(), "OnDetach was Called", Toast.LENGTH_SHORT).show();

    }
}
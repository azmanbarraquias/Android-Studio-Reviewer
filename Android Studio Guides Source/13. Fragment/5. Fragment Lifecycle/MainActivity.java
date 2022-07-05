import android.content.Context;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class FragmentOne extends Fragment {


    // YOU CAN EASILY CREATE OVERRIDE METHOD BY --> " CTRL + O "

    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(getActivity(), "OnCreate was Called", Toast.LENGTH_SHORT).show();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_one, container, false);

        Toast.makeText(getActivity(), "OnCreateView was Called", Toast.LENGTH_SHORT).show();

        TextView textView = view.findViewById(R.id.TextView);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        return  view;
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

        Toast.makeText(getActivity(), "OnActivityView was Called", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAttach( Context context) {
        super.onAttach(context);

        Toast.makeText(getActivity(), "OnAttach was Called", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onViewCreated( View view,  Bundle savedInstanceState) {
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
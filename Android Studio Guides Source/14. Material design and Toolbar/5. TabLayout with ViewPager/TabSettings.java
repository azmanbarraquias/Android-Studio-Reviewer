import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class TabSetting extends Fragment {

    public TabSetting() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.tab_setting, container, false);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "This is Setting ", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
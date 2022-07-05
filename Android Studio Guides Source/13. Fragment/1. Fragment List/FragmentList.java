import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class FragmentList extends Fragment {

    private ListView mListView;
    private ArrayAdapter<String> mAdapter;


    public FragmentList() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        Listview listView = view.findViewById(R.id.listView);

        final String[] texts = {"Java", "Kotlin ", "Python", "Javascript",
                "C#", "C/C++", "Swift", "PHP",
                "Objective-C", "Ruby",
                "Html", "CSS", "SQL"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, texts);
        lstView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        Toast.makeText(getActivity(), "Java", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getActivity(), "Kotlin", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getActivity(), "Python", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getActivity(), "JavaScript", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getActivity(), "C#", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(getActivity(), "C/C++", Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(getActivity(), "Swift", Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        Toast.makeText(getActivity(), "PHP", Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        Toast.makeText(getActivity(), "Objective-C", Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        Toast.makeText(getActivity(), "Ruby", Toast.LENGTH_SHORT).show();
                        break;
                    case 10:
                        Toast.makeText(getActivity(), "Html", Toast.LENGTH_SHORT).show();
                        break;
                    case 11:
                        Toast.makeText(getActivity(), "CSS", Toast.LENGTH_SHORT).show();
                        break;
                    case 12:
                        Toast.makeText(getActivity(), "SQL", Toast.LENGTH_SHORT).show();

                        /*
                         * OR
                         *
                         * YOU CAN TRY THIS
                         *
                         * Toast.makeText(getActivity(),text[position], Toast.LENGTH_SHORT).show();
                         *
                         * */


                }
            }
        });

        return view;
    }
}
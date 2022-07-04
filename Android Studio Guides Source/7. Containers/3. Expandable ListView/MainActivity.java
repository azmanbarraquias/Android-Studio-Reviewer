import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    HashMap<String, List<String>> listChild;
    List<String> listHeader;
    ListAdapter listAdapter;

    private ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.expandable_listview);

        listData(); // call method

        listAdapter = new ListAdapter(this, ListChild, ListHeader);

        // setting list adapter
        expandableListView.setAdapter(listAdapter);

        // ListView Child Click listener
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Toast.makeText(getApplicationContext(), ListHeader.get(groupPosition) + " : " + ListChild.get(ListHeader.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT).show();


                return false;
            }
        });

        // ListView Group Click listener
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                Toast.makeText(getApplicationContext(), listHeader.get(groupPosition), Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        // ListView Group Expand listener
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

                Toast.makeText(getApplicationContext(), listHeader.get(groupPosition) + " Expanded", Toast.LENGTH_SHORT).show();


            }
        });

        //List Group collapsed listener
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {

                Toast.makeText(getApplicationContext(), listHeader.get(groupPosition) + " Collapsed", Toast.LENGTH_SHORT).show();

            }
        });
    }


    private void listData() {

        listHeader = new ArrayList<String>();
        listChild = new HashMap<String, List<String>>();

        listHeader.add("Header 1");
        listHeader.add("Header 2");
        listHeader.add("Header 3");


        // Adding child data
        List<String> header1 = new ArrayList<String>();
        header1.add("Child 1-1");
        header1.add("Child 1-2");
        header1.add("Child 1-3");
        header1.add("Child 1-4");
        header1.add("Child 1-5");


        List<String> header2 = new ArrayList<String>();
        header2.add("Child 2-1");
        header2.add("Child 2-2");
        header2.add("Child 2-3");
        header2.add("Child 2-4");
        header2.add("Child 2-5");

        List<String> header3 = new ArrayList<String>();
        header3.add("Child 3-1");
        header3.add("Child 3-2");
        header3.add("Child 3-3");
        header3.add("Child 3-4");
        header3.add("Child 3-5");

        listChild.put(listHeader.get(0), header1);
        listChild.put(listHeader.get(1), header2);
        listChild.put(listHeader.get(2), header3);


    }

    class ListAdapter extends BaseExpandableListAdapter {

        private final Context context;
        private final HashMap<String, List<String>> listChild;
        private final List<String> listHeader;

        public ListAdapter(Context context, HashMap<String, List<String>> listChild, List<String> listHeader) {
            this.context = context;
            this.listChild = listChild;
            this.listHeader = listHeader;
        }

        @Override
        public int getGroupCount() {
            return listHeader.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return listChild.get(listHeader.get(groupPosition)).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return listHeader.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return listChild.get(listHeader.get(groupPosition)).get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

            String headerTitle = (String) getGroup(groupPosition);

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                convertView = inflater.inflate(R.layout.list_group, null);

            }

            TextView textView = convertView.findViewById(R.id.list_header);
            textView.setText(headerTitle);

            return convertView;

        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

            String childTitle = (String) getChild(groupPosition, childPosition);

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                convertView = inflater.inflate(R.layout.list_items, null);

            }

            TextView textView = convertView.findViewById(R.id.list_child);
            textView.setText(childTitle);

            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }

}  
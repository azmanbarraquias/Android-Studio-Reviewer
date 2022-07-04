import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int[] images = {R.drawable.image_one, R.drawable.image_two, R.drawable.image_three,
            R.drawable.image_four, R.drawable.image_five, R.drawable.image_six};

    String[] texts = {"List Item 1", "List Item 2", "List Item 3", "List Item 4", "List Item 5", "List Item 6"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.grid_View);

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), images, texts);

        // set Adapter to GridView
        gridView.setAdapter(customAdapter);

    }

    class CustomAdapter extends BaseAdapter {

        Context context;
        int[] images;
        String[] texts;
        LayoutInflater inflater;

        public CustomAdapter(Context context, int[] images, String[] texts) {
            this.context = context;
            this.images = images;
            this.texts = texts;
            inflater = (LayoutInflater.from(getApplicationContext()));
        }


        @Override
        public int getCount() {
            return texts.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View view, ViewGroup parent) {
            view = inflater.inflate(R.layout.custom_grid, null);

            ImageView imageView = view.findViewById(R.id.image);
            TextView textView = view.findViewById(R.id.text_view);

            imageView.setImageResource(images[position]);

            textView.setText(texts[position]);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    switch (position) {
                        case 0:
                            Toast.makeText(getApplicationContext(), "Item One", Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            Toast.makeText(getApplicationContext(), "Item two", Toast.LENGTH_SHORT).show();
                            break;
                        case 2:
                            Toast.makeText(getApplicationContext(), "Item Three", Toast.LENGTH_SHORT).show();
                            break;
                        case 3:
                            Toast.makeText(getApplicationContext(), "Item Four", Toast.LENGTH_SHORT).show();
                            break;
                        case 4:
                            Toast.makeText(getApplicationContext(), "Item Five", Toast.LENGTH_SHORT).show();
                            break;
                        case 5:
                            Toast.makeText(getApplicationContext(), "Item Six", Toast.LENGTH_SHORT).show();


                            /* Tip :-
                             *
                             * If you need to use Intent Try this code.
                             *
                             * Intent intent = new Intent(context,Example.class);
                             * context.startActivity(intent);
                             * */
                    }
                }
            });

            return view;
        }
    }
}
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int[] images = { R.drawable.image_one, R.drawable.image_two, R.drawable.image_three,
            R.drawable.image_four, R.drawable.image_five };

    String[] texts = { "This is First Image", "This is Second Image",
            "This is Third Image", "This is Fourth Image",
            "This is Fifth Image" };

    private AdapterViewFlipper mAdapterViewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapterViewFlipper = findViewById(R.id.adapterViewFlipper);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), images, texts);
        mAdapterViewFlipper.setAdapter(customAdapter);

        // flip interval in milliseconds | 3000ms = 3s
        mAdapterViewFlipper.setFlipInterval(3000);
        mAdapterViewFlipper.setAutoStart(true);

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
        public View getView(int position, View view, ViewGroup parent) {
            view = inflater.inflate(R.layout.adapter_layout, null);

            ImageView imageView = view.findViewById(R.id.imageView);
            TextView textView = view.findViewById(R.id.textView);

            imageView.setImageResource(images[position]);

            textView.setText(texts[position]);

            return view;
        }
    }

}
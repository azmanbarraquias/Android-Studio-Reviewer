package com.azman.customlistview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListItem extends BaseAdapter {
    Context context;
    ListItem[] listItems;
    LayoutInflater inflater;

    public CustomListItem(Context ctx, ListItem[] listItems) {
        this.context = ctx;
        this.listItems = listItems;
        this.inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return listItems.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_custom_list_view, null);
        TextView textView = view.findViewById(R.id.itemName);
        ImageView imageView = view.findViewById(R.id.imageIcon);
        textView.setText(listItems[i].name);
        imageView.setImageResource(listItems[i].iconId);

        return view;
    }
}

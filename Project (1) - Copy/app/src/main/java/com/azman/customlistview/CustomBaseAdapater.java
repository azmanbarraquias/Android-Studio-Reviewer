package com.azman.customlistview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapater extends BaseAdapter
{
    Context context;
    String[] listIName;
    int[] listIcons;
    LayoutInflater inflater;

    public CustomBaseAdapater(Context ctx, String[] listItems, int[] listIcons){
    this.context = ctx;
    this.listIName = listItems;
    this.listIcons = listIcons;
    this.inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return listIName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_custom_list_view, null);
        TextView textView = (TextView) view.findViewById(R.id.itemName);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageIcon);
        textView.setText(listIName[i]);
        imageView.setImageResource(listIcons[i]);
        return view;
    }
}

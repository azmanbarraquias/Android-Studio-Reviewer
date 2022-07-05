package com.azman.myandroidstudioguides;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// derive from ItemViewHolder
public class RecyclerAdapterManager extends RecyclerView.Adapter<RecyclerAdapterManager.ItemViewHolder> {
    private ArrayList<Item> items;
    private Context context; // to toast object item of context

    public RecyclerAdapterManager(ArrayList<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // onCreateViewHolder called when view holder class we created below has been created while the media gets called.
        // in this method we define the card design that we made, so thanks to this method

        // to link to a design that we created from view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_design, parent, false);

        // now finally because this method will return an object from the item view holder class we return it.
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // onBindViewHolder this method is also a method in which we will specify
        // what should be done when the design is created and then connected to recycler view.

        Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.slide_in_left);
        holder.itemView.startAnimation(animation);

        // transfer the data in array to the components.
        holder.textTitle.setText(items.get(position).title);
        holder.textDetail.setText(items.get(position).detail);
        holder.imageView.setImageResource(items.get(position).image);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, items.get(position).title, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        // This is the method where we specify the amount of data to be display in recycler view.
        return items.size();
    }

    // Inner class, Purpose: Will represent the item design and we will define the components
    //
    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView textTitle;
        private TextView textDetail;
        private ImageView imageView;
        private CardView cardView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textTitle = itemView.findViewById(R.id.textTitle);
            this.textDetail = itemView.findViewById(R.id.textDetail);
            this.imageView = itemView.findViewById(R.id.profile_image);
            this.cardView = itemView.findViewById(R.id.cardViewID);
        }
    }
}

class Item {
    String title;
    String detail;
    Integer image;

    public Item(String title, String detail, Integer image) {
        this.title = title;
        this.detail = detail;
        this.image = image;
    }
}

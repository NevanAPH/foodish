package com.nevanpplg2.foodish;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Dictionary;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private final List<FoodItem> foods;
    private Context context;

    public FoodAdapter(Context context, List<FoodItem> foods) {
        this.context = context;
        this.foods = foods;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.food_item, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
        FoodItem food = foods.get(position);
        holder.view.setOnClickListener(food.getClickListener());
        holder.name.setText(food.getName());
        holder.description.setText(food.getDescription());
        holder.image.setImageResource(food.getImage());
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView description;
        public ImageView image;
        public View view;

        public FoodViewHolder(View v) {
            super(v);
            this.view = v;

            this.name = v.findViewById(R.id.foodName);
            this.description = v.findViewById(R.id.foodDescription);
            this.image = v.findViewById(R.id.foodImage);
        }
    }
}

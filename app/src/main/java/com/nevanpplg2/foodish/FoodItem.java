package com.nevanpplg2.foodish;

import android.view.View;

public class FoodItem {
    private String name;
    private String description;
    private int image;

    private View.OnClickListener clickListener;

    public FoodItem(String name, String description, int image, View.OnClickListener clickListener) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.clickListener = clickListener;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public View.OnClickListener getClickListener() {
        return clickListener;
    }

    public void setClickListener(View.OnClickListener clickListener) {
        this.clickListener = clickListener;
    }
}

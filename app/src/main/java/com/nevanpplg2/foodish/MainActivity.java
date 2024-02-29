package com.nevanpplg2.foodish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView songsScrollView;
    List<FoodItem> foods = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTransparentBar();

        songsScrollView = findViewById(R.id.foodScrollView);
        this.loadFoods();

        FoodAdapter foodAdapter = new FoodAdapter(this, foods);
        songsScrollView.setAdapter(foodAdapter);
        songsScrollView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    public void foodClick(View view, String name, String description, int image) {
        Snackbar.make(
                view,
                String.format("You clicked food: %s!", name),
                Snackbar.LENGTH_LONG
        ).show();
    }

    private void addFood(String name, String description, int image) {
        foods.add(
                new FoodItem(
                        name, description, image,
                        v -> foodClick(v, name, description, image)
                )
        );
    }

    private void loadFoods() {
        addFood("Nasi Goreng", "Nasi goreng", R.drawable.nasgor);
        addFood("Nasi Bakar", "Nasi bakar", R.drawable.nasi_bakar);
        addFood("Ayam Serundeng", "Ayam serundeng", R.drawable.ayam_serundeng);
        addFood("Ayam Geprek", "Ayam geprek", R.drawable.ayam_geprek);
        addFood("Bakso", "Bakso", R.drawable.bakso);
        addFood("Mie Ayam", "Mie ayam", R.drawable.mie_ayam);
        addFood("Bubur Ayam", "Bubur ayam", R.drawable.buryam);
        addFood("Soto Ayam", "Soto ayam", R.drawable.soto_ayam);
        addFood("Sate Ayam", "Sate ayam", R.drawable.sate_ayam);
    }

    private void setTransparentBar() {
        if (Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public static void setWindowFlag(MainActivity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}
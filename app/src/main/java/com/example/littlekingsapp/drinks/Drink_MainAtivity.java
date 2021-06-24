package com.example.littlekingsapp.drinks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.littlekingsapp.R;

import java.util.ArrayList;
import java.util.List;

public class Drink_MainAtivity extends AppCompatActivity {

    List<DrinkModel> modelList;
    RecyclerView recyclerView;
    DrinkOrderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drink_main_layout);

        //create an arraylist
        modelList = new ArrayList<>();
        modelList.add(new DrinkModel("Green Tea", getString(R.string.greentea), R.drawable.greentea ));
        modelList.add(new DrinkModel("Latte", getString(R.string.latte), R.drawable.late));
        modelList.add(new DrinkModel("Orange Smoothie", getString(R.string.orangesmoothie), R.drawable.orange));
        modelList.add(new DrinkModel("Orange Vanilla", getString(R.string.orangevanilla), R.drawable.orangevanilla));
        modelList.add(new DrinkModel("Cappucino", getString(R.string.cappuccino), R.drawable.cappcunio));
        modelList.add(new DrinkModel("Thai Tea", getString(R.string.thaitea), R.drawable.thaitea));
        modelList.add(new DrinkModel("Tea", getString(R.string.tea), R.drawable.tea));
        modelList.add(new DrinkModel("Bubble Tea", getString(R.string.bubbletea), R.drawable.milk));
        modelList.add(new DrinkModel("Matcha", getString(R.string.match), R.drawable.match));

        //recycleview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        //adapter
        mAdapter = new DrinkOrderAdapter(this, modelList);
        recyclerView.setAdapter(mAdapter);
    }
}
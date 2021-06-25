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
        modelList.add(new DrinkModel("Mocha Latte", getString(R.string.MochaLatte), R.drawable.mocha ));
        modelList.add(new DrinkModel("Latte", getString(R.string.latte), R.drawable.latte));
        modelList.add(new DrinkModel("Cappucino", getString(R.string.cappuccino), R.drawable.cappuccino));
        modelList.add(new DrinkModel("Chai Latte", getString(R.string.ChaiLatte), R.drawable.chailatte));


        //recycleview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        //adapter
        mAdapter = new DrinkOrderAdapter(this, modelList);
        recyclerView.setAdapter(mAdapter);
    }
}
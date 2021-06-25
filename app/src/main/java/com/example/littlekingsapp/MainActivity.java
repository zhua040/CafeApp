package com.example.littlekingsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.littlekingsapp.drinks.Drink_MainAtivity;
import com.example.littlekingsapp.foods.Food_MainActivity;

public class MainActivity extends AppCompatActivity {

    private CardView CardDrinks, CardFoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Casting CardView
        CardDrinks = (CardView) findViewById(R.id.card_Drinks);
        CardFoods = (CardView) findViewById(R.id.card_Foods);

        //Set on_clickingListener for each card
        CardDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Drink_MainAtivity.class);
                startActivity(intent);
            }
        });

        CardFoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Food_MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
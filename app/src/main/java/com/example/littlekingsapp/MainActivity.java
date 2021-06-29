package com.example.littlekingsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.littlekingsapp.Map.MapsActivity_Main;
import com.example.littlekingsapp.drinks.Drink_MainAtivity;
import com.example.littlekingsapp.foods.Food_MainActivity;
import com.example.littlekingsapp.login.Login_Mian;

public class MainActivity extends AppCompatActivity {

    private CardView CardDrinks, CardFoods, CardMap;

    String shortName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get intent userName
        Intent intent = getIntent();
        shortName = intent.getStringExtra("user_name");
        getSupportActionBar().setTitle("Hi! Nice to see you " + shortName);

        //Casting CardView
        CardDrinks = (CardView) findViewById(R.id.card_Drinks);
        CardFoods = (CardView) findViewById(R.id.card_Foods);
        CardMap = (CardView) findViewById(R.id.card_map);


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

        CardMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity_Main.class);
                startActivity(intent);
            }
        });


    }
}
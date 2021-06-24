package com.example.littlekingsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.littlekingsapp.drinks.Drink_MainAtivity;

public class MainActivity extends AppCompatActivity {

    private CardView CardDrinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Casting CardView
        CardDrinks = (CardView) findViewById(R.id.card_Drinks);

        //Set on_clickingListener for each card
        CardDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Drink_MainAtivity.class);
                startActivity(intent);
            }
        });

    }
}
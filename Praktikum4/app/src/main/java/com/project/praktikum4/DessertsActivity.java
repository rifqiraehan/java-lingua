package com.project.praktikum4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.Toast;

public class DessertsActivity extends AppCompatActivity {

    CardView browniesCard, donutsCard, croissantsCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desserts);

        browniesCard = findViewById(R.id.cv_brownies);
        donutsCard = findViewById(R.id.cv_donuts);
        croissantsCard = findViewById(R.id.cv_croissants);

        browniesCard.setOnClickListener(v -> {
            Toast.makeText(this, "Harga Chocolate Brownies: $7.99", Toast.LENGTH_SHORT).show();
        });

        donutsCard.setOnClickListener(v -> {
            Toast.makeText(this, "Harga Baked Vanilla Donuts: $4.99", Toast.LENGTH_SHORT).show();
        });

        croissantsCard.setOnClickListener(v -> {
            Toast.makeText(this, "Harga Butter Croissants: $5.99", Toast.LENGTH_SHORT).show();
        });
    }
}
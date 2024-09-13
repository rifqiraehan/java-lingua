package com.project.praktikum4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CardView startersCard, mainsCard, dessertsCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        startersCard = findViewById(R.id.card_view_starters);
        mainsCard = findViewById(R.id.card_view_mains);
        dessertsCard = findViewById(R.id.card_view_desserts);

        startersCard.setOnClickListener(v -> {
            Intent startersActivityIntent = new Intent(MainActivity.this, StartersActivity.class);
            startActivity(startersActivityIntent);
        });

        TextView locText = findViewById(R.id.text_view_loc);
        locText.setOnClickListener(v -> {
            Intent launcMapAppIntent = new Intent(Intent.ACTION_VIEW);
            launcMapAppIntent.setData(Uri.parse("geo:-27.125753986192816, -109.27694763830611?q=Ahu Tongariki"));
            startActivity(launcMapAppIntent);
        });

        TextView orderText = findViewById(R.id.text_view_order);
        orderText.setOnClickListener(v -> {
            Intent launcEmailAppIntent = new Intent(Intent.ACTION_SENDTO);
            launcEmailAppIntent.setData(Uri.parse("mailto:rifqiraehan86@gmail.com?subject=[ORDER] Menu Rekomendasi&body=Halo, Kak!\nSaya ingin memesan menu yang paling direkomendasikan tempat ini. Bisa nggak, Kak?"));
            startActivity(launcEmailAppIntent);
        });

        // Praktikum 5
        mainsCard.setOnClickListener(v -> {
            Intent mainCourseActivityIntent = new Intent(MainActivity.this, MainCourseActivity.class);
            startActivity(mainCourseActivityIntent);
        });

        dessertsCard.setOnClickListener(v -> {
            Intent dessertsActivityIntent = new Intent(MainActivity.this, DessertsActivity.class);
            startActivity(dessertsActivityIntent);
        });
    }
}
package com.project.praktikum4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class StartersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starters);

        ListView startersList = findViewById(R.id.list_view_starters);

        Dish[] dishes = {
                new Dish("Horseradish and cod gyoza", "Thin pastry cases stuffed with fresh horseradish and pacific cod.", 12),
                new Dish("Chilli and kiwi fruit dip", "A dip made from fresh chilli and kiwi fruit.", 21),
                new Dish("Egg and aubergine maki", "Toasted seaweed wrapped around sushi rice, filled with free range eggs and chargrilled aubergine.", 23),
                new Dish("Chickpea and cheese parcels", "Thin filo pastry cases stuffed with fresh chickpea and cheese.", 22),
                new Dish("Sweetcorn and egusi soup", "Creamed sweetcorn and egusi combined into smooth soup.", 13),
                new Dish("Stilton and pesto gyoza", "Thin pastry cases stuffed with stilton and sun-dried tomato pesto.", 32),
                new Dish("Chestnut and kidney casserole", "Roasted chestnut and kidney stewed.", 29),
                new Dish("Sesame and tofu sausages", "Tasty sausages made from sesame and smoked tofu, served in a roll.", 18),
                new Dish("Chickpea and pheasant stew", "Fresh chickpea and pheasant stewed.", 17),
                new Dish("Aubergine and feta dumplings", "Thin pastry cases stuffed with marinaded aubergine and tangy feta.", 19),
        };

        ArrayAdapter<Dish> dishAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dishes);
        startersList.setAdapter(dishAdapter);

        startersList.setOnItemClickListener((adapterView, v, i, l) -> {
            Dish ds = dishAdapter.getItem(i);
            Toast toast = Toast.makeText(getApplicationContext(), ds.getDesc(), Toast.LENGTH_SHORT);
            toast.show();
        });
    }
}
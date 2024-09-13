package com.project.praktikum4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainCourseActivity extends AppCompatActivity {

    CardView riceCard, saladCard, beefCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_course);

        riceCard = findViewById(R.id.cv_rice);
        saladCard = findViewById(R.id.cv_salad);
        beefCard = findViewById(R.id.cv_beef);

        riceCard.setOnClickListener(v -> sendEmail("[ORDER] Fried Rice", "Halo, Kak!\nSaya ingin memesan menu 'Fried Rice' seporsi. Untuk pengirimannya support sampai ke luar negeri nggak, Kak?"));
        saladCard.setOnClickListener(v -> sendEmail("[ORDER] Special Salad", "Pagi, Kak!\nSaya tertarik memesan menu 'Salad Special' ini. Untuk pembayarannya apakah bisa menggunakan mata uang crypto, Kak?"));
        beefCard.setOnClickListener(v -> sendEmail("[ORDER] Grilled Steak Beef", "Siang, Kak!\nHarga menu 'Grilled Steak Beef' seporsi berapa, Kak? Apakah akan mendapatkan diskon jika membeli untuk acara hajatan, Kak?"));
    }

    private void sendEmail(String subject, String body) {
        String uriText = "mailto:rifqiraehan86@gmail.com?subject=" + Uri.encode(subject) + "&body=" + Uri.encode(body);
        Uri uri = Uri.parse(uriText);
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, uri);
        startActivity(emailIntent);
    }
}
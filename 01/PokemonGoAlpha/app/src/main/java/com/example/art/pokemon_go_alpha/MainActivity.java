package com.example.art.pokemon_go_alpha;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView img1 = findViewById(R.id.img1);

        img1.setImageDrawable(getResources().getDrawable(R.drawable.pikachu));
    }
}

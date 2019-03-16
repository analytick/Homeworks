package com.example.art.pokemon_go_alpha;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ImageView img01, img02, img03, img04, img05, img06, img07, img08, img09, img10, img11, img12;
    ArrayList<ImageView> imgList;
    Button btnReplay;

    ArrayList<Integer> pokemonArray = new ArrayList<Integer>();

    int image101, image102, image103, image104, image105, image106,
            image201, image202, image203, image204, image205, image206, backSide;

    int firstImage = -1, secondImage = -1; // Айди изображений выбранных карт
    int clickedFirstCard = -1, clickedSecondCard = -1; // Теги выбранных карт

    final int delayTimeMs = 1500; // Время задержки после выбора второй карты

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img01 = findViewById(R.id.img01);
        img02 = findViewById(R.id.img02);
        img03 = findViewById(R.id.img03);
        img04 = findViewById(R.id.img04);
        img05 = findViewById(R.id.img05);
        img06 = findViewById(R.id.img06);
        img07 = findViewById(R.id.img07);
        img08 = findViewById(R.id.img08);
        img09 = findViewById(R.id.img09);
        img10 = findViewById(R.id.img10);
        img11 = findViewById(R.id.img11);
        img12 = findViewById(R.id.img12);

        imgList = new ArrayList<ImageView>();

        imgList.add(img01);
        imgList.add(img02);
        imgList.add(img03);
        imgList.add(img04);
        imgList.add(img05);
        imgList.add(img06);
        imgList.add(img07);
        imgList.add(img08);
        imgList.add(img09);
        imgList.add(img10);
        imgList.add(img11);
        imgList.add(img12);

        btnReplay = findViewById(R.id.btnReplay);

        int i = 0;
        for (ImageView img : imgList) {
            img.setTag(String.valueOf(i));
            i++;
        }

        for (ImageView img : imgList) {
            img.setOnClickListener(v -> {
                performAction(img);
            });
        }

        btnReplay.setOnClickListener(v -> {
            setFrontSide();
        });

        setFrontSide();
    }

    private void toggleAllImagesEnabled(Boolean enabled) {
        for (ImageView currentImg : imgList) {
            currentImg.setEnabled(enabled);
        }
    }

    private void resetAllVisibleImages() {
        for (ImageView currentImg : imgList) {
            if (currentImg.getVisibility() == View.VISIBLE) {
                currentImg.setImageResource(backSide);
            }
        }
    }

    private void resetAllImages() {
        for (ImageView currentImg : imgList) {
            currentImg.setImageResource(backSide);
        }
    }

    private void hideClickedCards() {
        imgList.get(clickedFirstCard).setVisibility(View.INVISIBLE);
        imgList.get(clickedSecondCard).setVisibility(View.INVISIBLE);
    }

    private void clearClickedCards() {
        clickedFirstCard = -1;
        clickedSecondCard = -1;
        firstImage = -1;
        secondImage = -1;
    }

    private void performAction(ImageView img) {
        toggleAllImagesEnabled(false);

        int pokemonIndex = Integer.parseInt(img.getTag().toString());
        int pokemonImageId = pokemonArray.get(pokemonIndex);

        img.setImageResource(pokemonImageId);

        if (clickedFirstCard > -1) { //Если выбрано второе изображение
            if (pokemonIndex == clickedFirstCard) {
                toggleAllImagesEnabled(true);
                return;
            }

            clickedSecondCard = pokemonIndex;
            secondImage = pokemonImageId;

            Handler handler = new Handler();

            handler.postDelayed(() -> {
                checkImage();
                toggleAllImagesEnabled(true);
                clearClickedCards();
            }, delayTimeMs);

        } else { // Если выбрано первое изображение
            clickedFirstCard = pokemonIndex;
            firstImage = pokemonImageId;

            toggleAllImagesEnabled(true);
        }
    }

    private void checkImage() {
        if (firstImage == secondImage) {
            hideClickedCards();
        } else {
            resetAllVisibleImages();
        }
        checkIfFinal();
    }

    private void checkIfFinal() {
        int i = 0;

        for (ImageView currentImg : imgList) {
            if (currentImg.getVisibility() == View.VISIBLE) {
                i++;
            }
        }

        if (i == 0) {
            Toast.makeText(getApplicationContext(), "Gotta catch 'em all!", Toast.LENGTH_LONG).show();
        }
    }

    private void setFrontSide() {
        image101 = R.drawable.ic_image101;
        image102 = R.drawable.ic_image102;
        image103 = R.drawable.ic_image103;
        image104 = R.drawable.ic_image104;
        image105 = R.drawable.ic_image105;
        image106 = R.drawable.ic_image106;
        image201 = R.drawable.ic_image101;
        image202 = R.drawable.ic_image102;
        image203 = R.drawable.ic_image103;
        image204 = R.drawable.ic_image104;
        image205 = R.drawable.ic_image105;
        image206 = R.drawable.ic_image106;
        backSide = R.drawable.ic_egg;

        pokemonArray.clear();

        pokemonArray.add(image101);
        pokemonArray.add(image102);
        pokemonArray.add(image103);
        pokemonArray.add(image104);
        pokemonArray.add(image105);
        pokemonArray.add(image106);
        pokemonArray.add(image201);
        pokemonArray.add(image202);
        pokemonArray.add(image203);
        pokemonArray.add(image204);
        pokemonArray.add(image205);
        pokemonArray.add(image206);

        Collections.shuffle(pokemonArray);

        for (ImageView img : imgList) {
            img.setVisibility(View.VISIBLE);
        }

        resetAllImages();

        clearClickedCards();

        toggleAllImagesEnabled(true);
    }
}

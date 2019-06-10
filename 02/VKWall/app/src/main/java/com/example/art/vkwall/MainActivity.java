package com.example.art.vkwall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView wallView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<WallItem> wallItemList = new ArrayList<WallItem>();
        wallItemList.add(new WallItem(R.drawable.ic_android, "User1", "Date1"));
        wallItemList.add(new WallItem(R.drawable.ic_android, "User2", "Date2"));
        wallItemList.add(new WallItem(R.drawable.ic_android, "User3", "Date3"));

        wallView = findViewById(R.id.vkView);
        wallView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerAdapter = new WallAdapter(wallItemList);

        wallView.setLayoutManager(layoutManager);
        wallView.setAdapter(recyclerAdapter);
    }
}

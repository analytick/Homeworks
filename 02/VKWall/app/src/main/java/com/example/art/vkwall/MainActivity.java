package com.example.art.vkwall;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView wallView;
    private RecyclerView.LayoutManager layoutManager;
    private WallAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<WallItem> wallItemList = new ArrayList<WallItem>();

        String jsonText = "";
        JSONArray postsArray;

        try {
            jsonText = readText(this, R.raw.vk_posts);

            postsArray = new JSONArray(jsonText);
            for (int i = 0; i < postsArray.length(); i++) {
                JSONObject currentPost = postsArray.getJSONObject(i);
                wallItemList.add(new WallItem(currentPost.getString("avatar_url"),
                        currentPost.getString("username"),
                        currentPost.getLong("post_date"),
                        currentPost.getString("post_text"),
                        currentPost.getString("post_image"))
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }



        //wallItemList.add(new WallItem(R.drawable.ic_android, "User1", "Date1"));
        //wallItemList.add(new WallItem(R.drawable.ic_android, "User2", "Date2"));
        //wallItemList.add(new WallItem(R.drawable.ic_android, "User3", "Date3"));

        wallView = findViewById(R.id.vkView);
        wallView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerAdapter = new WallAdapter(wallItemList);

        wallView.setLayoutManager(layoutManager);
        wallView.setAdapter(recyclerAdapter);

        recyclerAdapter.setOnItemClickListener(new WallAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                wallItemList.get(position).changeUserName("Clicked");
                recyclerAdapter.notifyItemChanged(position);
            }
        });
    }

    private static String readText(Context context, int resId) throws IOException {
        InputStream is = context.getResources().openRawResource(resId);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        StringBuilder sb= new StringBuilder();
        String s= null;
        while((  s = br.readLine())!=null) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }
}

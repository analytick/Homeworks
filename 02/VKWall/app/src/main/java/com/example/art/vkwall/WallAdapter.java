package com.example.art.vkwall;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WallAdapter extends RecyclerView.Adapter<WallAdapter.WallViewHolder> {
    public ArrayList<WallItem> wallItemList;

    public static class WallViewHolder extends RecyclerView.ViewHolder {
        public ImageView avatar;
        public TextView userName;
        public TextView date;

        public WallViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            userName = itemView.findViewById(R.id.userName);
            date = itemView.findViewById(R.id.date);
        }
    }

    @NonNull
    @Override
    public WallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.wall_item, parent, false);
        return new WallViewHolder(v);
    }

    public WallAdapter(ArrayList<WallItem> wallList) {
        wallItemList = wallList;
    }

    @Override
    public void onBindViewHolder(@NonNull WallViewHolder holder, int i) {
        WallItem currentItem = wallItemList.get(i);
        holder.avatar.setImageResource(currentItem.getAvatar());
        holder.userName.setText(currentItem.getUserName());
        holder.date.setText(currentItem.getDate());
    }

    @Override
    public int getItemCount() {
        return wallItemList.size();
    }
}

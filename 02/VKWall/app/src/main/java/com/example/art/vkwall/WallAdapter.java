package com.example.art.vkwall;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class WallAdapter extends RecyclerView.Adapter<WallAdapter.WallViewHolder> {
    public ArrayList<WallItem> wallItemList;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private OnItemClickListener clickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        clickListener = listener;
    };

    public static class WallViewHolder extends RecyclerView.ViewHolder {
        public ImageView avatar;
        public TextView userName;
        public TextView date;
        public TextView postText;
        public ImageView postImage;

        public WallViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            userName = itemView.findViewById(R.id.userName);
            date = itemView.findViewById(R.id.date);
            postText = itemView.findViewById(R.id.postText);
            postImage = itemView.findViewById(R.id.postImage);

            itemView.setOnClickListener( new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public WallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.wall_item, parent, false);
        return new WallViewHolder(v, clickListener);
    }

    public WallAdapter(ArrayList<WallItem> wallList) {
        wallItemList = wallList;
    }

    @Override
    public void onBindViewHolder(@NonNull WallViewHolder holder, int i) {
        WallItem currentItem = wallItemList.get(i);

        String postTextFinal = "";
        String postTextInitial = currentItem.getPostText();
        if (!postTextInitial.equalsIgnoreCase("null")) {
            postTextFinal = postTextInitial;
        }

        Picasso.get().load(currentItem.getAvatarUrl()).into(holder.avatar);
        holder.userName.setText(currentItem.getUserName());
        holder.date.setText(DateFormat.format("EEE, dd MMM yyyy в HH:mm", currentItem.getDate()*1000).toString());
        holder.postText.setText(postTextFinal);
        Picasso.get().load(currentItem.getPostImageUrl()).into(holder.postImage);
    }

    @Override
    public int getItemCount() {
        return wallItemList.size();
    }
}

package com.example.art.vkwall;

public class WallItem {
    private int avatar;
    private String userName;
    private String date;

    public WallItem(int avatar, String userName, String date){
        this.avatar = avatar;
        this.userName = userName;
        this.date = date;
    }

    public int getAvatar(){
        return this.avatar;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getDate(){
        return this.date;
    }
}

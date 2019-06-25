package com.example.art.vkwall;

public class WallItem {
    private String avatarUrl;
    private String userName;
    private Long date;
    private String postText;
    private String postImageUrl;

    public WallItem(String avatarUrl, String userName, Long date){
        this.avatarUrl = avatarUrl;
        this.userName = userName;
        this.date = date;
    }

    public WallItem(String avatarUrl, String userName, Long date, String postText, String postImageUrl){
        this.avatarUrl = avatarUrl;
        this.userName = userName;
        this.date = date;
        this.postText = postText;
        this.postImageUrl = postImageUrl;
    }

    public void changeUserName(String name){
        userName = name;
    }

    public String getAvatarUrl(){
        return this.avatarUrl;
    }

    public String getUserName(){
        return this.userName;
    }

    public Long getDate(){
        return this.date;
    }

    public String getPostText(){ return this.postText; }

    public String getPostImageUrl(){ return this.postImageUrl; }
}

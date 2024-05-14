package com.example.mymusicplayer.music;

import com.example.mymusicplayer.R;

public class Music {

    private String music_name;
    private String singer;

    private int picture;

    private boolean isCollected;

    private long duration;

    public Music(String name, String singer, int pic, boolean isCollected){
        this.music_name = name;
        this.singer = singer;
        this.picture = pic;
        this.isCollected = isCollected;
    }

    public Music(){
        music_name = "未知";
        singer = "未知";
        picture = R.drawable.picture_test;
        isCollected = false;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
    public String getMusic_name() {
        return music_name;
    }

    public int getPicture() {
        return picture;
    }

    public String getSinger() {
        return singer;
    }
    public boolean getCollected(){
        return isCollected;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
    public long getDuration() {
        return duration;
    }
    public void setCollected(boolean collected) {
        isCollected = collected;
    }
}

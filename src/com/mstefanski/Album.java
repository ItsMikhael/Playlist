package com.mstefanski;

import java.util.ArrayList;

public class Album {

    private String name;
    private ArrayList<Song> songs;

    public Album(String name) {
        this.name = name;
        this.songs = new ArrayList<Song>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public boolean addSong(String songName, int duration) {
        for(int i = 0; i<this.songs.size(); i++) {
            if(this.songs.get(i).getTitle() == songName) {
                return false;
            }
        }
        this.songs.add(new Song(songName, duration));
        return true;
    }

}

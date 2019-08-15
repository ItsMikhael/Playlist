package com.mstefanski;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Playlist {

    private String name;
    private ArrayList<Album> albums;
    private LinkedList<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.albums = new ArrayList<>();
        this.songs = new LinkedList<>();
    }

    public LinkedList<Song> getSongs() {
        return songs;
    }

    public boolean addAlbum(Album album) {
        for (int i = 0; i < albums.size(); i++) {
            if (this.albums.get(i) == album) {
                return false;
            }
        }
        this.albums.add(album);
        return true;
    }

    public boolean addToPlaylist(String song) {
        boolean isInAlbum = false;
        int albumIndex = 0;
        int songIndex = 0;
        for (int i = 0; i < albums.size(); i++) {
            for (int j = 0; j < albums.get(i).getSongs().size(); j++) {
                if (this.albums.get(i).getSongs().get(j).getTitle() == song) {
                    isInAlbum = true;
                    albumIndex = i;
                    songIndex = j;
                }
            }
        }
        if (isInAlbum) {
            this.songs.add(this.albums.get(albumIndex).getSongs().get(songIndex));
            return true;
        } else {
            System.out.println("\nThe song " + song + " is not in any album!\n");
            return false;
        }
    }

    public void play(LinkedList songs) {

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;

        ListIterator<Song> listIterator = songs.listIterator();

        if (songs.isEmpty()) {
            System.out.println("No songs in the playlist.");
            return;
        } else {
            System.out.println("Now playing: " + listIterator.next().getTitle() + "\n");
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now Playing: " + listIterator.next().getTitle());
                        break;
                    } else {
                        System.out.println("It is the last song!");
                        break;
                    }
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now Playing: " + listIterator.previous().getTitle());
                        break;
                    } else {
                        System.out.println("It is the first song!");
                        break;
                    }
                case 3:
                    if (listIterator.hasNext()) {
                        System.out.println("Now Playing: " + listIterator.next().getTitle());
                        break;
                    } else {
                        System.out.println("Now Playing: " + listIterator.previous().getTitle());
                    }
            }
        }

    }

    public static void printMenu() {
        System.out.println("Press 0 to quit");
        System.out.println("Press 1 to play next song");
        System.out.println("Press 2 to play previous song");
        System.out.println("Press 3 to replay current song");
    }

}

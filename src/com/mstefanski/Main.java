package com.mstefanski;

public class Main {

    public static void main(String[] args) {

	Album myAlbum = new Album("My album");

	myAlbum.addSong("A love song", 145);
	myAlbum.addSong("Some other song", 200);
	myAlbum.addSong("Crazy Track", 118);
	myAlbum.addSong("War Zone", 95);
	myAlbum.addSong("Tragedy", 212);
	myAlbum.addSong("Peaceful Lake", 176);
	myAlbum.addSong("Tremendous", 101);
	myAlbum.addSong("Poker Face", 320);

	for(int i=0; i<myAlbum.getSongs().size(); i++) {
		System.out.println(myAlbum.getSongs().get(i).getTitle());
	}

	Playlist playlist = new Playlist("My playlist");
	playlist.addAlbum(myAlbum);

	playlist.addToPlaylist("Peaceful Lake");
	playlist.addToPlaylist("Danger Zone");
	playlist.addToPlaylist("Tragedy");
	playlist.addToPlaylist("Poker Face");
	playlist.addToPlaylist("Tremendous");
	playlist.addToPlaylist("Some other song");
	playlist.addToPlaylist("A love song");

	playlist.play(playlist.getSongs());

    }
}

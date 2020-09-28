package com.model;

public class AllSongsPagenation {
 private String artist_name;
 private String Genere_name;
 private String title_name;
 private String album_name;
 private int music_id;
public String getArtist_name() {
	return artist_name;
}
public void setArtist_name(String artist_name) {
	this.artist_name = artist_name;
}
public String getGenere_name() {
	return Genere_name;
}
public void setGenere_name(String genere_name) {
	Genere_name = genere_name;
}
public String getTitle_name() {
	return title_name;
}
public void setTitle_name(String title_name) {
	this.title_name = title_name;
}
public String getAlbum_name() {
	return album_name;
}
public void setAlbum_name(String album_name) {
	this.album_name = album_name;
}
public int getMusic_id() {
	return music_id;
}
public void setMusic_id(int music_id) {
	this.music_id = music_id;
}
public AllSongsPagenation(String artist_name, String genere_name, String title_name, String album_name, int music_id) {
	super();
	this.artist_name = artist_name;
	Genere_name = genere_name;
	this.title_name = title_name;
	this.album_name = album_name;
	this.music_id = music_id;
}
@Override
public String toString() {
	return "AllSongsPagenation [artist_name=" + artist_name + ", Genere_name=" + Genere_name + ", title_name="
			+ title_name + ", album_name=" + album_name + ", music_id=" + music_id + "]";
}
public AllSongsPagenation(){
		
	}
	
}

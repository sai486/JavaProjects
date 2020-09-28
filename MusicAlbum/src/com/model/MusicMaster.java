package com.model;

public class MusicMaster {
private int music_id;
private int album_id;
private int title_id;
private int artist_id;
private int genre_id;



public int getMusic_id() {
	return music_id;
}
public void setMusic_id(int music_id) {
	this.music_id = music_id;
}
public int getAlbum_id() {
	return album_id;
}
public void setAlbum_id(int album_id) {
	this.album_id = album_id;
}
public int getTitle_id() {
	return title_id;
}
public void setTitle_id(int title_id) {
	this.title_id = title_id;
}
public int getArtist_id() {
	return artist_id;
}
public void setArtist_id(int artist_id) {
	this.artist_id = artist_id;
}
public int getGenre_id() {
	return genre_id;
}
public void setGenre_id(int genre_id) {
	this.genre_id = genre_id;
}
public MusicMaster(int music_id, int album_id, int title_id, int artist_id, int genre_id) {
	super();
	this.music_id = music_id;
	this.album_id = album_id;
	this.title_id = title_id;
	this.artist_id = artist_id;
	this.genre_id = genre_id;
}
@Override
public String toString() {
	return "MusicMaster [music_id=" + music_id + ", album_id=" + album_id + ", title_id=" + title_id + ", artist_id="
			+ artist_id + ", genre_id=" + genre_id + "]";
}



public MusicMaster(){
	
}


}

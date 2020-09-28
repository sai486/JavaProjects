package com.model;

public class Genremaster {
private int genre_id;
private String genere_name;
public int getGenre_id() {
	return genre_id;
}
public void setGenre_id(int genre_id) {
	this.genre_id = genre_id;
}
public String getGenere_name() {
	return genere_name;
}
public void setGenere_name(String genere_name) {
	this.genere_name = genere_name;
}
public Genremaster(int genre_id, String genere_name) {
	super();
	this.genre_id = genre_id;
	this.genere_name = genere_name;
}


public Genremaster(){
	
}
@Override
public String toString() {
	return "Genremaster [genre_id=" + genre_id + ", genere_name=" + genere_name + "]";
}



}

package com.model;

public class Titlemaster {
private int title_id;
private String title_name;
public int getTitle_id() {
	return title_id;
}
public void setTitle_id(int title_id) {
	this.title_id = title_id;
}
public String getTitle_name() {
	return title_name;
}
public void setTitle_name(String title_name) {
	this.title_name = title_name;
}
public Titlemaster(int title_id, String title_name) {
	super();
	this.title_id = title_id;
	this.title_name = title_name;
}
@Override
public String toString() {
	return "Titlemaster [title_id=" + title_id + ", title_name=" + title_name + "]";
}

public Titlemaster(){
	
}
}

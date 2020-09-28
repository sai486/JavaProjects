package com.model;

public class PlayList {

	private int userid;
	private int songno;
	private String playlistname;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getSongno() {
		return songno;
	}
	public void setSongno(int songno) {
		this.songno = songno;
	}
	public String getPlaylistname() {
		return playlistname;
	}
	public void setPlaylistname(String playlistname) {
		this.playlistname = playlistname;
	}
	
	public PlayList() {
		
	}
	public PlayList(int userid, int songno, String playlistname) {
		super();
		this.userid = userid;
		this.songno = songno;
		this.playlistname = playlistname;
	}
	@Override
	public String toString() {
		return "PlayListModel [userid=" + userid + ", songno=" + songno + ", playlistname=" + playlistname + "]";
	}
}

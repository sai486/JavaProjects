package com.Ser_classes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.imp.Insert_Music_Dao;
import com.interfaces.Music_interface;
import com.interfaces.Ser_Interface;
import com.model.MusicMaster;

public class Insert_Music implements Ser_Interface{

	@Override
	public void perform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int aid= Integer.parseInt(req.getParameter("album"));
		int tid= Integer.parseInt(req.getParameter("title"));
		int arid= Integer.parseInt(req.getParameter("artist"));
		int gid= Integer.parseInt(req.getParameter("genre"));
		MusicMaster mm = new MusicMaster();
		mm.setAlbum_id(aid);
		mm.setTitle_id(tid);
		mm.setArtist_id(arid);
		mm.setGenre_id(gid);
		Music_interface mi = new Insert_Music_Dao();
		if(mi.insertDetails(mm)){
			RequestDispatcher rd = req.getRequestDispatcher("/Delete_album.java");
			  rd.include(req, res);
		}
		else{
			res.sendRedirect("Insert_Music.jsp");
		}
		
		
	}

}

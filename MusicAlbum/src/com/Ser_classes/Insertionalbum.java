package com.Ser_classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.imp.InsertionAlbumDao;
import com.interfaces.Album_interface;
import com.interfaces.Ser_Interface;
import com.model.AlbumtypeMaster;

public class Insertionalbum implements Ser_Interface {
	public static String img;
	public static int size;
	public static FileInputStream fos;

	@Override
	public void perform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String aname = req.getParameter("aname");
		int ayear = Integer.parseInt(req.getParameter("ayear"));
		AlbumtypeMaster at = new AlbumtypeMaster();
		at.setAlbum_name(aname);
		at.setYear(ayear);
		img = req.getParameter("img");
		try {
			File f = new File(img);
			 size = (int) f.length();
			
			 fos = new FileInputStream(f);
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		  Album_interface ai = new InsertionAlbumDao();
		  
//		  ai.insertDetails(at);
		  
		  if(ai.insertDetails(at)){
			  RequestDispatcher rd = req.getRequestDispatcher("/List_Details_Album.jsp");
			  rd.include(req, res);
		  }
		  else
		  {
			  res.sendRedirect("Insert_Album.jsp");
		  }
		
	}

}

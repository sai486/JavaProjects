package com.Ser_classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.imp.Insert_Artist_Dao;
import com.Dao.imp.Insert_Genre_Dao;
import com.interfaces.Artist_interface;
import com.interfaces.Genre_interface;
import com.interfaces.Ser_Interface;
import com.model.ArtistMaster;
import com.model.Genremaster;

public class Insertion_Genre  implements Ser_Interface{

	@Override
	public void perform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String aname = req.getParameter("aname");
	
		Genremaster at = new Genremaster();
		at.setGenere_name(aname);		
		 Genre_interface ai = new Insert_Genre_Dao();
		  if(ai.insertDetails(at)){
			  RequestDispatcher rd = req.getRequestDispatcher("/List_Details_Genre.jsp");
			  rd.include(req, res);
		  }
		  else{
			  res.sendRedirect("Insert_Genre.jsp");
		  }
	}

}

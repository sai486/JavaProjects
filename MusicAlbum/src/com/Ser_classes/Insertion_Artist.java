package com.Ser_classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.imp.Insert_Artist_Dao;

import com.interfaces.Artist_interface;
import com.interfaces.Ser_Interface;

import com.model.ArtistMaster;

public class Insertion_Artist implements Ser_Interface {

	@Override
	public void perform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String aname = req.getParameter("aname");
		String ayear = req.getParameter("profession");
		ArtistMaster at = new ArtistMaster();
		at.setArtist_name(aname);
		at.setProfession(ayear);
		  Artist_interface ai = new Insert_Artist_Dao();
		  if(ai.insertDetails(at)){
			  RequestDispatcher rd = req.getRequestDispatcher("/List_Details_Artist.jsp");
			  rd.include(req, res);
		  }
		  else{
			  res.sendRedirect("Insertion_Atrist.jsp");
		  }
		
	}

}

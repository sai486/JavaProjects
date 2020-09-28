package com.Ser_classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.imp.Update_Atrist_Dao;
import com.Dao.imp.Update_Genre_Dao;
import com.interfaces.Artist_interface;
import com.interfaces.Genre_interface;
import com.interfaces.Ser_Interface;
import com.model.ArtistMaster;
import com.model.Genremaster;

public class Update_Genre implements Ser_Interface{

	@Override
	public void perform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		int aid = Integer.parseInt(req.getParameter("aid"));
		String aname = req.getParameter("aname");
		
		Genremaster atm = new Genremaster(aid, aname);
		Genre_interface ai = new Update_Genre_Dao();
		if(ai.updateDetails(atm)){
			
			  RequestDispatcher rd = req.getRequestDispatcher("/List_Details_Genre.jsp");
			  rd.include(req, res);
		  }
		
	}

}

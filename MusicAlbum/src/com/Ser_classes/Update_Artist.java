package com.Ser_classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.imp.UpdateAlbumDao;
import com.Dao.imp.Update_Atrist_Dao;
import com.interfaces.Album_interface;
import com.interfaces.Artist_interface;
import com.interfaces.Ser_Interface;
import com.model.AlbumtypeMaster;
import com.model.ArtistMaster;

public class Update_Artist implements Ser_Interface {

	@Override
	public void perform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		int aid = Integer.parseInt(req.getParameter("aid"));
		String aname = req.getParameter("aname");
		String profession = req.getParameter("ayear");
		ArtistMaster atm = new ArtistMaster(aid, aname, profession);
		Artist_interface ai = new Update_Atrist_Dao();
		if(ai.updateDetails(atm)){
			  RequestDispatcher rd = req.getRequestDispatcher("/List_Details_Artist.jsp");
			  rd.include(req, res);
		  
		}
		
	}

}

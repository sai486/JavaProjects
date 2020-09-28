package com.Ser_classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.imp.UpdateAlbumDao;
import com.interfaces.Album_interface;
import com.interfaces.Ser_Interface;
import com.model.AlbumtypeMaster;

public class Update_album  implements Ser_Interface{

	@Override
	public void perform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		int aid = Integer.parseInt(req.getParameter("aid"));
		String aname = req.getParameter("aname");
		int ayear = Integer.parseInt(req.getParameter("ayear"));
		AlbumtypeMaster atm = new AlbumtypeMaster(aid,aname,ayear);
		Album_interface ai = new UpdateAlbumDao();
		if(ai.updateDetails(atm)){
			  RequestDispatcher rd = req.getRequestDispatcher("/List_Details_Album.jsp");
			  rd.include(req, res);
		  
		}
	}

}

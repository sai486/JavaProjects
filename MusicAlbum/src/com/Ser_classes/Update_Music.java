package com.Ser_classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.Dao.imp.Update_Music_Dao;

import com.interfaces.Music_interface;
import com.interfaces.Ser_Interface;

import com.model.MusicMaster;

public class Update_Music implements Ser_Interface {

	@Override
	public void perform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		int mid = Integer.parseInt(req.getParameter("mid"));
		int aid = Integer.parseInt(req.getParameter("aid"));
		int tid = Integer.parseInt(req.getParameter("tid"));
		int arid = Integer.parseInt(req.getParameter("arid"));
		int gid = Integer.parseInt(req.getParameter("gid"));
		
		MusicMaster atm = new MusicMaster(mid, aid, tid, arid, gid);
		Music_interface ai = new Update_Music_Dao();
		if(ai.updateDetails(atm)){
			  RequestDispatcher rd = req.getRequestDispatcher("/List_Details_Music.jsp");
			  rd.include(req, res);
		  
		}
		
	}

}

package com.Ser_classes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.imp.Delete_Genre_Dao;
import com.Dao.imp.Delete_Music_Dao;
import com.interfaces.Genre_interface;
import com.interfaces.Music_interface;
import com.interfaces.Ser_Interface;

public class Delete_Music implements Ser_Interface {

	@Override
	public void perform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int aid  = Integer.parseInt(req.getParameter("aid"));
//		System.out.println(aid);
		Music_interface ai = new Delete_Music_Dao();
		if(ai.deleteData(aid)){
			RequestDispatcher rd = req.getRequestDispatcher("/List_Details_Music.jsp");
			  rd.include(req, res);
		}
		
	}

}

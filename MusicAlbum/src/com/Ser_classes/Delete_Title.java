package com.Ser_classes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.imp.DeleteAlbumDao;
import com.Dao.imp.Delete_Title_Dao;
import com.interfaces.Album_interface;
import com.interfaces.Ser_Interface;
import com.interfaces.Title_interface;

public class Delete_Title implements Ser_Interface{

	@Override
	public void perform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int aid  = Integer.parseInt(req.getParameter("aid"));
//		System.out.println(aid);
		Title_interface ti = new Delete_Title_Dao();
		if(ti.deleteData(aid)){
			RequestDispatcher rd = req.getRequestDispatcher("/List_Details_Title.jsp");
			  rd.include(req, res);
		}
		
	}

}

package com.Ser_classes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.imp.DeleteAlbumDao;
import com.interfaces.Album_interface;
import com.interfaces.Ser_Interface;

public class Delete_album implements Ser_Interface {

	@Override
	public void perform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int aid  = Integer.parseInt(req.getParameter("aid"));
//		System.out.println(aid);
		Album_interface ai = new DeleteAlbumDao();
		if(ai.deleteData(aid))
		{
			RequestDispatcher rd = req.getRequestDispatcher("/List_Details_Album.jsp");
			  rd.include(req, res);
		}
		else{
			System.out.println("not deleted");
		}
		
		
	}

}

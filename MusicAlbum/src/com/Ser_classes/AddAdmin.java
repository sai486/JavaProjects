package com.Ser_classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.imp.AdminAdd;
import com.interfaces.Admin_interface;
import com.interfaces.Ser_Interface;
import com.model.Admin;


public class AddAdmin  implements Ser_Interface{

	@Override
	public void perform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		Admin am = new Admin();
		am.setAname(req.getParameter("adminname"));
		am.setEmail(req.getParameter("adminemail"));
		Admin_interface ad = new AdminAdd();
		RequestDispatcher rd = req.getRequestDispatcher("./Template.jsp");
		if(ad.addAdmin(am)) {
			rd.forward(req, res);
			
		}
		else {
			pw.print("New Admin Not added");
		}
		
	}

}

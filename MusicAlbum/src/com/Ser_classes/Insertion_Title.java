package com.Ser_classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.Dao.imp.Insert_Title_Dao;

import com.interfaces.Ser_Interface;
import com.interfaces.Title_interface;

import com.model.Titlemaster;

public class Insertion_Title implements Ser_Interface {

	@Override
	public void perform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String aname = req.getParameter("aname");
		
		Titlemaster tm = new Titlemaster();
		tm.setTitle_name(aname);
		Title_interface ti = new Insert_Title_Dao();
		 if(ti.insertDetails(tm)){
			 RequestDispatcher rd = req.getRequestDispatcher("/List_Details_Title.jsp");
			  rd.include(req, res);
		 }
		 else{
			 res.sendRedirect("Insert_Title.jsp");
		 }
		
	}

}

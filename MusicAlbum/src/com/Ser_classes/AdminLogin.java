package com.Ser_classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.imp.AdminLoginCheck;
import com.interfaces.Admin_interface;
import com.interfaces.Ser_Interface;

public class AdminLogin implements Ser_Interface{

	@Override
	public void perform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String uname = req.getParameter("aname");
		String pass = req.getParameter("apass");
		Admin_interface va = new AdminLoginCheck();
		RequestDispatcher rd = req.getRequestDispatcher("./Template.jsp");
		if(va.loginCheck(uname, pass)) {
			HttpSession session = req.getSession();
			session.setAttribute("username", uname);
			rd.forward(req, res);
			
		}
		else {
			res.sendRedirect("./LoginForm.html");
		}
		
	}

}

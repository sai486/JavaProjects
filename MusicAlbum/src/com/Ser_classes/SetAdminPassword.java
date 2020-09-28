package com.Ser_classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.imp.SetPassword;
import com.interfaces.Admin_interface;
import com.interfaces.Ser_Interface;

public class SetAdminPassword implements Ser_Interface{

	@Override
	public void perform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		String pass = req.getParameter("upass");
		Admin_interface sp = new SetPassword();
		RequestDispatcher rd = req.getRequestDispatcher("./LoginForm.html");
		if(sp.setPassword(uname, pass, email)) {
			rd.forward(req, res);
			
		}
		else {
			pw.println("Your Password is incorrect");
		}
		
	}

}

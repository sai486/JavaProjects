package com.Ser_classes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.imp.UserLoginCheck;

import com.interfaces.Ser_Interface;
import com.interfaces.User_interface;

public class UserLogin implements Ser_Interface{

	@Override
	public void perform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String upass = req.getParameter("upass");
		UserLoginCheck ul = new UserLoginCheck();
		RequestDispatcher rd = req.getRequestDispatcher("./UserHome.jsp");
		if(ul.loginCheck(uname, upass)) { 
			System.out.println(ul.id);
			HttpSession session = req.getSession();
			session.setAttribute("username", uname);
			session.setAttribute("id", ul.id);
			rd.forward(req, res);
			
		}
		else {
			res.sendRedirect("./LoginForm.html");
		}
		
	}

}

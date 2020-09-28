package com.Ser_classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Dao.imp.AddUser;
import com.interfaces.Ser_Interface;
import com.interfaces.User_interface;
import com.model.User;


public class UserAdd  implements Ser_Interface{

	@Override
	public void perform(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		User um = new User();
		um.setUname(req.getParameter("username"));
		um.setPassword(req.getParameter("password1"));
		um.setEmail(req.getParameter("newemail"));
		User_interface anud = new AddUser();
		if(anud.addUser(um)) {
			res.sendRedirect("./LoginForm.html");
		}
		else {
			pw.println("Not Added");
		}
		
	}

}

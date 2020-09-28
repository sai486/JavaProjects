package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShopS
 */
@WebServlet("/ShopS")
public class ShopS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */HttpSession session;
	 String pcode,qty,clickButton;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter pw = response.getWriter();
session = request.getSession(true);
clickButton = request.getParameter("submit");
if(clickButton.equals("AddItem")){
	pcode = request.getParameter("pcode");
	qty = request.getParameter("qty");
	if(!pcode.equals("")||qty.equals("")){
		session.setAttribute(pcode, qty);
		response.sendRedirect("Shop.html");
	}
	
	
}
if(clickButton.equals("RemoveItem")){
	pcode = request.getParameter("pcode");
	
		session.removeAttribute(pcode);
		response.sendRedirect("Shop.html");
	}



if(clickButton.equals("ShowItem")){
	
	Enumeration e = session.getAttributeNames();
	if(e.hasMoreElements()){
		pw.println("<h2><font color=blue> your shopping cart items </font></h2>");;
		while(e.hasMoreElements()){
			pw.println("<body bgcolor=cyan>");
			String code = (String) e.nextElement();
			pw.println("<h2>Product Code"+code);
			pw.println("Quantity:"
					+session.getAttribute(code));
		}
	}
	else{
		pw.println("<body bgcolor=cyan>");
		pw.println("<h2><font color=red>No Items Please</font></h2>");
	}
	}	
if(clickButton.equals("Logout")){
	session.invalidate();
	response.sendRedirect("Shop.html");
}
if(clickButton.equals("Payment")){
	pw.println("<body bgcolor=yellow>");
	pw.println("<h2><font color =red>payment logic goes here</font></h2>");
	
}
pw.close();

		
		
	}

}

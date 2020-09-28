package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HiddenS
 */
@WebServlet("/HiddenS")
public class HiddenS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HiddenS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<html><head><title>Servlet HiddenServlet</title></head>");
		pw.println("<body><h1>Servlet HiddenServlet at "+request.getContextPath()+"</h1>");
		String name = request.getParameter("tn");
		String contactNo = request.getParameter("tc");
		
		
		pw.println("<h3> welcome"+name+"|||</h3>");
		pw.println("<form action= 'HiddenS2'>");
		
		pw.println("Email Id : <input type='text' name ='te'>");
		pw.println("<br> <input type ='hidden' name = 'hn' value ='"+name+"'>");
		pw.println("<br> <input type ='hidden' name = 'hc' value ='"+contactNo+"'>");
		pw.println("<input type ='submit' value ='submit'>");
		pw.println("</form></body></html>");
		pw.close();
		
		
		
		
	}

}

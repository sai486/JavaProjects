package com.lisener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.model.Product;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
@WebListener
public class MyListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public MyListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
       
    	HttpSession session = se.getSession();
    	List<Product> cart = new ArrayList<Product>();
    	session.setAttribute("mycart",cart);
    	System.out.println("Empty cart is created");
    	
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}

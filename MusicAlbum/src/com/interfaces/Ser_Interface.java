package com.interfaces;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Ser_Interface {
	public void perform(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException;

}

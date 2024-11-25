package com.sandeep.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		HttpSession session=request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");


		}catch(Exception e) {
		response.sendRedirect("ExpPage.jsp");
		e.printStackTrace();



	}
	}

}

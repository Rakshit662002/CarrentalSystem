package com.sandeep.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sandeep.modals.DAO;


@WebServlet("/AddEnquiry")
public class AddEnquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {


		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		DAO db=new DAO();
		db.addEnquiry(name,phone);
		db.closeConnection();
		//make a session for sending message it is valid or invalid
		HttpSession session=request.getSession();
		System.out.println("hello ssandeep");
			session.setAttribute("msg", "Thank you! We will contact soon as posible as");
			response.sendRedirect("index.jsp");

		}catch(Exception e) {
		response.sendRedirect("ExpPage.jsp");
		e.printStackTrace();



	}
	}

}

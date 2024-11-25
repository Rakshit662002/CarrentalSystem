package com.sandeep.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sandeep.modals.DAO;


@WebServlet("/ChangeEnquiryStatus")
public class ChangeEnquiryStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {

		int id=Integer.parseInt(request.getParameter("id"));

		DAO db=new DAO();
		db.changeEnquiryStatus(id);
		db.closeConnection();

		response.sendRedirect("Enquiries.jsp");

		}catch(Exception e) {
		response.sendRedirect("ExpPage.jsp");
		e.printStackTrace();



	}
	}

}

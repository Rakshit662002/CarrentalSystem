package com.sandeep.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sandeep.modals.DAO;


@WebServlet("/ViewIDProof")
public class ViewIDProof extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {


		String email=request.getParameter("email");
		DAO db=new DAO();
		byte[] IDProof=db.getIDProof(email);
		db.closeConnection();

			response.getOutputStream().write(IDProof);


	}catch(Exception e) {
		response.sendRedirect("ExpPage.jsp");
		e.printStackTrace();
	}
	}

}

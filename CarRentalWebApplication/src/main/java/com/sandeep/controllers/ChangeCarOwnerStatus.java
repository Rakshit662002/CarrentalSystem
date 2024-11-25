package com.sandeep.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sandeep.modals.DAO;
import com.sandeep.modals.SendMail;


@WebServlet("/ChangeCarOwnerStatus")
public class ChangeCarOwnerStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
	String email=request.getParameter("email");
	String status=request.getParameter("status");
	DAO db=new DAO();
	db.changeCarOwnerStatus(email,status);
	
	if(status.equalsIgnoreCase("Accept")) {
		SendMail.sendMail(email, "Congrats, You have been Accepted!", "Registration Accepted, You can login now!");
	}else {
		SendMail.sendMail(email, "Sorry!, You have been Rejected!", "Registration Rejected, You can apply for registration again!");
	}
	
	response.sendRedirect("AdminHome.jsp");
	db.closeConnection();
	

}catch(Exception e)
{
	response.sendRedirect("ExpPage.jsp");
    e.printStackTrace();
}

	}

}

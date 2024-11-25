package com.sandeep.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sandeep.modals.DAO;


@WebServlet("/AvailableCar")
public class AvailableCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String reg_no=request.getParameter("reg_no");
			DAO db=new DAO();
			db.makeAvailable(reg_no);
			db.closeConnection();
			HttpSession session=request.getSession();
			session.setAttribute("msg", "Car Status updated!");
			response.sendRedirect("CarOwnerHome.jsp");
			
		}catch(Exception e) {
			response.sendRedirect("ExpPage.jsp");
			e.printStackTrace();
		}
	}

}

package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.Person;

/**
 * Servlet implementation class personServlet
 */
public class personServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public personServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//потратил вечность на эту строку кода
		Person.setName(request.getParameter("first_name"));
		
		Person.setFathName(request.getParameter("fath_name"));
		
		Person.setAdress(request.getParameter("adress"));
		
		Person.setBankAcc(request.getParameter("bank_acc"));
		
		Person.setLastName(request.getParameter("last_name"));
		
		response.sendRedirect(request.getContextPath() + "/index.jsp");

	}

}

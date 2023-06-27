package org.study.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SiteController
 */
@WebServlet("/Site")
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page= request.getParameter("page");
		switch(page.toLowerCase()) {
		case "home":
			request.setAttribute("title", "Homepage ");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		default:
			request.setAttribute("title", "ErrorPage");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}

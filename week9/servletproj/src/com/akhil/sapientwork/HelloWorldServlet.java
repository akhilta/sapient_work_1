package com.akhil.sapientwork;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */

public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloWorldServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s = request.getPathInfo();

		switch (s) {
		case "/sugar":
			sugar s1 = new sugar();
			s1.doGet(request, response);
			break;
		case "/bat":
			// rd = request.getRequestDispatcher("bat");
			bat s2 = new bat();
			s2.doGet(request, response);

			break;
		case "/file":
			file s3 = new file();
			s3.doGet(request, response);
			break;
		default:
			System.out.println("came into main servlet   " + s);
			response.getWriter().append("Served at: ").append(request.getContextPath() + " " + s);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

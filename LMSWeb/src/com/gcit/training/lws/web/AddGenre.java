package com.gcit.training.lws.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gcit.training.lws.domain.Genre;
import com.gcit.training.lws.service.AdministratorService;

/**
 * Servlet implementation class AddGenre
 */
@WebServlet("/AddGenre")
public class AddGenre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddGenre() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1111");
		String genreName = request.getParameter("genreName");
		Genre g = new Genre();
		g.setName(genreName);
		try{
			System.out.println("2222");
			new AdministratorService().addGenre(g);
		}catch(Exception e){
			System.out.println("xxxx");
			e.getMessage();
		}
	}

}

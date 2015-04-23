package com.gcit.training.lws.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gcit.training.lws.domain.Publisher;
import com.gcit.training.lws.service.AdministratorService;

/**
 * Servlet implementation class AddPublisher
 */
@WebServlet("/AddPublisher")
public class AddPublisher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPublisher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String publisherName = request.getParameter("publisherName");
		String publisherAddress = request.getParameter("publisherAddress");
		String publisherPhone = request.getParameter("publisherPhone");
		
		Publisher p = new Publisher();
		p.setName(publisherName);
		p.setAddress(publisherAddress);
		p.setPhoneNumber(publisherPhone);
		
		try{
			new AdministratorService().addPublisher(p);
		}catch(Exception e){
			e.getMessage();
		}
	}

}

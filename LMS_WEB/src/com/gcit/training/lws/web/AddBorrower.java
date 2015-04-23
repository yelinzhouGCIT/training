package com.gcit.training.lws.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gcit.training.lws.domain.Borrower;
import com.gcit.training.lws.service.AdministratorService;

/**
 * Servlet implementation class AddBorrower
 */
@WebServlet("/AddBorrower")
public class AddBorrower extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBorrower() {
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
		// TODO Auto-generated method stub
		String borrowerName = request.getParameter("borrowerName");
		String borrowerAddress = request.getParameter("borrowerAddress");
		String borrowerPhone = request.getParameter("borrowerPhone");
		System.out.println(borrowerName+borrowerAddress+borrowerPhone);
		
		Borrower b = new Borrower();
		b.setBorrowerName(borrowerName);
		b.setBorrowerAddress(borrowerAddress);
		b.setBorrowerPhone(borrowerPhone);
		
		try{
			new AdministratorService().addBorrower(b);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}

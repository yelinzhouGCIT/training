package com.gcit.training.lws.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gcit.training.lws.domain.LibraryBranch;
import com.gcit.training.lws.service.AdministratorService;

/**
 * Servlet implementation class AddLibraryBranch
 */
@WebServlet("/AddLibraryBranch")
public class AddLibraryBranch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLibraryBranch() {
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
		String lbName = request.getParameter("lbName");
		String lbAddress = request.getParameter("lbAddress");
		
		LibraryBranch lb = new LibraryBranch();
		lb.setBranchName(lbName);
		lb.setBranchAddress(lbAddress);
		try{
			new AdministratorService().addLibraryBranch(lb);
		}catch (Exception e){
			e.getMessage();
		}
	}

}

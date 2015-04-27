package com.gcit.training.lws.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gcit.training.lws.domain.Author;
import com.gcit.training.lws.domain.Book;
import com.gcit.training.lws.domain.Borrower;
import com.gcit.training.lws.domain.Genre;
import com.gcit.training.lws.domain.LibraryBranch;
import com.gcit.training.lws.domain.Publisher;
import com.gcit.training.lws.service.AdministratorService;

/**
 * Servlet implementation class LibaryManagement
 */
@WebServlet({ "/addAuthor", "/addPublisher", "/addBorrower", "/addBook","/addGenre",
		"/addLibraryBranch", "/deleteBook","/deleteAuthor", "/deletePublisher",
		"/editAuthor", "/editBook","/editLB" })
public class LibaryManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LibaryManagement() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String function = request.getRequestURI().substring(
				request.getContextPath().length(),
				request.getRequestURI().length());

		RequestDispatcher rd;
		switch (function) {
		case "/deleteAuthor":
			deleteAuthor(request);
			rd = getServletContext().getRequestDispatcher("/listAuthors.jsp");
			rd.forward(request, response);
			break;
		case "/deletePublisher":
			deletePublisher(request);
			rd = getServletContext().getRequestDispatcher("/listPublisher.jsp");
			rd.forward(request, response);
			break;
		case "/deleteBook":
			deleteBook(request);
			rd = getServletContext().getRequestDispatcher("/listBooks.jsp");
			rd.forward(request, response);
			break;
		}

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String function = request.getRequestURI().substring(
				request.getContextPath().length(),
				request.getRequestURI().length());
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/admin.jsp");
		switch (function) {
		case "/addAuthor": {
			addAuthor(request);
			break;
		}
		case "/addPublisher": {
			addPublisher(request);
			break;
		}

		case "/addBorrower": {
			addBorrower(request);
			break;
		}
		case "/addLibraryBranch": {
			addLB(request);
			break;
		}
		case "/addGenre": {
			addGenre(request);
		}
		case "/editAuthor": {
			editAuthor(request);
			rd = getServletContext().getRequestDispatcher("/listAuthors.jsp");
			break;
		}
		
		case "/editBook":{
			editBook(request);
			rd = getServletContext().getRequestDispatcher("/listBooks.jsp");
			break;
		}
		case "/editLB":{
			editLB(request);
			rd = getServletContext().getRequestDispatcher("/librarian.jsp");
			break;
		}
		
		case "/addBook": {
			addBook(request);
		}
		default:
			break;
		}

		rd.forward(request, response);
	}

	private void addGenre(HttpServletRequest request) {
		String genreName = request.getParameter("genreName");
		Genre g = new Genre();
		g.setName(genreName);
		try {
			new AdministratorService().addGenre(g);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	private void addLB(HttpServletRequest request) {
		String lbName = request.getParameter("lbName");
		String lbAddress = request.getParameter("lbAddress");

		LibraryBranch lb = new LibraryBranch();
		lb.setBranchName(lbName);
		lb.setBranchAddress(lbAddress);
		try {
			new AdministratorService().addLibraryBranch(lb);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	private void addBorrower(HttpServletRequest request) {
		String borrowerName = request.getParameter("borrowerName");
		String borrowerAddress = request.getParameter("borrowerAddress");
		String borrowerPhone = request.getParameter("borrowerPhone");
		System.out.println(borrowerName + borrowerAddress + borrowerPhone);

		Borrower b = new Borrower();
		b.setBorrowerName(borrowerName);
		b.setBorrowerAddress(borrowerAddress);
		b.setBorrowerPhone(borrowerPhone);

		try {
			new AdministratorService().addBorrower(b);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void addPublisher(HttpServletRequest request) {
		String publisherName = request.getParameter("publisherName");
		String publisherAddress = request.getParameter("publisherAddress");
		String publisherPhone = request.getParameter("publisherPhone");

		Publisher p = new Publisher();
		p.setName(publisherName);
		p.setAddress(publisherAddress);
		p.setPhoneNumber(publisherPhone);

		try {
			new AdministratorService().addPublisher(p);
			request.setAttribute("result", "Publisher added succesfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("result",
					"Publisher add failed!: " + e.getMessage());
		}

	}

	private void addAuthor(HttpServletRequest request) {
		String authorName = request.getParameter("authorName");

		Author author = new Author();
		author.setAuthorName(authorName);

		try {
			new AdministratorService().addAuthor(author);
			request.setAttribute("result", "Author added succesfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("result",
					"Author add failed!: " + e.getMessage());
		}
	}

	private void addBook(HttpServletRequest request) {
		String authorId = request.getParameter("authorId");

		String publisherId = request.getParameter("publisherId");
		String title = request.getParameter("bookTitle");
		String genreId = request.getParameter("genreId");

		List<Author> aList = new ArrayList<Author>();
		StringTokenizer st = new StringTokenizer(authorId, ",");
		while (st.hasMoreTokens()) {
			int aId = Integer.parseInt(st.nextToken());
			Author a = new Author();
			a.setAuthorId(aId);
			aList.add(a);
		}

		Genre g = new Genre();
		g.setGenreId(Integer.parseInt(genreId));

		Book b = new Book();
		b.setTitle(title);
		b.setAuthors(aList);

		Publisher p = new Publisher();
		p.setId(Integer.parseInt(publisherId));

		b.setPublisher(p);
		System.out.println(b.toString());
		try {
			new AdministratorService().addBook(b);
			request.setAttribute("result", "Book added succesfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("result",
					"Book add failed!: " + e.getMessage());
		}
	}

	private void deleteAuthor(HttpServletRequest request) {
		String authorId = request.getParameter("authorId");
		Author a = new Author();
		a.setAuthorId(Integer.parseInt(authorId));
		try {
			new AdministratorService().removeAuthor(a);
			request.setAttribute("result", "Author removed succesfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("result",
					"Author remove failed!: " + e.getMessage());
		}
	}
	
	private void deleteBook(HttpServletRequest request) {
		String bookId = request.getParameter("bookId");
		Book b = new Book();
		b.setBookId(Integer.parseInt(bookId));
		try {
			new AdministratorService().removeBook(b);
			request.setAttribute("result", "Book removed succesfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("result",
					"Book remove failed!: " + e.getMessage());
		}
		
	}

	private void deletePublisher(HttpServletRequest request) {
		String pubId = request.getParameter("publisherId");
		Publisher p = new Publisher();
		p.setId(Integer.parseInt(pubId));
		try {
			new AdministratorService().removePublisher(p);
			request.setAttribute("result", "Publisher removed succesfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("result",
					"Publisher remove failed!: " + e.getMessage());
		}

	}

	private void editAuthor(HttpServletRequest request) {
		String authorName = request.getParameter("authorName");
		String authorId = request.getParameter("authorId");

		Author author = new Author();
		author.setAuthorId(Integer.parseInt(authorId));
		author.setAuthorName(authorName);

		try {
			new AdministratorService().editAuthor(author);
			request.setAttribute("result", "Author edited succesfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("result",
					"Author edit failed!: " + e.getMessage());
		}
	}
	
	
	private void editBook(HttpServletRequest request) {
		String bookTitle = request.getParameter("bookName");
		String bId = request.getParameter("bookId");

		Book b = new Book();
		b.setBookId(Integer.parseInt(bId));
		b.setTitle(bookTitle);

		try {
			new AdministratorService().editBook(b);
			request.setAttribute("result", "Book edited succesfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("result",
					"Book edit failed!: " + e.getMessage());
		}
	}
	
	private void editLB(HttpServletRequest request) {
		String lbName = request.getParameter("lbName");
		String lbAddress = request.getParameter("lbAddress");
		String lbId = request.getParameter("lbId");

		LibraryBranch lb = new LibraryBranch();
		lb.setBranchId(Integer.parseInt(lbId));
		lb.setBranchName(lbName);
		lb.setBranchAddress(lbAddress);

		try {
			new AdministratorService().editLB(lb);
			request.setAttribute("result", "Library Branch edited succesfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("result",
					"Library Branch edit failed!: " + e.getMessage());
		}
	}

}

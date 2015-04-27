package com.gcit.training.lws.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gcit.training.lws.dao.AuthorDAO;
import com.gcit.training.lws.dao.BookCopiesDAO;
import com.gcit.training.lws.dao.BookDAO;
import com.gcit.training.lws.dao.BookLoanDAO;
import com.gcit.training.lws.dao.BorrowerDAO;
import com.gcit.training.lws.dao.GenreDAO;
import com.gcit.training.lws.dao.LibraryBranchDAO;
import com.gcit.training.lws.dao.PublisherDAO;
import com.gcit.training.lws.domain.Author;
import com.gcit.training.lws.domain.Book;
import com.gcit.training.lws.domain.BookCopies;
import com.gcit.training.lws.domain.BookLoan;
import com.gcit.training.lws.domain.Borrower;
import com.gcit.training.lws.domain.Genre;
import com.gcit.training.lws.domain.LibraryBranch;
import com.gcit.training.lws.domain.Publisher;

public class AdministratorService {

	public void addAuthor(Author author) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			new AuthorDAO(conn).addAuthor(author);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		}
	}

	public void addPublisher(Publisher p) throws ClassNotFoundException,
			SQLException {
		Connection conn = ConnectionUtil.getConnection();
		try {
			new PublisherDAO(conn).addPublisher(p);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		}
	}

	public void addGenre(Genre g) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionUtil.getConnection();
		try {
			new GenreDAO(conn).addGenre(g);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		}
	}

	public void addBorrower(Borrower b) throws ClassNotFoundException,
			SQLException {
		Connection conn = ConnectionUtil.getConnection();
		try {
			new BorrowerDAO(conn).addBorrower(b);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		}
	}

	public void addLibraryBranch(LibraryBranch lb) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			new LibraryBranchDAO(conn).addLibraryBranch(lb);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		}
	}

	public void addBook(Book b) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			new BookDAO(conn).addBook(b);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		}
	}

	public void removeAuthor(Author author) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			new AuthorDAO(conn).removeAuthor(author);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		}
	}

	

	public void removeBook(Book b) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			new BookDAO(conn).removeBook(b);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		}
	}

	
	public void removePublisher(Publisher p) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			new PublisherDAO(conn).removePublisher(p);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		}
	}

	public List<Author> getAuthors() throws Exception {
		return new AuthorDAO(ConnectionUtil.getConnection()).readAll();
	}

	public List<Book> getBooks() throws Exception {
		return new BookDAO(ConnectionUtil.getConnection()).readAll();
	}

	public List<Publisher> getPublishers() throws Exception {
		return new PublisherDAO(ConnectionUtil.getConnection()).readAll();
	}

	public List<Borrower> getBorrowers() throws Exception {
		return new BorrowerDAO(ConnectionUtil.getConnection()).readAll();
	}

	public List<Genre> getGenres() throws Exception {
		return new GenreDAO(ConnectionUtil.getConnection()).readAll();
	}

	public List<LibraryBranch> getLibraryBranchs() throws Exception {
		return new LibraryBranchDAO(ConnectionUtil.getConnection()).readAll();
	}

	public List<BookCopies> getBookCopies() throws Exception {
		return new BookCopiesDAO(ConnectionUtil.getConnection()).readAll();
	}

	public List<BookLoan> getBookLoan() throws Exception {
		return new BookLoanDAO(ConnectionUtil.getConnection()).readAll();
	}
	
	public Author getOneAuthor(int authorId) throws Exception {
		return new AuthorDAO(ConnectionUtil.getConnection()).readOne(authorId);
	}

	public LibraryBranch getOneLB(int lbID) throws Exception {
		return new LibraryBranchDAO(ConnectionUtil.getConnection())
				.readOne(lbID);
	}
	
	
	public Book getOneBook(int bID)throws Exception {
		return new BookDAO(ConnectionUtil.getConnection()).readOne(bID);
	}

	public Borrower getOneBorrower(int bID) throws Exception {
		return new BorrowerDAO(ConnectionUtil.getConnection()).readOne(bID);
	}

	public Publisher getOnePublisher(int pID) throws Exception {
		return new PublisherDAO(ConnectionUtil.getConnection()).readOne(pID);
	}
//
//	public BookLoan getOneBookLoan(Date d) throws Exception {
//		return new 
//	}
//	
	public void editAuthor(Author author) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			new AuthorDAO(conn).updateAuthor(author);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		}

	}
	
	
	public void editBook(Book b) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			new BookDAO(conn).update(b);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		}

	}
	
	public void editLB(LibraryBranch lb) throws Exception {
		Connection conn = ConnectionUtil.getConnection();
		try {
			new LibraryBranchDAO(conn).updateLibraryBranch(lb);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		}

	}
}

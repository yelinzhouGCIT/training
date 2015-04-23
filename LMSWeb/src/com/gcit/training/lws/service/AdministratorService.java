package com.gcit.training.lws.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.gcit.training.lws.dao.AuthorDAO;
import com.gcit.training.lws.dao.BorrowerDAO;
import com.gcit.training.lws.dao.GenreDAO;
import com.gcit.training.lws.dao.LibraryBranchDAO;
import com.gcit.training.lws.dao.PublisherDAO;
import com.gcit.training.lws.domain.Author;
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
}

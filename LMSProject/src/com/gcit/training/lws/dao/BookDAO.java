package com.gcit.training.lws.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.lws.domain.Author;
import com.gcit.training.lws.domain.Book;

public class BookDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4822078384536314201L;

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library", "root", "Arashi21AMY");
		return conn;
	}

	public void addBook(Book book) throws SQLException {
		Connection conn = getConnection();

		String updateQuery = "insert into tbl_Book (title) values (?)";
		PreparedStatement pstmt = conn.prepareStatement(updateQuery);
		pstmt.setString(1, book.getTitle());
		pstmt.executeUpdate();

	}

	public void updateBook(Book book) throws SQLException {
		Connection conn = getConnection();

		String updateQuery = "update tbl_Book set title = ? where BookId = ?";
		PreparedStatement pstmt = conn.prepareStatement(updateQuery);
		pstmt.setString(1, book.getTitle());
		pstmt.setInt(2, book.getBookId());
		pstmt.executeUpdate();

	}

	public void removeBook(Book book) throws SQLException {
		Connection conn = getConnection();
		String removeQuery = "delete from tbl_Book where BookId=?";
		PreparedStatement pstmt = conn.prepareStatement(removeQuery);
		pstmt.setInt(1, book.getBookId());
		pstmt.executeUpdate();
	}

	public List<Author> getAuthorFromBook(Book b) throws SQLException {
		Connection conn = getConnection();
		List<Author> aList = new ArrayList<Author>();
		String selectAuthorId = "select authorId from tbl_book_authors where bookId = ?";
		PreparedStatement pstmt = conn.prepareStatement(selectAuthorId);
		pstmt.setInt(1, b.getBookId());
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			String authorNameQuery = "select authorName from tbl_book where authorId = ?";
			PreparedStatement subpstmt = conn.prepareStatement(authorNameQuery);
			pstmt.setInt(1, rs.getInt(1));
			ResultSet subrs = subpstmt.executeQuery();
			while (subrs.next()) {
				Author a = new Author();
				a.setAuthorId(subrs.getInt("authorId"));
				a.setAuthorName(subrs.getString("authorName"));
				aList.add(a);
			}
		}

		return aList;
	}
}

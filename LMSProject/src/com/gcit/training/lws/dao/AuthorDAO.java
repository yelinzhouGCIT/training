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

public class AuthorDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1619700647002508164L;
	

	private Connection getConnection() throws SQLException {
		Connection conn;
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "Arashi21AMY");
		return conn;
	}

	public void addAuthor(Author author) throws SQLException {
		Connection conn = getConnection();

			String updateQuery = "insert into tbl_author (authorName) values (?)";
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, author.getAuthorName());
			pstmt.executeUpdate();

	}
	
	public void updateAuthor(Author author) throws SQLException {
		Connection conn = getConnection();

			String updateQuery = "update tbl_author set authorName = ? where authorId = ?";
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, author.getAuthorName());
			pstmt.setInt(2, author.getAuthorId());
			pstmt.executeUpdate();

	}
	
	public void removeAuthor(Author author) throws SQLException {
		Connection conn = getConnection();

			String removeQuery = "delete from tbl_author where authorId=?";
			PreparedStatement pstmt = conn.prepareStatement(removeQuery);
			pstmt.setInt(1, author.getAuthorId());
			pstmt.executeUpdate();

	}

	public List<Author> readAll() throws SQLException {
		String select = "select * from tbl_author";
		PreparedStatement stmt = getConnection().prepareStatement(select);
		ResultSet rs = stmt.executeQuery();
		
		List<Author> authors = new ArrayList<Author>();
		while(rs.next()) {
			Author a = new Author();
			a.setAuthorId(rs.getInt("authorId"));
			a.setAuthorName(rs.getString("authorName"));
			
			authors.add(a);
		}
		
		return authors;
	}
	
	public List<Book> getBookFromAuthor (Author a) throws SQLException{
		Connection conn = getConnection();
		List<Book> bList = new ArrayList<Book>();
		String selectBookId = "select bookId from tbl_book_authors where authorId = ?";
		PreparedStatement pstmt = conn.prepareStatement(selectBookId);
		pstmt.setInt(1, a.getAuthorId());
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			String bookNameQuery = "select title from tbl_book where bookId = ?";
			PreparedStatement subpstmt = conn.prepareStatement(bookNameQuery);
			pstmt.setInt(1,rs.getInt(1));
			ResultSet subrs = subpstmt.executeQuery();
			while(subrs.next()){
				Book b = new Book();
				b.setBookId(subrs.getInt("bookId"));
				b.setTitle(subrs.getString("title"));
				bList.add(b);
			}
		}
		
		return bList;
	}
	
	
}

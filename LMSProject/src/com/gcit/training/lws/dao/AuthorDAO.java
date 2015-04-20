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
	
	
	
}

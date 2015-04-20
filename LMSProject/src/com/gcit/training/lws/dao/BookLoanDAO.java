package com.gcit.training.lws.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.gcit.training.lws.domain.Book;

public class BookLoanDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3830611115604413158L;
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library", "root", "Arashi21AMY");
		return conn;
	}
	
	private void updateDuedate(Book b,Date d) throws SQLException{
		Connection conn = getConnection();

		String updateQuery = "update tbl_Book_Loan set dudate = ? where BookId = ?";
		PreparedStatement pstmt = conn.prepareStatement(updateQuery);
		pstmt.setDate(1, d);
		pstmt.setInt(2, b.getBookId());
		pstmt.executeUpdate();
	}
}

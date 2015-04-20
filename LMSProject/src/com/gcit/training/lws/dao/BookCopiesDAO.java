package com.gcit.training.lws.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gcit.training.lws.domain.Book;
import com.gcit.training.lws.domain.LibraryBranch;


public class BookCopiesDAO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7296808086680527223L;

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library", "root", "Arashi21AMY");
		return conn;
	}

	public boolean checkAvaliability(Book b, LibraryBranch lb) throws SQLException {
		Connection conn = getConnection();
		String query = "select noOfCopies from tbl_book_copies where bookId=? and branchId = ?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, b.getBookId());
		pstmt.setInt(2, lb.getBranchId());
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			int bookCopies=rs.getInt("noOfCopies");
			if(bookCopies >= 1){
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
	}
}

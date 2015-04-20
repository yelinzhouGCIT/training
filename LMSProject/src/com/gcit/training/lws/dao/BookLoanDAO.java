package com.gcit.training.lws.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.lws.domain.Book;
import com.gcit.training.lws.domain.LibraryBranch;

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
	
	private List<Book> readBookFromBranch(LibraryBranch branch) throws SQLException{
		Connection coon = getConnection();
		List<Book> bookList = new ArrayList<Book>();
		
		String bookIdQuery = "select bookId from tbl_book_loans where branchId = ?";
		PreparedStatement pstmt = coon.prepareStatement(bookIdQuery);
		pstmt.setInt(1, branch.getBranchId());
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			String bookNameQuery = "select title from tbl_book where bookId = ?";
			PreparedStatement subpstmt = coon.prepareStatement(bookNameQuery);
			pstmt.setInt(1,rs.getInt(1));
			ResultSet subrs = subpstmt.executeQuery();
			while(subrs.next()){
				Book b = new Book();
				b.setBookId(subrs.getInt("bookId"));
				b.setTitle(subrs.getString("title"));
				bookList.add(b);
			}
		}
		
		return bookList;
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

package com.gcit.training.lws.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.lws.domain.Borrower;

public class BorrowerDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7854855521542157339L;

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library", "root", "Arashi21AMY");
		return conn;
	}

	public void addBorrower(Borrower borrower) throws SQLException {
		Connection conn = getConnection();

		String updateQuery = "insert into tbl_Borrower (name,address,phone) values (?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(updateQuery);
		pstmt.setString(1, borrower.getBorrowerName());
		pstmt.setString(2, borrower.getBorrowerAddress());
		pstmt.setString(3, borrower.getBorrowerPhone());
		pstmt.executeUpdate();

	}

	public void updateBorrower(Borrower borrower) throws SQLException {
		Connection conn = getConnection();

		String updateQuery = "update tbl_Borrower set Name = ?,address=?,phone=? where cardNo = ?";
		PreparedStatement pstmt = conn.prepareStatement(updateQuery);
		pstmt.setString(1, borrower.getBorrowerName());
		pstmt.setString(2, borrower.getBorrowerAddress());
		pstmt.setString(3, borrower.getBorrowerPhone());
		pstmt.setInt(4, borrower.getCardNo());
		pstmt.executeUpdate();

	}

	public void removeBorrower(Borrower Borrower) throws SQLException {
		Connection conn = getConnection();

		String removeQuery = "delete from tbl_Borrower where cardNo=?";
		PreparedStatement pstmt = conn.prepareStatement(removeQuery);
		pstmt.setInt(1, Borrower.getCardNo());
		pstmt.executeUpdate();
	}

}

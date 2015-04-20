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
import com.gcit.training.lws.domain.LibraryBranch;

public class LibraryBranchDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8788767940620360188L;
	private Connection getConnection() throws SQLException {
		Connection conn;
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "Arashi21AMY");
		return conn;
	}
	
	public void addLibraryBranch(LibraryBranch libraryBranch) throws SQLException {
		Connection conn = getConnection();

			String updateQuery = "insert into tbl_Library_Branch (BranchName, branchAddress) values (?,?)";
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, libraryBranch.getBranchName());
			pstmt.setString(2,libraryBranch.getBranchAddress());
			pstmt.executeUpdate();

	}
	
	public void updateLibraryBranch(LibraryBranch libraryBranch) throws SQLException {
		Connection conn = getConnection();

			String updateQuery = "update tbl_Library_Branch set BranchName = ?,BranchAddress = ? where BranchId = ?";
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, libraryBranch.getBranchName());
			pstmt.setString(2,libraryBranch.getBranchAddress());

			pstmt.setInt(3, libraryBranch.getBranchId());
			pstmt.executeUpdate();

	}
	
	public void removeLibraryBranch(LibraryBranch libraryBranch) throws SQLException {
		Connection conn = getConnection();

			String removeQuery = "delete from tbl_Library_Branch where BranchId=?";
			PreparedStatement pstmt = conn.prepareStatement(removeQuery);
			pstmt.setInt(1, libraryBranch.getBranchId());
			pstmt.executeUpdate();

	}
	
	public List<LibraryBranch> readAll() throws SQLException {
		String select = "select * from tbl_library_branch";
		PreparedStatement stmt = getConnection().prepareStatement(select);
		ResultSet rs = stmt.executeQuery();
		
		List<LibraryBranch> lbList = new ArrayList<LibraryBranch>();
		while(rs.next()) {
			LibraryBranch lb = new LibraryBranch();
			lb.setBranchId(rs.getInt("branchId"));
			lb.setBranchName(rs.getString("branchName"));
			lb.setBranchAddress(rs.getString("branchAddress"));
			
			lbList.add(lb);
		}
		
		return lbList;
	}
	
}

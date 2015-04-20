package com.gcit.training.lws.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookCopiesDAO implements Serializable{
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
	
	
}

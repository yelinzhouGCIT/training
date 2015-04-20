package com.gcit.training.lws.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenreDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6049517545048229582L;
	private Connection getConnection() throws SQLException {
		Connection conn;
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "Arashi21AMY");
		return conn;
	}
	
	

}

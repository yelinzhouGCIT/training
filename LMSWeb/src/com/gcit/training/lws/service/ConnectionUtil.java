package com.gcit.training.lws.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library", "root", "Arashi21AMY");
		
		conn.setAutoCommit(false);
		
		return conn;
	}
}

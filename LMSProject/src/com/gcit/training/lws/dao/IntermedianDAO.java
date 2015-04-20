package com.gcit.training.lws.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IntermedianDAO {
	
	private Connection getConnection() throws SQLException {
		Connection conn;
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "Arashi21AMY");
		return conn;
	}
	
	private List<IntermedianDAO> getResultList(Object o1, Object o2){
		List<IntermedianDAO> result = new ArrayList<IntermedianDAO>();
		
		return result;
	}
}

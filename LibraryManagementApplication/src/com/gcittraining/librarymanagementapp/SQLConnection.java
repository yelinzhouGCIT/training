package com.gcittraining.librarymanagementapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {
	Connection conn;
	public SQLConnection(){
	try{
		
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library", "root",
				"Arashi21AMY");
		}catch(SQLException e){
			
		}

	}
}

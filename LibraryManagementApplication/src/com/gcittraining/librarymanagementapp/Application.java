package com.gcittraining.librarymanagementapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Application {
	
	
	enum SystemLevel{
		WELCOME,SELECTVISITOR,SELECTFUNCTION
	}
	SystemLevel sl;
	
	private int visitorNum;
	private int functionNum;
	
	public void libraryFunctions(int input) {
		if (input == 1) {

		} else if (input == 2) {
			System.out.println("");
			Administrator admin = new Administrator();
			System.out.println("1)Add/Update/Delete Book and Author \n"
					+ "2)Add/Update/Delete Publishers \n"
					+ "3)Add/Update/Delete Library Branches\n"
					+ "4)Add/Update/Delete Borrowers\n" + ""
					+ " 5)Over-ride Due Date for a Book Loan"
					+" 6)Quite to previous");


		} else if (input == 3) {

		} else {
			System.out.println("Wrong input");
		}
	}
	public void libraryVisitor(){
		System.out
				.println("Welcome to the GCIT Library Management System. Which category of a user  are you?\n"
						+ "1)Librarian\n"
						+ "2)Administrator\n"
						+ "3)Borrower");
		
	}

	public static void main(String args[]) {
		boolean appStart = true;
		Scanner s = new Scanner(System.in);
		Application app = new Application();
		app.sl = SystemLevel.WELCOME;
		
		while(appStart){
			switch(app.sl){
			case WELCOME:
				app.libraryVisitor();
				int visitor = s.nextInt();
				app.visitorNum = visitor;
				app.sl = SystemLevel.SELECTVISITOR;
				break;
			case SELECTVISITOR:
				
				break;
			case SELECTFUNCTION:
				break;
			}
			
		}

			

			app.libraryFunctions(input);

			// String updateQuery =
			// "update tbl_author set authorName = ? where authorId = ?";
			// PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			//
			// pstmt.setString(1, "oeoeoeo");
			// pstmt.setInt(2, 2);
			// pstmt.executeUpdate();

	}
}

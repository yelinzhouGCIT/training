package com.gcittraining.librarymanagementapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class Administrator {
	private Book b;
	private Author a;
	
	public SQLConnection conn = new SQLConnection();

	public Administrator() {
	}

	public void command(int command) {
		if (command == 1) {
			System.out.println("");
		} else if (command == 2) {

		} else if (command == 3) {

		} else if (command == 4) {

		} else if (command == 5) {

		} else {
			System.out.println("Invaild input");
		}
	}

	public void addBook(Book b, Author a) throws SQLException{
		PreparedStatement stmt = (PreparedStatement) conn.conn
				.prepareStatement("insert into tbl_book_authors(bookId,authorId) values(?,?)");

		stmt.setInt(1, b.getBookId());
		stmt.setInt(2, a.getAuthorId());
		stmt.execute();
	}

	public void deleteBook() {

	}

	public void updateBook() {

	}

}

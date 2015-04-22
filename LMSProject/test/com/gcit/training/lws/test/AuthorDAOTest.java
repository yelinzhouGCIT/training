package com.gcit.training.lws.test;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.gcit.training.lws.dao.AuthorDAO;
import com.gcit.training.lws.domain.Author;

public class AuthorDAOTest {

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library", "root", "");
		
		conn.setAutoCommit(false);
		
		return conn;
	}

	@Test
	public void testAddAuthor() throws SQLException {
		Author a = new Author();
		Connection conn = getConnection();
		a.setAuthorName("Testddfvnsdfnskdjfnskjdfnksjnfksdnfksdnfksjdnfksjdnfkjdsnfkjsdnfkjsdnfkjsnfkjsndfkjsndfkjsndfkjsdfkjsdbfjksdfnkjsdnfkjsdn");
		try {
			new AuthorDAO(conn).addAuthor(a);
			conn.commit();
		} catch(Exception e) {
			conn.rollback();
			fail(e.getMessage());
		}
	}

	@Test
	public void testUpdateAuthor() {
		//fail("Not yet implemented");
	}

	@Test
	public void testRemoveAuthor() {
		//fail("Not yet implemented");
	}

	@Test
	public void testReadAll() {
		try {			
			List<Author> authors = new AuthorDAO(getConnection()).readAll();
			
			for(Author a : authors) {
				System.out.println(a.getAuthorId() + " : " + a.getAuthorName());
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//fail("Not yet implemented");
	}
}

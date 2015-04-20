package com.gcit.training.lws.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gcit.training.lws.dao.AuthorDAO;
import com.gcit.training.lws.domain.Author;

public class AuthorDAOTest {

	@Test
	public void testAddAuthor() {
		Author a = new Author();
		a.setAuthorName("Testddfvnsdfnskdjfnskjdfnksjnfksdnfksdnfksjdnfksjdnfkjdsnfkjsdnfkjsdnfkjsnfkjsndfkjsndfkjsndfkjsdfkjsdbfjksdfnkjsdnfkjsdn");
		try {
			new AuthorDAO().addAuthor(a);
		} catch(Exception e) {
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

}

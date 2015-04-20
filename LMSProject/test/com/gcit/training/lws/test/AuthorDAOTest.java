package com.gcit.training.lws.test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.gcit.training.lws.dao.AuthorDAO;
import com.gcit.training.lws.domain.Author;

public class AuthorDAOTest {

	@Test
	public void testAddAuthor() {
		Author a = new Author();
		a.setAuthorName("dashabi");
		try {
			new AuthorDAO().addAuthor(a);
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testUpdateAuthor() {
		Author a = new Author();
		a.setAuthorName("shabi1");
		a.setAuthorId(1);
		try{
			new AuthorDAO().updateAuthor(a);
		}catch(Exception e){
			fail(e.getMessage());
		}
	}

	@Test
	public void testRemoveAuthor() {
		Author a = new Author();
		a.setAuthorId(7);
		try{
			new AuthorDAO().removeAuthor(a);
		}catch(Exception e){
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testReadAll(){
		try{
			new AuthorDAO().readAll();
		}catch(Exception e){
			fail(e.getMessage());
		}
	}
	

}

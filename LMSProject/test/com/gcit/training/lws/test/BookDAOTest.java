package com.gcit.training.lws.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.gcit.training.lws.dao.BookDAO;
import com.gcit.training.lws.domain.Book;

public class BookDAOTest {

	@Test
	public void testAddBook() {
		Book b = new Book();
		b.setTitle("yoyoyoyoyo");
		try {
			new BookDAO().addBook(b);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testUpdateBook() {
		Book b = new Book();
		b.setBookId(1);
		b.setTitle("hahahahahah");
		try {
			new BookDAO().updateBook(b);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testRemoveBook() {
		Book b = new Book();
		b.setBookId(2);
		try {
			new BookDAO().removeBook(b);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}

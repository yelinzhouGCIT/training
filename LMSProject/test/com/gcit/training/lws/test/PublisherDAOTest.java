package com.gcit.training.lws.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.gcit.training.lws.dao.PublisherDAO;
import com.gcit.training.lws.domain.Publisher;

public class PublisherDAOTest {

	@Test
	public void testAddPublisher() {
		Publisher p = new Publisher();
		p.setName("Test Name");
		p.setAddress("Test Address");
		p.setPhoneNumber("testnum");
		try {
			new PublisherDAO().addPublisher(p);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testUpdatePublisher() {
		Publisher p = new Publisher();
		p.setName("updateTest Name");
		p.setAddress("updateTest Address");
		p.setPhoneNumber("updatetestnum");
		p.setId(2);
		try {
			new PublisherDAO().updatePublisher(p);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testRemovePublisher() {
		Publisher p = new Publisher();
		p.setId(3);
		try {
			new PublisherDAO().removePublisher(p);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testReadAll() {
		try{
			new PublisherDAO().readAll();
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}

}

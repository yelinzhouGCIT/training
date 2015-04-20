package com.gcit.training.lws.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gcit.training.lws.dao.BorrowerDAO;
import com.gcit.training.lws.domain.Borrower;

public class BorrowerDAOTest {

	@Test
	public void testAddBorrower() {
		Borrower borrower = new Borrower();
		borrower.setBorrowerAddress("Test Address");
		borrower.setBorrowerName("Test Name");
		borrower.setBorrowerPhone("9992223314");
		try {
			new BorrowerDAO().addBorrower(borrower);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testUpdateBorrower() {
		Borrower borrower = new Borrower();
		borrower.setBorrowerAddress("updateTest Address");
		borrower.setBorrowerName("updateTest Name");
		borrower.setBorrowerPhone("000000");
		borrower.setCardNo(1);
		try{
			new BorrowerDAO().updateBorrower(borrower);
		}catch(Exception e){
			fail(e.getMessage());
		}
	}

	@Test
	public void testRemoveBorrower() {
		Borrower b = new Borrower();
		b.setCardNo(2);
		try{
			new BorrowerDAO().removeBorrower(b);
		}catch(Exception e){
			fail(e.getMessage());
		}
	}

}

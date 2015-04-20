package com.gcit.training.lws.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.gcit.training.lws.dao.LibraryBranchDAO;
import com.gcit.training.lws.domain.LibraryBranch;

public class LibraryBranchDAOTest {

	@Test
	public void testAddLibraryBranch() {
		LibraryBranch lb = new LibraryBranch();
		lb.setBranchName("Test Branch Name");
		lb.setBranchAddress("Test Address");
		try {
			new LibraryBranchDAO().addLibraryBranch(lb);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testUpdateLibraryBranch() {
		LibraryBranch lb = new LibraryBranch();
		lb.setBranchName("updateTest Branch Name");
		lb.setBranchAddress("updateTest Address");
		lb.setBranchId(4);
		try {
			new LibraryBranchDAO().updateLibraryBranch(lb);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testRemoveLibraryBranch() {
		LibraryBranch lb = new LibraryBranch();
		lb.setBranchId(2);
		try {
			new LibraryBranchDAO().removeLibraryBranch(lb);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testReadAll() {
		try {
			new LibraryBranchDAO().readAll();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}

package com.gcit.training.lws.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.lws.domain.Book;
import com.gcit.training.lws.domain.BookLoan;
import com.gcit.training.lws.domain.Borrower;
import com.gcit.training.lws.domain.LibraryBranch;

public class BookLoanDAO extends BaseDAO<BookLoan> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6448901907034547074L;

	public BookLoanDAO(Connection conn) {
		super(conn);
	}

	public void addLoan(BookLoan bookLoan) throws SQLException {

		save("insert into tbl_book_loans set bookId = ?, branchId = ?, cardNo = ?, dateOut = ?, dueDate = ?",
				new Object[] { bookLoan.getBook().getBookId(),
						bookLoan.getLibraryBranch().getBranchId(),
						bookLoan.getBorrower().getCardNo(),
						bookLoan.getDateOut(), bookLoan.getDateDue() });

	}

	public void updateLoan(BookLoan bookLoan) throws SQLException {
		save("update tbl_book_loans set dueDate = ? where bookId = ? and branchId = ? and cardNo = ?",
				new Object[] { bookLoan.getDateDue(),
						bookLoan.getBook().getBookId(),
						bookLoan.getLibraryBranch(),
						bookLoan.getBorrower().getCardNo() });

	}

	public void removeLoan(BookLoan bookLoan) throws SQLException {
		save("delete from tbl_book_loans where bookId = ? and branchId = ? and cardNo = ?",
				new Object[] { bookLoan.getBook().getBookId(),
						bookLoan.getLibraryBranch().getBranchId(),
						bookLoan.getBorrower().getCardNo() });
	}

	public List<BookLoan> readAll() throws SQLException {
		@SuppressWarnings("unchecked")
		List<BookLoan> blList = (List<BookLoan>) read(
				"select * from tbl_book_loans", null);
		return blList;
	}

	public BookLoan readOne(int bookId, int branchId, int cardNo)
			throws SQLException {
		@SuppressWarnings("unchecked")
		List<BookLoan> blList = (List<BookLoan>) read(
				"select * from tbl_book_loans where bookId = ? and branchId = ? and cardNo = ?",
				new Object[] { bookId, branchId, cardNo });
		if (blList != null && blList.size() > 0) {
			return blList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<BookLoan> mapResults(ResultSet rs) throws SQLException {
		List<BookLoan> bookLoanList = new ArrayList<BookLoan>();
		BookDAO bkDAO = new BookDAO(conn);
		BorrowerDAO borrDAO = new BorrowerDAO(conn);
		LibraryBranchDAO lbDAO = new LibraryBranchDAO(conn);
		while (rs.next()) {
			BookLoan bl = new BookLoan();
			bl.setDateOut(rs.getDate("dateOut"));
			bl.setDateDue(rs.getDate("dueDate"));

			Book book = bkDAO.readOne(rs.getInt("bookId"));
			Borrower borrower = borrDAO.readOne(rs.getInt("cardNo"));
			LibraryBranch lb = lbDAO.readOne(rs.getInt("branchId"));

			bl.setBook(book);
			bl.setBorrower(borrower);
			bl.setLibraryBranch(lb);

			bookLoanList.add(bl);
		}
		return bookLoanList;
	}

	@Override
	public List<?> mapResultsFirstLevel(ResultSet rs) throws SQLException {

		return null;
	}

}
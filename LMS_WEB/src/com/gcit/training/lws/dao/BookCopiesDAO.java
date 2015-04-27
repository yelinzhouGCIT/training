package com.gcit.training.lws.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.lws.domain.Book;
import com.gcit.training.lws.domain.BookCopies;
import com.gcit.training.lws.domain.LibraryBranch;

public class BookCopiesDAO extends BaseDAO<BookCopies> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6124740083561987562L;
	public BookCopiesDAO(Connection conn)
	{
		super(conn);
	}
	
	public void addBookCopy(BookCopies bc) throws SQLException {

		save("insert into tbl_book_copies set bookId = ?, branchId = ?, noOfCopies = ?",
				new Object[] { bc.getBook().getBookId(), bc.getLb().getBranchId(),
						bc.getNoOfCopies() });

	}

	public void updateBookCopy(BookCopies bc) throws SQLException {
		save("update tbl_book_copies set noOfCopies = ? where bookId = ? and branchId = ?",
				new Object[] { bc.getNoOfCopies(), bc.getBook().getBookId(),
						bc.getLb().getBranchId() });

	}

	public void removeBookCopy(BookCopies bc) throws SQLException {
		save("delete from tbl_book_copies where bookId = ? and branchId = ?",
				new Object[] { bc.getBook().getBookId(),
						bc.getLb().getBranchId() });
	}

	public List<BookCopies> readAll() throws SQLException {
		@SuppressWarnings("unchecked")
		List<BookCopies> blList = (List<BookCopies>) read("select * from tbl_book_copies",null);
		return blList;
	}

	public BookCopies readOne(BookCopies copy) throws SQLException {
		@SuppressWarnings("unchecked")
		List<BookCopies> blList = (List<BookCopies>) read(
				"select * from tbl_book_copies where bookId = ? and branchId = ?",
				new Object[] { copy.getBook().getBookId(), copy.getLb().getBranchId() });
		if (blList != null && blList.size() > 0) {
			return blList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<BookCopies> mapResults(ResultSet rs) throws SQLException {
		List<BookCopies> bcList = new ArrayList<BookCopies>();
		BookDAO bDAO = new BookDAO(conn);
		LibraryBranchDAO lbDAO = new LibraryBranchDAO(conn);

		while (rs.next()) {
			BookCopies bc = new BookCopies();
			Book bk = bDAO.readOne(rs.getInt("bookId"));

			LibraryBranch lb = lbDAO.readOne(rs.getInt("branchId"));
			bc.setNoOfCopies(rs.getInt("noOfCopies"));
			bc.setBook(bk);
			bc.setLb(lb);

			bcList.add(bc);
		}

		return bcList;
	}
	@Override
	public List<?> mapResultsFirstLevel(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}

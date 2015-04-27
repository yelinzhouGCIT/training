package com.gcit.training.lws.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.lws.domain.Author;
import com.gcit.training.lws.domain.Book;
import com.gcit.training.lws.domain.Genre;

public class BookDAO extends BaseDAO<Book> implements Serializable {

	public BookDAO(Connection conn) {
		super(conn);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1619700647002508164L;

	@SuppressWarnings("unchecked")
	public void addBook(Book book) throws SQLException {
		int bookId;
		if (book.getPublisher() == null) {
			bookId = saveWithId(
					"insert into tbl_book (title, pubId) values (?,?)",
					new Object[] { book.getTitle(), null });
		} else {
			bookId = saveWithId(
					"insert into tbl_book (title, pubId) values (?,?)",
					new Object[] { book.getTitle(), book.getPublisher().getId() });
		}

		if (book.getGenres() != null && book.getGenres().size() > 0) {
			for (Genre g : book.getGenres()) {
				save("insert into tbl_book_genres(bookId,genre_id) values(?,?)",
						new Object[] { bookId, g.getGenreId() });
			}
		}

		if (book.getAuthors() != null && book.getAuthors().size() > 0) {
			for (Author a : book.getAuthors()) {
				save("insert into tbl_book_authors (bookId, authorId) values (?,?)",
						new Object[] { bookId, a.getAuthorId() });
			}
		}

	}

	public void update(Book book) throws SQLException {
		save("update tbl_book set title = ? where bookId = ?", new Object[] {
				book.getTitle(), book.getBookId() });
		if (book.getPublisher() != null) {
			save("update tbl_book set pubId = ? where bookId = ?",
					new Object[] { book.getPublisher().getId(),
							book.getBookId() });
		} else {
			save("update tbl_book set pubId = ? where bookId = ?",
					new Object[] { null, book.getBookId() });
		}
	}

	public void removeBook(Book book) throws SQLException {
		save("delete from tbl_book where bookId = ?",
				new Object[] { book.getBookId() });
	}

	@SuppressWarnings("unchecked")
	public List<Book> readAll() throws SQLException {
		return (List<Book>) read("select * from tbl_book", null);
	}

	public Book readOne(int bookId) throws SQLException {

		@SuppressWarnings("unchecked")
		List<Book> bookList = (List<Book>) read(
				"select * from tbl_book where bookId = ?",
				new Object[] { bookId });
		if (bookList != null && bookList.size() > 0) {
			return bookList.get(0);
		} else {
			return null;
		}
	}

	@Override
	protected List<Book> mapResults(ResultSet rs) throws SQLException {
		List<Book> books = new ArrayList<Book>();
		PublisherDAO pDAO = new PublisherDAO(conn);
		AuthorDAO aDAO = new AuthorDAO(conn);

		while (rs.next()) {
			Book b = new Book();
			b.setBookId(rs.getInt("bookId"));
			b.setTitle(rs.getString("title"));
			b.setPublisher(pDAO.readOne(rs.getInt("pubId")));

			@SuppressWarnings("unchecked")
			List<Author> authors = (List<Author>) aDAO
					.readFirstLevel(
							"select * from tbl_author where authorId in "
									+ "(select authorId from tbl_book_authors where bookId = ?)",
							new Object[] { b.getBookId() });
			b.setAuthors(authors);

			books.add(b);
		}
		return books;
	}

	@Override
	protected List<Book> mapResultsFirstLevel(ResultSet rs) throws SQLException {
		List<Book> books = new ArrayList<Book>();
		PublisherDAO pDAO = new PublisherDAO(conn);
		AuthorDAO aDAO = new AuthorDAO(conn);

		while (rs.next()) {
			Book b = new Book();
			b.setBookId(rs.getInt("bookId"));
			b.setTitle(rs.getString("title"));
			b.setPublisher(pDAO.readOne(rs.getInt("pubId")));

			books.add(b);
		}
		return books;
	}

	@SuppressWarnings("unchecked")
	public List<Book> getBooksByName(String name) throws SQLException {
		return (List<Book>) read("select * from tbl_book where title like ?",
				new Object[] { name });
	}
}

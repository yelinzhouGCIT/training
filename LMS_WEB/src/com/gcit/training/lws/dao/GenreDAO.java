package com.gcit.training.lws.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.lws.domain.Book;
import com.gcit.training.lws.domain.Genre;

public class GenreDAO extends BaseDAO<Genre> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2758656534926752003L;

	public GenreDAO(Connection conn) {
		super(conn);
	}

	public void addGenre(Genre genre) throws SQLException {
		System.out.println("55666");
		save("insert into tbl_genre (genre_name) values (?)",
				new Object[] { genre.getName() });
	}

	public void updateGenre(Genre genre) throws SQLException {
		save("update tbl_genre set genre_name = ? where genre_id = ?",
				new Object[] { genre.getName(), genre.getGenreId() });
	}

	public void removeGenre(Genre genre) throws SQLException {
		save("delete from tbl_genre where genre_id = ?",
				new Object[] { genre.getGenreId() });
	}

	@SuppressWarnings("unchecked")
	public List<Genre> readAll() throws SQLException {
		return (List<Genre>) read("select * from tbl_genre", null);
	}

	public Genre readOne(int genre_Id) throws SQLException {
		@SuppressWarnings("unchecked")
		List<Genre> gList = (List<Genre>) read(
				"select * from tbl_genre where genre_Id = ?",
				new Object[] { genre_Id });

		if (gList != null && gList.size() > 0) {
			return gList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Genre> mapResults(ResultSet rs) throws SQLException {

		List<Genre> gList = new ArrayList<Genre>();
		BookDAO bkDAO = new BookDAO(conn);

		while (rs.next()) {
			Genre genre = new Genre();
			genre.setGenreId(rs.getInt("genre_id"));
			genre.setName(rs.getString("genre_name"));

			@SuppressWarnings("unchecked")
			List<Book> bList = (List<Book>) bkDAO
					.readFirstLevel(
							"select * from tbl_book where bookId in (select bookId from tbl_book_genres where genre_Id = ?)",
							new Object[] { genre.getGenreId() });

			genre.setBooks(bList);

			gList.add(genre);

		}
		return gList;
	}

	@Override
	public List<Genre> mapResultsFirstLevel(ResultSet rs) throws SQLException {
		List<Genre> gList = new ArrayList<Genre>();
		while (rs.next()) {
			Genre genre = new Genre();
			genre.setGenreId(rs.getInt("genre_id"));
			genre.setName(rs.getString("genre_name"));
			gList.add(genre);
		}
		return gList;
	}
	@SuppressWarnings("unchecked")
	public List<Genre> getGenreByName(String g) throws SQLException{
		return (List<Genre>) read("select * from tbl_Genre where genre_name like ?", new Object[] {g});
	}
}
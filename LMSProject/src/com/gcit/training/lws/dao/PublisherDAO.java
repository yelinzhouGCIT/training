package com.gcit.training.lws.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.lws.domain.Book;
import com.gcit.training.lws.domain.Publisher;

public class PublisherDAO extends BaseDAO<Publisher> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2565046849259958348L;

	public PublisherDAO(Connection conn) {
		super(conn);
	}

	public void addPublisher(Publisher publisher) throws SQLException {
		save("insert into tbl_publisher (publisherName, publisherAddress, publisherPhone) values (?,?,?)",
				new Object[] { publisher.getName(), publisher.getAddress(),
						publisher.getPhoneNumber() });
	}

	public void updatePublisher(Publisher publisher) throws SQLException {
		save("update tbl_publisher set publisherName = ?, publisherAddress = ?, publisherPhone = ? where publisherId = ?",
				new Object[] { publisher.getName(), publisher.getAddress(),
						publisher.getPhoneNumber(), publisher.getId() });
	}

	public void removePublisher(Publisher publisher) throws SQLException {
		save("delete from tbl_publisher where publisherId = ?",
				new Object[] { publisher.getId() });
	}

	@SuppressWarnings("unchecked")
	public List<Publisher> readAll() throws SQLException {
		return (List<Publisher>) read("select * from tbl_publisher", null);
	}

	public Publisher readOne(int publisherId) throws SQLException {
		@SuppressWarnings("unchecked")
		List<Publisher> pList = (List<Publisher>) read(
				"select * from tbl_publisher where publisherId = ?",
				new Object[] { publisherId });

		if (pList != null && pList.size() > 0) {
			return pList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Publisher> mapResults(ResultSet rs) throws SQLException {
		List<Publisher> pList = new ArrayList<Publisher>();
		BookDAO bkDAO = new BookDAO(conn);
		while (rs.next()) {
			Publisher pb = new Publisher();
			pb.setId(rs.getInt("publisherId"));
			pb.setName(rs.getString("publisherName"));
			pb.setAddress(rs.getString("publisherAddress"));
			pb.setPhoneNumber(rs.getString("publisherPhone"));

			@SuppressWarnings("unchecked")
			List<Book> bList = (List<Book>) bkDAO.readFirstLevel(
					"select * from tbl_book where pubId = ?",
					new Object[] { pb.getId() });

			pb.setBooks(bList);
			pList.add(pb);
		}
		return pList;
	}

	@Override
	public List<Publisher> mapResultsFirstLevel(ResultSet rs)
			throws SQLException {
		List<Publisher> pList = new ArrayList<Publisher>();
		while (rs.next()) {
			Publisher pb = new Publisher();
			pb.setId(rs.getInt("publisherId"));
			pb.setName(rs.getString("publisherName"));

			pList.add(pb);

		}
		return pList;
	}

}
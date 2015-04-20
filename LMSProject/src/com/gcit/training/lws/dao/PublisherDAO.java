package com.gcit.training.lws.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.lws.domain.Publisher;

public class PublisherDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7992239181727138352L;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "Arashi21AMY");
		return conn;
	}
	
	public void addPublisher(Publisher publisher) throws SQLException {
		Connection conn = getConnection();

			String updateQuery = "insert into tbl_Publisher (publisherName, publisherAddress, publisherPhone) values (?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, publisher.getName());
			pstmt.setString(2,publisher.getAddress());
			pstmt.setString(3, publisher.getPhoneNumber());
			pstmt.executeUpdate();

	}
	
	public void updatePublisher(Publisher publisher) throws SQLException {
		Connection conn = getConnection();

			String updateQuery = "update tbl_Publisher set PublisherName = ?,publisherAddress = ?, publisherPhone = ? where PublisherId = ?";
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, publisher.getName());
			pstmt.setString(2,publisher.getAddress());
			pstmt.setString(3, publisher.getPhoneNumber());
			pstmt.setInt(4, publisher.getId());
			pstmt.executeUpdate();

	}
	
	public void removePublisher(Publisher publisher) throws SQLException {
		Connection conn = getConnection();

			String removeQuery = "delete from tbl_Publisher where PublisherId=?";
			PreparedStatement pstmt = conn.prepareStatement(removeQuery);
			pstmt.setInt(1, publisher.getId());
			pstmt.executeUpdate();

	}
	
	public List<Publisher> readAll() throws SQLException {
		String select = "select * from tbl_Publisher";
		PreparedStatement stmt = getConnection().prepareStatement(select);
		ResultSet rs = stmt.executeQuery();
		
		List<Publisher> publishers = new ArrayList<Publisher>();
		while(rs.next()) {
			Publisher p = new Publisher();
			p.setId(rs.getInt("PublisherId"));
			p.setName(rs.getString("PublisherName"));
			p.setAddress(rs.getString("PublisherAddress"));
			p.setPhoneNumber(rs.getString("PublisherPhone"));
			publishers.add(p);
		}
		
		return publishers;
	}
}

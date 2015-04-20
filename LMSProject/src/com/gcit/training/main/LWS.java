package com.gcit.training.main;

import java.sql.SQLException;

import com.gcit.training.lws.dao.AuthorDAO;
import com.gcit.training.lws.domain.Author;

public class LWS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Author author = new Author();
		author.setAuthorName("New Name");
		AuthorDAO authorDao = new AuthorDAO();
		try {
			authorDao.addAuthor(author);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		author.setAuthorId(3);
		try {
			authorDao.updateAuthor(author);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}

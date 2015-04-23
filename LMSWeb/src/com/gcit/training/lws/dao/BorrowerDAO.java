package com.gcit.training.lws.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.lws.domain.Borrower;

public class BorrowerDAO extends BaseDAO<Borrower> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8472440725720701828L;

	public BorrowerDAO(Connection conn) {
		super(conn);
	}

	public void addBorrower(Borrower b) throws SQLException {
		save("Insert into tbl_borrower(name, address, phone) values(?,?,?)",
				new Object[] { b.getBorrowerName(), b.getBorrowerAddress(),
						b.getBorrowerPhone() });
	}

	public void updateBorrower(Borrower b) throws SQLException {
		save("update tbl_borrower set name = ?, address = ?, phone = ? where cardNo = ? ",
				new Object[] { b.getBorrowerName(), b.getBorrowerAddress(),
						b.getBorrowerPhone(), b.getCardNo() });

	}
	
	public void removeBorrower(Borrower b) throws SQLException{
		save("delete from tbl_borrower where cardNo = ?",new Object[]{b.getCardNo()});
	}
	
	public Borrower readOne(int cardNo) throws SQLException
	{
		@SuppressWarnings("unchecked")
		List<Borrower> borrowerList = (List<Borrower>) read("select * from tbl_borrower where cardNo = ?", new Object[]{cardNo});
		if(borrowerList != null && borrowerList.size()>0)
		{
			return borrowerList.get(0);
		}
		else
		{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Borrower> readAll() throws SQLException
	{
		return (List<Borrower>) read("select * from tbl_borrower",null);
	}
	@Override
	public List<Borrower> mapResults(ResultSet rs) throws SQLException {
		List<Borrower> bList = new ArrayList<Borrower>();
		while (rs.next()) {
			Borrower b = new Borrower();
			b.setCardNo(rs.getInt("cardNo"));
			b.setBorrowerName(rs.getString("name"));
			b.setBorrowerAddress(rs.getString("address"));
			b.setBorrowerPhone(rs.getString("phone"));

			bList.add(b);
		}

		return bList;
	}

	@Override
	public List<?> mapResultsFirstLevel(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
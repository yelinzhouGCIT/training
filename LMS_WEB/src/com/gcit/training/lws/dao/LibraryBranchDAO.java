package com.gcit.training.lws.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.lws.domain.LibraryBranch;

public class LibraryBranchDAO extends BaseDAO<LibraryBranch> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5632016576745968314L;

	public LibraryBranchDAO(Connection conn) {
		super(conn);
	}

	public void addLibraryBranch(LibraryBranch b) throws SQLException {
		save("Insert into tbl_library_branch(branchName, branchAddress) values(?,?)",
				new Object[] { b.getBranchName(),b.getBranchAddress() });
	}

	public void updateLibraryBranch(LibraryBranch b) throws SQLException {
		save("update tbl_library_branch set branchName = ?, branchAddress = ? where branchId = ? ",
				new Object[] { b.getBranchName(),b.getBranchAddress(),b.getBranchId() });

	}

	public void removeLibraryBranch(LibraryBranch b) throws SQLException {
		save("delete from tbl_library_branch where branchId = ?",
				new Object[] { b.getBranchId() });
	}

	@SuppressWarnings("unchecked")
	public List<LibraryBranch> readAll() throws SQLException {
		return (List<LibraryBranch>) read("select * from tbl_library_branch",null);
	}
	
	public LibraryBranch readOne(int branchId) throws SQLException {
		@SuppressWarnings("unchecked")
		List<LibraryBranch> branchList = (List<LibraryBranch>) read(
				"select * from tbl_library_branch where branchId = ?",
				new Object[] { branchId });
		if (branchList != null && branchList.size() > 0) {
			return branchList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<LibraryBranch> mapResults(ResultSet rs) throws SQLException {
		List<LibraryBranch> lbList = new ArrayList<LibraryBranch>();
		while (rs.next()) {
			LibraryBranch lb = new LibraryBranch();
			lb.setBranchName(rs.getString("branchName"));
			lb.setBranchAddress(rs.getString("branchAddress"));
			lb.setBranchId(rs.getInt("branchId"));
			lbList.add(lb);
		}

		return lbList;
	}

	@Override
	public List<?> mapResultsFirstLevel(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
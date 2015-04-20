package com.gcit.training.lws.domain;

import java.io.Serializable;

public class BookCopies implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2059183811413196621L;
	private int noOfCopies;
	private Book book;
	private LibraryBranch lb;
	
	public int getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public LibraryBranch getLb() {
		return lb;
	}
	public void setLb(LibraryBranch lb) {
		this.lb = lb;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((lb == null) ? 0 : lb.hashCode());
		result = prime * result + noOfCopies;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookCopies other = (BookCopies) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (lb == null) {
			if (other.lb != null)
				return false;
		} else if (!lb.equals(other.lb))
			return false;
		if (noOfCopies != other.noOfCopies)
			return false;
		return true;
	}
	

}

package com.gcittraining.librarymanagementapp;

public class Publisher {
	public Publisher(int pId, String pName,
			String address, String phone) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.address = address;
		this.phone = phone;
	}

	private int pId;
	private String pName;
	private String address;
	private String phone;

	public int getPublisherId() {
		return pId;
	}

	public void setPublisherId(int publisherId) {
		this.pId = publisherId;
	}

	public String getPublisherName() {
		return pName;
	}

	public void setPublisherName(String publisherName) {
		this.pName = publisherName;
	}

	public String getPublisherAddress() {
		return address;
	}

	public void setPublisherAddress(String publisherAddress) {
		this.address = publisherAddress;
	}

	public String getPublisherPhone() {
		return phone;
	}

	public void setPublisherPhone(String publisherPhone) {
		this.phone = publisherPhone;
	}
}

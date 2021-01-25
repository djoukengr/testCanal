package com.testcanal.pojo;

public class UpdateRequestInput {

	private String idSubscriber;
	private String newAddress;
	public UpdateRequestInput(String idSubscriber, String newAddress) {
		super();
		this.idSubscriber = idSubscriber;
		this.newAddress = newAddress;
	}
	public String getIdSubscriber() {
		return idSubscriber;
	}
	public void setIdSubscriber(String idSubscriber) {
		this.idSubscriber = idSubscriber;
	}
	public String getNewAddress() {
		return newAddress;
	}
	public void setNewAddress(String newAddress) {
		this.newAddress = newAddress;
	}
	
	
}

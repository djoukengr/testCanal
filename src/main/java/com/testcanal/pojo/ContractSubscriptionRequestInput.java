package com.testcanal.pojo;

public class ContractSubscriptionRequestInput {
private String idSubscriber;
private String contractAddress;
public ContractSubscriptionRequestInput(String idSubscriber, String contractAddress) {
	super();
	this.idSubscriber = idSubscriber;
	this.contractAddress = contractAddress;
}
public String getIdSubscriber() {
	return idSubscriber;
}
public void setIdSubscriber(String idSubscriber) {
	this.idSubscriber = idSubscriber;
}
public String getContractAddress() {
	return contractAddress;
}
public void setContractAddress(String contractAddress) {
	this.contractAddress = contractAddress;
}

}

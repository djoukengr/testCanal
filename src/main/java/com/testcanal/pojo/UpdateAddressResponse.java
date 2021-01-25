package com.testcanal.pojo;

public class UpdateAddressResponse {
private String modificationId;
private String contractId;
public UpdateAddressResponse(String modificationId, String contractId) {
	this.modificationId = modificationId;
	this.contractId = contractId;
}
public String getModificationId() {
	return modificationId;
}
public void setModificationId(String modificationId) {
	this.modificationId = modificationId;
}
public String getContractId() {
	return contractId;
}
public void setContractId(String contractId) {
	this.contractId = contractId;
}

}

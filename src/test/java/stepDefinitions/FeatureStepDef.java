package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import   org.testng.Assert;

import java.util.ArrayList;

import helper.ApiCaller;



public class FeatureStepDef {
	private String subscriber_id;
	private String address;
	private ArrayList<String> subscribedContracts= new ArrayList<String>();
	private ArrayList<String[]> modifications_id_list;
	private String newAddress;
	private int numberofcontracts;
	@Given("subscriber {string} {string} is created with {string} in {string}")
	public void subscriber_is_created_with_in(String nom, String prenom, String address, String country) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		this.address =address;
		subscriber_id = ApiCaller.createSubscriber(nom,prenom,address,country );
		System.out.println("subscriber ID: "+subscriber_id);
	}

	@Given("having {string} contracts")
	public void having_contracts(String numberof) {
		numberofcontracts=Integer.parseInt(numberof);
	   for(int i=0; i<numberofcontracts; i++) {
		  subscribedContracts.add(ApiCaller.SubscribeToContract(subscriber_id, address));
	   }
	   for( String contrat: subscribedContracts) {
		   System.out.println("contractID: "+ contrat);
	   }
	}

	@When("subscriber address changes to {string}")
	public void subscriber_address_changes_to(String newAddress) {
	    this.newAddress= newAddress;
	     modifications_id_list= ApiCaller.updateSubscriberAddress(subscriber_id, newAddress);
	     System.out.println(modifications_id_list.toString());
	}

	@Then("check that all subscriber's contract address has changed to {string}")
	public void check_that_all_subscriber_s_contract_address_has_changed_to(String string) {
	   for(String contractId : subscribedContracts ){
		   String contractAddress = ApiCaller.getContractAddress(contractId);
		   Assert.assertEquals(contractAddress, newAddress);
		  
	   }
	}
	@Then("check that only the first subscriber's contract address has changed to {string}")
	public void check_that_only_the_first_subscriber_s_contract_address_has_changed_to(String string) {
	   for(int i=0;i<subscribedContracts.size();i++) {
		   String contractId = subscribedContracts.get(i);
		   if(i==0)
			   Assert.assertEquals(ApiCaller.getContractAddress(contractId), newAddress);
		   else
			   Assert.assertEquals(ApiCaller.getContractAddress(contractId), address);
	   }
	}

	@Then("check that new history entry is created with {string}")
	public void check_that_new_history_entry_is_created_with(String string) {
		//Assert.assertEquals(modifications_id_list.size(), numberofcontracts);
		
	    for(String[] modification : modifications_id_list) {
	    	ArrayList<String> mouvement = ApiCaller.getMouvementHistory(modification[0]);
	    	Assert.assertEquals(mouvement.get(1), subscriber_id);
	    	Assert.assertEquals(mouvement.get(2), modification[1]);
	    	Assert.assertEquals(mouvement.get(3), "Update Address");
	    	//Assert.assertEquals(mouvement.get(4), "date_modification");
	    	Assert.assertEquals(mouvement.get(5), newAddress);
	    	Assert.assertEquals(mouvement.get(6),address);
	    }
	}

}

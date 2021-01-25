package com.testcanal.rest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.testcanal.entities.Contract;
import com.testcanal.entities.History;
import com.testcanal.entities.Subscriber;
import com.testcanal.pojo.ContractSubscriptionRequestInput;
import com.testcanal.repository.ContractRepository;
import com.testcanal.repository.SubscriberRepository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(path = "/contract")
public class ContractController {
	
	@Autowired
	private SubscriberRepository repository;
	
	@Autowired
	private ContractRepository contractRepo;
	
	@PostMapping(path = "/subscription", consumes = "application/json", produces = "application/json")
	 public String contractSubscription(@RequestBody ContractSubscriptionRequestInput requestInput	) {
	  String contractId = "";
	 if(repository.findById(requestInput.getIdSubscriber()).isPresent()){
		Subscriber subscriber = repository.findById(requestInput.getIdSubscriber()).get();
		contractId = UUID.randomUUID().toString();		
		Contract contrat =  new Contract(contractId,requestInput.getContractAddress());		
		contrat.setSubscriberidSubscriber(requestInput.getIdSubscriber());
		contractRepo.save(contrat);
		
	 }
	 return contractId;
   }
	@GetMapping(path="/getAddress", consumes="application/json", produces="application/json")
	 public String getContractAddress(@RequestParam String contractId){
		 String result =""; // return empty string if not found.
		 Optional<Contract> optc = contractRepo.findById(contractId);
		 if(optc.isPresent()) {
			 result= optc.get().getAddress();
		 }
		 
		 return result;
	 }
}

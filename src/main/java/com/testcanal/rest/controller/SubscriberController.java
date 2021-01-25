package com.testcanal.rest.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.testcanal.entities.*;
import com.testcanal.pojo.UpdateAddressResponse;
import com.testcanal.pojo.UpdateRequestInput;
import com.testcanal.repository.ContractRepository;
import com.testcanal.repository.HistoryRepository;
import com.testcanal.repository.SubscriberRepository;

@RestController
@RequestMapping(path = "/subscriber")
public class SubscriberController {
	@Autowired
	private SubscriberRepository repository;
	
	@Autowired
	private ContractRepository contractRepo;
	
	@Autowired
	private  HistoryRepository historyRepository;
	 
	 @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	 public String addSubscriber(@RequestBody Subscriber subscriber) {
		 subscriber.setIdSubscriber(UUID.randomUUID().toString());
		 repository.save(subscriber);
	     return subscriber.getIdSubscriber();
	 }
	 @PostMapping(path="/updateAddress", consumes="application/json", produces="application/json")
	 public ArrayList<UpdateAddressResponse> updateSubscriberAddress(@RequestBody UpdateRequestInput request){
		 ArrayList<UpdateAddressResponse> list = new ArrayList<UpdateAddressResponse>();
		 
		Optional<Subscriber> result = repository.findById(request.getIdSubscriber());
		Subscriber subscriber;
		if(result.isPresent()) {
			//update de l'addresse  de l'abonné
			subscriber = result.get();
			String oldAddress = subscriber.getAdressePrincipale();
			subscriber.setAdressePrincipale(request.getNewAddress());			
			repository.save(subscriber);
			//Mise à jour des contrats
			List<Contract> listContrats = subscriber.getContractList();
			if(!subscriber.getPays().toLowerCase().equals("france")){
				Contract firstContract = listContrats.get(0);
				listContrats.clear();
				listContrats.add(firstContract);
			}
			
			for(Contract contrat: listContrats) {
				contrat.setAddress(request.getNewAddress());
				contractRepo.save(contrat);
				//enregistremnt de l'historique
				History history = new History(UUID.randomUUID().toString());
				history.setDateModification(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).toString());
				history.setIdContract(contrat.getIdContract());
				history.setIdSubscriber(request.getIdSubscriber());
				history.setTypeModification("Update Address");
				history.setOldValue(oldAddress);
				history.setNewValue(subscriber.getAdressePrincipale());
				historyRepository.save(history);
				UpdateAddressResponse uar = new UpdateAddressResponse(history.getIdMouvement(), history.getIdContract());				
				list.add(uar);
 				
			}
		}
		
		
		return list; 
	 }
	 
	 @GetMapping(path="/listConctracts", consumes="application/json", produces="application/json")
	 public List<Contract> getListContracts(@RequestParam String idSubscriber){
		 Optional<Subscriber> optSubscriber = repository.findById(idSubscriber);
		 return optSubscriber.isPresent() ?  optSubscriber.get().getContractList() : new ArrayList<Contract>();
	 }
	 
	 @GetMapping(path="/history", consumes="application/json", produces="application/json")
	 public List<History> getList(@RequestParam String idSubscriber){
		 return historyRepository.findByIdSubscriber(idSubscriber);

	 }
	 
}

package com.testcanal.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testcanal.entities.History;
import com.testcanal.repository.HistoryRepository;

@RestController
@RequestMapping(path="/history")
public class HistoryController {

	@Autowired
	private HistoryRepository historyRepository;
	
	 @GetMapping(path="/get", consumes="application/json", produces="application/json")
	 public History getHistoryById(@RequestParam String modificationId){
		 
		 return historyRepository.findById(modificationId).get();
	 }
}

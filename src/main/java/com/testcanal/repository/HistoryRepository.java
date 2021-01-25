package com.testcanal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testcanal.entities.Contract;
import com.testcanal.entities.History;
@Repository
public interface HistoryRepository extends JpaRepository<History, String> {
	
	List<History> findByIdSubscriber(String idSubscriber);

}

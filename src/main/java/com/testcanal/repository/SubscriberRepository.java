package com.testcanal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testcanal.entities.Subscriber;

@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber, String>{

}

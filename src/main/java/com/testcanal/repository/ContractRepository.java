package com.testcanal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testcanal.entities.Contract;


@Repository
public interface ContractRepository extends CrudRepository<Contract, String> {

}

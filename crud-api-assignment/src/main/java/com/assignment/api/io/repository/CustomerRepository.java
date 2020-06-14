/**
 
@author Avinash_Kumar


 */
package com.assignment.api.io.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.api.io.entity.CustomerEntity;


@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

	

}

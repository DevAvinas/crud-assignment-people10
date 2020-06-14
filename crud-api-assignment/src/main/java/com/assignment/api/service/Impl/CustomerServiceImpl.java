/**
 
@author Avinash_Kumar


 */
package com.assignment.api.service.Impl;



import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.api.exception.CustomerServiceException;
import com.assignment.api.io.entity.CustomerEntity;
import com.assignment.api.io.repository.CustomerRepository;
import com.assignment.api.service.CustomerService;
import com.assignment.api.shared.dto.CustomerDto;
import com.assignment.api.ui.model.response.ErrorMessages;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public CustomerDto getUserById(Long id) {
		// TODO Auto-generated method stub
		
		

		CustomerEntity customerEntity = customerRepository.findById(id).get();
		CustomerDto returnValue= new CustomerDto();
		if(customerEntity==null) throw new NoSuchElementException(ErrorMessages.RECORD_NOT_FOUND.getErrorMessage());
		BeanUtils.copyProperties(customerEntity, returnValue);
		
		return returnValue;
	}

	

	
	
	
	
	

}

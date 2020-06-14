/**
 
@author Avinash Kumar 


 */
package com.assignment.api.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.api.exception.CustomerServiceException;
import com.assignment.api.service.CustomerService;
import com.assignment.api.shared.dto.CustomerDto;
import com.assignment.api.ui.model.response.CustomerRest;
import com.assignment.api.ui.model.response.ErrorMessages;


@RestController
@RequestMapping("api/customer") // http://localhost:8080/api/customer

public class CustomerController {


	@Autowired	
	CustomerService customerService;	
	
	
	@GetMapping(path="/{id}", produces ={ MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })	
	public ResponseEntity getUser(@PathVariable Long id)
	{
		
		CustomerRest returnValue = new CustomerRest();

		CustomerDto customerDto = customerService.getUserById(id);
		

	
			BeanUtils.copyProperties(customerDto, returnValue);
			

			
			 return ResponseEntity.status(HttpStatus.OK).body(returnValue);
		
			
		
		
	}
	
	
	

}

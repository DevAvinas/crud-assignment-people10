package com.assignment.api;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.assignment.api.service.Impl.CustomerServiceImpl;
import com.assignment.api.shared.dto.CustomerDto;
import com.assignment.api.ui.controller.CustomerController;
import com.assignment.api.ui.model.response.CustomerRest;

public class CustomerControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	CustomerController customerController;
	
	@Mock
	CustomerServiceImpl customerService;
	
	CustomerDto customerDto;
	
	
	@Before
	public void setUp() throws Exception {
		
	MockitoAnnotations.initMocks(this);
		
	customerDto = new CustomerDto();
	
	customerDto.setId(1L);
	customerDto.setFirstname("avinash");
	customerDto.setLastname("kumar");
	customerDto.setDob(new Date(1995-05-07));
	customerDto.setEmail("avinash123@gmail.com");
	customerDto.setPassword("avinash123");
	}

	@Test
	public final void testGetUser()  {
		
		  when(customerService.getUserById(anyLong())).thenReturn(customerDto);	
		    
		  ResponseEntity customeroRest = customerController.getUser(1L);

			assertEquals(HttpStatus.OK, customeroRest.getStatusCode());	

		  
	}

}

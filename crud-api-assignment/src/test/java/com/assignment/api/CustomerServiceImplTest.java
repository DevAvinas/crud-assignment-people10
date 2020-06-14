package com.assignment.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.mockito.InjectMocks;
import static org.mockito.ArgumentMatchers.anyLong;

//import com.assignment.api.exception.CustomerServiceException;
import com.assignment.api.io.entity.CustomerEntity;
import com.assignment.api.io.repository.CustomerRepository;
import com.assignment.api.service.Impl.CustomerServiceImpl;
import com.assignment.api.shared.dto.CustomerDto;

@RunWith(MockitoJUnitRunner.class)

public class CustomerServiceImplTest {

	
	@Mock
	CustomerRepository customerRepository;

	  @InjectMocks
	CustomerServiceImpl customerServiceImpl;

	
	private CustomerEntity customerEntity = new CustomerEntity();
	@Before
	public void setUp() throws Exception {
		
		customerEntity.setId(1L);
		customerEntity.setFirstname("avinash");
		customerEntity.setLastname("kumar");
		customerEntity.setDob(new Date(1995-05-07));
		customerEntity.setEmail("avinash123@gmail.com");
		customerEntity.setPassword("avinash123");
	}

	@Test
	public final void testGetUserById() {



		when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customerEntity));
		CustomerDto customerDto = customerServiceImpl.getUserById(1L);
		assertNotNull(customerDto);
		assertEquals("avinash", customerDto.getFirstname());	
		}
	
	@Test(expected=NoSuchElementException.class)

	public void testGetUser_NoSuchElementException() {
		when(customerRepository.findById(anyLong()).get()).thenReturn(null);

		Throwable exception = assertThrows(NoSuchElementException.class,

				() -> {
					customerServiceImpl.getUserById(1L);
				}

		);

	}


}

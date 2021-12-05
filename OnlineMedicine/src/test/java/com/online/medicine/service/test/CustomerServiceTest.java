package com.online.medicine.service.test;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.online.medicine.entity.Customer;
import com.online.medicine.service.CustomerService;


@SpringBootTest
class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;
	
	@Test
	void createCustomerTest() {
		
		Customer customer = new Customer("Robin","Bisht","8077382791","robin@gmail.com");
		Customer saveCustomer = customerService.addCustomer(customer);
		assertEquals(customer.getCustomerId(), saveCustomer.getCustomerId());;
	}
	
	
	@Test
	void updateCustomerTest() {
		Customer customer = customerService.viewCustomer(1);
		customer.setEmail("robinBisht@gamil.com");
		Customer saveCustomer = customerService.updateCustomer(customer);
		assertEquals(customer.getEmail(), saveCustomer.getEmail());
	}
}

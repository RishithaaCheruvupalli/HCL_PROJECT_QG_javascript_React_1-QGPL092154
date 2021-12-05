package com.online.medicine.service.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.online.medicine.entity.Address;
import com.online.medicine.entity.Customer;
import com.online.medicine.service.AddressService;
import com.online.medicine.service.CustomerService;

@SpringBootTest
class AddressServiceTest {

	@Autowired
	private AddressService addressService;
	
	@Test
	void createAddressTest() {
		
		Address address = new Address("25","Ganga","Dehradun","Uttarakhand","India","248001");
		Address saveAddress = addressService.addAddress(address);
		assertEquals(address.getAddressId(), saveAddress.getAddressId());
	}
	
	@Test
	void updateAddressTest() {
		Address address = addressService.viewAddress(1);
		address.setPincode("123456");
		//updating customer
		Address saveAddress = addressService.updateAddress(address);
		assertEquals(address.getPincode(),saveAddress.getPincode() );
}
}

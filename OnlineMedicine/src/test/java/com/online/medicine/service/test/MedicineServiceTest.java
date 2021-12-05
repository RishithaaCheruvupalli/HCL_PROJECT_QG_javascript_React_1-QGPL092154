package com.online.medicine.service.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.online.medicine.entity.Customer;
import com.online.medicine.entity.Medicine;
import com.online.medicine.service.CustomerService;
import com.online.medicine.service.MedicineService;

@SpringBootTest
class MedicineServiceTest {
	@Autowired
	private MedicineService medicineService;
	private Medicine saveMedicine;
	
	@Test
	void createMedicineTest() {
		
		Medicine medicine = new Medicine();
		
		assertEquals(saveMedicine.getMedicineId(), medicine.getMedicineId());;
	}
	
	
		
	}


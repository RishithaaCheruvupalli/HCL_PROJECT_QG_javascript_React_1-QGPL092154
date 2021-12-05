package com.online.medicine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.medicine.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	
}

package com.online.medicine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.medicine.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}

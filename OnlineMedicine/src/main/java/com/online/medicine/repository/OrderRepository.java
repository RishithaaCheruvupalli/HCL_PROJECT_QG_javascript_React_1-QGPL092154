package com.online.medicine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.medicine.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}

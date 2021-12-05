package com.online.medicine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.medicine.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

}

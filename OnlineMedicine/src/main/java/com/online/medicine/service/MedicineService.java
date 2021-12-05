package com.online.medicine.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.online.medicine.entity.Medicine;
import com.online.medicine.repository.MedicineRepository;

@Service
public class MedicineService {
	@Autowired
	private MedicineRepository medicineRepo;
	
	public List<Medicine> viewAllMedicines(){
		return medicineRepo.findAll();
	}
	
	public Medicine addMedicine(Medicine medicine) {
		return medicineRepo.save(medicine); 
	}
	
	@Transactional
	public Medicine viewMedicine(Integer id) {
		Optional<Medicine> medicine = medicineRepo.findById(id);
		return medicine.get();
	}
	
	public void removeMedicine(Integer id) {
		medicineRepo.deleteById(id);
	}
	
	public Medicine updateMedicine(Medicine medicine) {
		return medicineRepo.save(medicine);
	}
	

	
	
	public Medicine medicine(Medicine medicineId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Medicine> viewAllmedicines() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

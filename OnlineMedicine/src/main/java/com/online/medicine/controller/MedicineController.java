package com.online.medicine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.medicine.entity.Medicine;
import com.online.medicine.service.MedicineService;

@RestController
@RequestMapping(path = "/medicines")
public class MedicineController<Medicines> {
	
	@Autowired
	private MedicineService medicineService;
	
	@SuppressWarnings("unchecked")
	@GetMapping("")
	public List<Medicines> findAll(){
		return (List<Medicines>) medicineService.viewAllmedicines();
	}
	
	@GetMapping("/{id}")
	public Medicine getOne(@PathVariable("id") Medicine medicineId) {
		return medicineService.medicine(medicineId);
	}
	@PostMapping(value = "/create",
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Medicine> createNew(@RequestBody Medicine medicine ) {
		medicineService.medicine(medicine);
		return ResponseEntity.ok(medicine);
	}
	@PutMapping("/{id}/update")
    public ResponseEntity edit(@PathVariable("id") Integer medicineId,
                               @RequestBody Medicine medicine) {
		medicine.setMedicineId(medicineId); 
        return ResponseEntity.ok(medicineService.medicine(medicine));
    }
	@DeleteMapping("/{id}/delete")
    public ResponseEntity delete(@PathVariable("id") Medicine medicineId) {
        Medicine viewmedicine = medicineService.medicine(medicineId);
        return ResponseEntity.ok().build();
    }
	
	
}

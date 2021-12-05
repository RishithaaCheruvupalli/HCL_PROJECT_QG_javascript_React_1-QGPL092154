package com.online.medicine.entity;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.online.medicine.entity.Medicine;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	
	
	@JoinColumn(name="customer_id")
	private Customer customer;

	@JsonIgnoreProperties(value={"carts","medicineId"})
	@ManyToMany(mappedBy="carts",fetch = FetchType.LAZY,cascade = {
			CascadeType.PERSIST,CascadeType.MERGE
	})
	private Set<Medicine> medicines = new HashSet<>();
	
	public Cart() {
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicine(Medicine medicine) {
		medicines.add(medicine);
	}
	public void setMedicines( Set<Medicine> medicines ) {
		this.medicines = medicines;
	}
	public void removeProduct(Medicine medicine) {
		this.medicines.remove(medicine);
	}
	
}

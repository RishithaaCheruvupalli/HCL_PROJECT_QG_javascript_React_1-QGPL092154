package com.online.medicine.entity;

import java.lang.constant.Constable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@Entity
public class Medicine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medicineId;
	
	private String medicineName;
	
	private double price;
	
	@JoinColumn(name="category_id")
	
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = {
			CascadeType.PERSIST,CascadeType.MERGE
	})
	@JoinTable(name="medicines_carts",joinColumns = {
			@JoinColumn(name="medicine_id",referencedColumnName = "medicineId")},
	inverseJoinColumns = {@JoinColumn(name="cart_id",referencedColumnName ="cartId")  })
	private Set<Cart> carts = new HashSet<>();
	
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = {
			CascadeType.PERSIST,CascadeType.MERGE
	})
	@JoinTable(name="medicines_orders",joinColumns = {
			@JoinColumn(name="medicine_id",referencedColumnName = "medicineId")},
	inverseJoinColumns = {@JoinColumn(name="order_id",referencedColumnName ="orderId")  })
	private Set<Order> orders = new HashSet<>();
	
	public Medicine() {
	}

	public Medicine(String medicineName, double price) {
//		this.productId = productId;
		this.medicineName = medicineName;
		this.price = price;
		
		
	}

	public int getMedicineId() {
		return medicineId;
	}

	

	public String getMedicineName() {
		return medicineName;
	}

	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCart(Cart cart) {
		this.carts.add(cart);
	}
	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	public void setOrder(Order order) {
		this.orders.add(order);
	}

	public void setMedicineId(Constable string) {
		// TODO Auto-generated method stub
		
	}

	
	
}

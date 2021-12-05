package com.online.medicine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.medicine.entity.Cart;
import com.online.medicine.service.CartService;

@RestController
@RequestMapping("/customer")
public class CartController {
	@Autowired
	private CartService cartService;	
	@GetMapping("/{cid}/cart")
	public Cart getCart(@PathVariable("cid") Integer customerId) {
		return cartService.getCustomerCart(customerId);
	}
	
	@PostMapping("/{cid}/cart/add-medicine/{pid}")
	public Cart addProduct(@PathVariable("cid") Integer customerId,@PathVariable("pid") Integer medicineId) {
		return cartService.addMedicineeToCart(medicineId, customerId);
	}
	
	@DeleteMapping("/{cid}/cart/remove-medicine/{pid}")
	public void removeMedicine(@PathVariable("cid") Integer customerId,@PathVariable("pid") Integer medicineId) {
		cartService.removeMedicineFromCart(customerId, medicineId);
	}
	@DeleteMapping("/{cid}/cart/remove-medicine")
	public void removeAllMedicines(@PathVariable("cid") Integer customerId) {
		cartService.removeAllMedicines(customerId);
	}
}

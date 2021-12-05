package com.online.medicine.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.online.medicine.entity.Cart;
import com.online.medicine.entity.Customer;
import com.online.medicine.entity.Medicine;
import com.online.medicine.repository.CartRepository;
import com.online.medicine.repository.CustomerRepository;
import com.online.medicine.repository.MedicineRepository;

@Service
public class CartService {
	@Autowired
	private MedicineRepository productRepository;
	@Autowired
	private CustomerRepository customerRepository;
	private Object medicine;
	
	public Cart getCustomerCart(Integer customerId ) {
		Customer customer = customerRepository.findById(customerId).get();
		Cart cart = customer.getCart();
		return cart;
	}
	
	public Cart addProductToCart(Integer productId,Integer customerId) {
		Medicine medicine = productRepository.findById(productId).get();
		Customer customer = customerRepository.findById(customerId).get();
		Cart cart = customer.getCart();
		cart.setMedicine(medicine);
		medicine.setCart(cart);
		customer.setCart(cart);
		customerRepository.save(customer);
		productRepository.save(medicine);
		return cart;
	}
	
	public <S> void removeProductFromCart( Integer customerId, Integer productId ) {
		Customer customer = customerRepository.findById(customerId).get();
		CrudRepository<Cart, Integer> medicineRepository;
		
		Cart cart = customer.getCart();
		cart.getMedicines().remove(medicine);		
		customer.setCart(cart);
		
		customerRepository.save(customer);
	}
	
	public void removeAll(Integer customerId) {
		Customer customer = customerRepository.findById(customerId).get();
		Cart cart = customer.getCart();
		Set<Medicine> productsInCart = cart.getMedicines();
		Medicine[] medicinesInCart = null;
		for(Medicine medicine : medicinesInCart  ) {
			medicine.getCarts().remove(cart);
		}
		cart.setMedicines(new HashSet<Medicine>());
		customer.setCart(cart);
		customerRepository.save(customer);
	}

	public Cart addMedicineeToCart(Integer medicineId, Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeMedicineFromCart(Integer customerId, Integer medicineId) {
		// TODO Auto-generated method stub
		
	}

	public void removeAllMedicines(Integer customerId) {
		// TODO Auto-generated method stub
		
	}
	
}

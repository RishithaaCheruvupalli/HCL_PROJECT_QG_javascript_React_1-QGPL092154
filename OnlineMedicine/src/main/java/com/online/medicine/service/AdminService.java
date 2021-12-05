package com.online.medicine.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.medicine.entity.Admin;
import com.online.medicine.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository userRepository;
	
	public Admin addNewUser(Admin user) {
		return userRepository.save(user);
	}
	
	public String viewUserRole(Integer id) {
		return userRepository.findById(id).get().getRole();
	}
	public String viewUserName(Integer id) {
		return userRepository.findById(id).get().getUsername();
	}
	public List<String> viewUser(Integer id){
		List<String> userData = new ArrayList<>();
		userData.add(viewUserName(id));
		userData.add(viewUserRole(id));
		return userData;
	}
	public List<List<String>> viewAllUsers(){
		List<Admin> allUsers = userRepository.findAll();
		List<List<String>> userData = new ArrayList<>();
		for( Admin user : allUsers ) {
			userData.add(viewUser(user.getUserId()));
		}
		return userData;
	}
	
	
	public Admin updateUser(Admin user) {
		return userRepository.save(user);
	}
	public void removeUser(Integer id) {
		userRepository.deleteById(id);
	}
	
}

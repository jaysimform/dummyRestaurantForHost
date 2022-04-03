package com.simformsolutions.restaurant.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.simformsolutions.restaurant.model.Customer;
import com.simformsolutions.restaurant.repository.CustomerRepo;



@RestController
@RequestMapping("/home")
public class LoginController {
	
	@Autowired
	private CustomerRepo customerRepo;

	@PostMapping("/login")
//	public ResponseEntity<String> LoginPost (@RequestBody Customer customer)
	public ResponseEntity<String> LoginPost (@RequestParam("email") String email,@RequestParam("password") String password )
	{
		Customer customer1= customerRepo.findByEmail(email);
		if(customer1 != null && (password.equals(customer1.getPassword())))
		{
			return new ResponseEntity<String>("this" + email + "and" + password + "matched", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("this" + email + "and" + password + "did not matched", HttpStatus.UNAUTHORIZED);
		}

		
	}
	
}
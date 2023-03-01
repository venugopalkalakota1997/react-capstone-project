package com.iiht.supplierFinanceSystem.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.supplierFinanceSystem.model.Client;
import com.iiht.supplierFinanceSystem.model.Supplier;
import com.iiht.supplierFinanceSystem.service.RegistrationService;

@RestController
@RequestMapping("/registration")
@CrossOrigin
public class RegistrationController {
	
	@Autowired
	RegistrationService registrationService;
	
	
	@PostMapping("/supplier")
	public ResponseEntity<String> supplierRegistration(@Valid @RequestBody Supplier supplier){
		
		if(null!= supplier) {
			return registrationService.supplierRegistration(supplier);
		}
		return new ResponseEntity<>("Supplier is empty", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/client")
	public ResponseEntity<String> supplierRegistration(@Valid @RequestBody Client client){
		
		if(null!= client) {
			return registrationService.clientRegistration(client);
		}
		return new ResponseEntity<>("Client is empty", HttpStatus.BAD_REQUEST);
		
	}
}

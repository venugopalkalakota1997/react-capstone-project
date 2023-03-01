package com.iiht.supplierFinanceSystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.iiht.supplierFinanceSystem.model.Client;
import com.iiht.supplierFinanceSystem.model.Supplier;
import com.iiht.supplierFinanceSystem.repository.ClientRepository;
import com.iiht.supplierFinanceSystem.repository.SupplierRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginService {

	@Autowired
	SupplierRepository supplierRepository;

	@Autowired
	ClientRepository clientRepository;

	public ResponseEntity<String> supplierLogin(String name, String password) {
		Optional<Supplier> supplier = supplierRepository.findByName(name);
		if (!supplier.isPresent()) {
			log.error("Username is incorrect");
			return new ResponseEntity<String>("Username is incorrect", HttpStatus.UNAUTHORIZED);
		} else if (!supplier.get().getPassword().equals(password)) {
			log.error("Password is incorrect");
			return new ResponseEntity<String>("Password is incorrect", HttpStatus.UNAUTHORIZED);
		} else {
			log.info("Logged in");
			return new ResponseEntity<String>("Logged in ", HttpStatus.ACCEPTED);
		}

	}
	
	public ResponseEntity<String> clientLogin(String name, String password) {
		Optional<Client> client = clientRepository.findByName(name);
		if (!client.isPresent()) {
			log.error("Username is incorrect");
			return new ResponseEntity<String>("Username is incorrect", HttpStatus.UNAUTHORIZED);
		} else if (!client.get().getPassword().equals(password)) {
			log.error("Password is incorrect");
			return new ResponseEntity<String>("Password is incorrect", HttpStatus.UNAUTHORIZED);
		} else {
			log.info("Logged in");
			return new ResponseEntity<String>("Logged in ", HttpStatus.ACCEPTED);
		}

	}

}

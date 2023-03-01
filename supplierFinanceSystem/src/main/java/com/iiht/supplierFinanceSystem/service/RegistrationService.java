package com.iiht.supplierFinanceSystem.service;

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
public class RegistrationService {
	
	@Autowired
	SupplierRepository supplierRepository;

	@Autowired
	ClientRepository clientRepository;
	
	public ResponseEntity<String> supplierRegistration(Supplier supplier) {
		try {
		ResponseEntity<String> response=  new ResponseEntity<String>("Created", HttpStatus.ACCEPTED);
		if(supplierRepository.findByName(supplier.getName()).isPresent()) {
			log.info("Supplier already  exists");
			return  new ResponseEntity<String>("Supplier already  exists", HttpStatus.BAD_REQUEST);
		}else {
			supplierRepository.save(supplier);
			log.info("Supplier Saved successfully");
			return response;
		}
		}catch (Exception e) {
			log.info(e.getMessage());
			return  new ResponseEntity<String>("internal Server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

	public ResponseEntity<String> clientRegistration(Client client) {
		try {
			ResponseEntity<String> response=  new ResponseEntity<String>("Created", HttpStatus.ACCEPTED);
			if(clientRepository.findByName(client.getName()).isPresent()) {
				log.info("Client already  exists");
				return  new ResponseEntity<String>("Client already  exists", HttpStatus.BAD_REQUEST);
			}else {
				clientRepository.save(client);
				log.info("Client Saved successfully");
				return response;
			}
			}catch (Exception e) {
				log.info(e.getMessage());
				return  new ResponseEntity<String>("internal Server error", HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}

}

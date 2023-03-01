package com.iiht.supplierFinanceSystem.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.supplierFinanceSystem.service.LoginService;
@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@GetMapping("/supplier/{name}/{password}")
	public ResponseEntity<String> supplierLogin(@PathVariable String name,@PathVariable String password){
		if(null!=name && null!=password ) {
			return loginService.supplierLogin(name, password);
		}
		return new ResponseEntity<>("name or password is empty", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/client/{name}/{password}")
	public ResponseEntity<String> clientLogin(@PathVariable String name,@PathVariable String password){
		if(null!=name && null!=password ) {
			return loginService.clientLogin(name, password);
		}
		return new ResponseEntity<>("name or password is empty", HttpStatus.BAD_REQUEST);
	}
	
	
}

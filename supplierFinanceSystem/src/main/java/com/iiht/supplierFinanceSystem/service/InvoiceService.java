package com.iiht.supplierFinanceSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.iiht.supplierFinanceSystem.model.Client;
import com.iiht.supplierFinanceSystem.model.Invoice;
import com.iiht.supplierFinanceSystem.model.Supplier;
import com.iiht.supplierFinanceSystem.repository.ClientRepository;
import com.iiht.supplierFinanceSystem.repository.InvoiceRepository;
import com.iiht.supplierFinanceSystem.repository.SupplierRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InvoiceService {
	@Autowired
	InvoiceRepository invoiceRepository;
	@Autowired
	SupplierRepository supplierRepository;

	@Autowired
	ClientRepository clientRepository;

	public ResponseEntity<String> saveInvoice(Invoice invoice, String clientId, Long SupplierId) {
		Optional<Invoice> invoiceLocal = invoiceRepository.findById(invoice.getInvoiceNumber());
		if (invoiceLocal.isPresent()) {
			log.error("Invocie number is already exists");
			return new ResponseEntity<String>("Invocie number is already exists", HttpStatus.NOT_ACCEPTABLE);
		} else if (!supplierRepository.findById(SupplierId).isPresent()) {
			log.error("Supplier number is does not exists");
			return new ResponseEntity<String>("Supplier number is does not exists", HttpStatus.NOT_ACCEPTABLE);
		} else {
			invoice.setClient(clientRepository.findByName(clientId).get());
			invoice.setSupplier(supplierRepository.findById(SupplierId).get());
			invoiceRepository.save(invoice);
			log.info("Invocie Saved");
			return new ResponseEntity<String>("Invocie Saved", HttpStatus.ACCEPTED);
		}
	}

	public List<Invoice> getAllInvoices(String clientId) {
		Client client = clientRepository.findByName(clientId).get();
		return invoiceRepository.findAllByClient(client);
	}
	
	
	public List<Invoice> getAllInvoicesBySuppler(String supplierId) {
		Supplier supplier = supplierRepository.findByName(supplierId).get();
		return invoiceRepository.findAllBySupplier(supplier);
	}

}

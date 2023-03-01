package com.iiht.supplierFinanceSystem.rest;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.iiht.supplierFinanceSystem.common.InvoiceRequest;
import com.iiht.supplierFinanceSystem.model.Invoice;
import com.iiht.supplierFinanceSystem.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
@CrossOrigin
public class InvoiceController {
	
	@Autowired
	InvoiceService invoiceService;
	
	@PostMapping("/save/i/{clientId}/{supplierId}")
	public ResponseEntity<String> saveInvocie(@RequestBody Invoice invoice,@PathVariable String clientId,@PathVariable Long supplierId){
		if(null!=invoice && null != supplierId && null!=clientId) {
		return invoiceService.saveInvoice(invoice, clientId, supplierId);
		}
		return new ResponseEntity<>("invoice or password is empty", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/Client/{clientName}")
	public List<Invoice> getInvocieByClientId(@PathVariable String clientName){
		if(null!=clientName) {
			return invoiceService.getAllInvoices(clientName);
		}
		return null;		
	}
	
	@GetMapping("/Supplier/{supplierName}")
	public List<Invoice> getInvocieBySupplierId(@PathVariable String supplierName){
		if(null!=supplierName) {
			return invoiceService.getAllInvoicesBySuppler(supplierName);
		}
		return null;
	}
	
	@PostMapping(path="/save/{clientId}/{supplierId}")
	public ResponseEntity<String> saveInvocieSet(@PathVariable String clientId,@PathVariable Long supplierId,
			@RequestPart("file") MultipartFile file,
			@RequestParam("invoiceNumber") Long invoiceNumber ,
			@RequestParam("invoiceDate") Date invoiceDate ,
			@RequestParam("invoiceAmount") Double invoiceAmount ,
			@RequestParam("currency") String currency){
		InvoiceRequest invoiceRequest = new InvoiceRequest(invoiceNumber,invoiceDate,invoiceAmount,currency);
		if(null!=invoiceRequest && null != supplierId && null!=clientId) {
			Invoice invoice = this.convertInvoiceRequest(invoiceRequest,file);
		return invoiceService.saveInvoice(invoice, clientId, supplierId);
		}
		return new ResponseEntity<>("invoice or password is empty", HttpStatus.BAD_REQUEST);
	}
	
	private Invoice convertInvoiceRequest(InvoiceRequest invoiceRequest, MultipartFile document) {
		Invoice invoice = new Invoice();
		try {
		
		invoice.setInvoiceNumber(invoiceRequest.getInvoiceNumber());
		invoice.setInvoiceDate(invoiceRequest.getInvoiceDate());
		invoice.setInvoiceAmount(invoiceRequest.getInvoiceAmount());
		invoice.setCurrency(invoiceRequest.getCurrency());
		
			invoice.setInvoice(document.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return invoice;
	}


}

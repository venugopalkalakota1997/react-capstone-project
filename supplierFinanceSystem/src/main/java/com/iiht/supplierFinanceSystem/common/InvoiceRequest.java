package com.iiht.supplierFinanceSystem.common;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceRequest {
	private Long invoiceNumber;
	private Date invoiceDate;
	private Double invoiceAmount;
	private String currency;
	//private MultipartFile invoice;
}

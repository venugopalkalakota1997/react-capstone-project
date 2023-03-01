package com.iiht.supplierFinanceSystem.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "invoice")
@Setter
@Getter
@NoArgsConstructor
public class Invoice {
	@Id
	private Long invoiceNumber;
	private Date invoiceDate;
	private Double invoiceAmount;
	private String currency;
	@Lob
	private byte[] invoice;

	@ManyToOne
	Supplier supplier;
	@ManyToOne
	Client client;

}

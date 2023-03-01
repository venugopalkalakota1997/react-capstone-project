package com.iiht.supplierFinanceSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "client")
@Setter
@Getter
@NoArgsConstructor
public class Client {
	  @Id	
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Long id;
	  @Size(min=2, max=240, message = "Name should be atleast 2 characters and max 30")
	  private String name;
	  private String address;
	  @Pattern(regexp="^([_a-zA-Z0-9-]+(\\\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\\\.[a-zA-Z0-9-]+)*(\\\\.[a-zA-Z]{1,6}))?$")
	  private String email;
	  @Pattern(regexp="^[0-9]{10}$")
	  private String mobileNumber;
	  private String creditAccountNumber;
	  private String creditInformation;
	  private String password;

}

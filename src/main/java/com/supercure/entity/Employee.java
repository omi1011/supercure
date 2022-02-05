package com.supercure.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String surname;
	private String mobileNo;
	private String mail;
	private String passw;
	//private String confirmPassw;
	//private String catagory;
	private String dob;
	private String adhar;
	private String currentAddress;
	private Boolean status;
	
	@OneToOne
	private Catagory catagory;
	
	
	
	
	
}

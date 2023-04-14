package com.aamir.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerId")
    @SequenceGenerator(name = "customerId", sequenceName = "customer_id_seq", allocationSize = 1)
	private int customerId; 
	private String title;
	private String firstName;
	private String surname;
	private LocalDate dob;
	private String mobile;
	private String email;
	private int packages;
    private int charges;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(int customerId, String title, String firstName, String surname, LocalDate dob, String mobile,
			String email, int packages, int charges) {
		super();
		this.customerId = customerId;
		this.title = title;
		this.firstName = firstName;
		this.surname = surname;
		this.dob = dob;
		this.mobile = mobile;
		this.email = email;
		this.packages = packages;
		this.charges = charges;
	}

	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public LocalDate getDob() {
		return dob;
	}
	
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getPackages() {
		return packages;
	}

	public void setPackages(int packages) {
		this.packages = packages;
	}

	public int getCharges() {
		return charges;
	}

	public void setCharges(int charges) {
		this.charges = charges;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", title=" + title + ", firstName=" + firstName + ", surname="
				+ surname + ", dob=" + dob + ", mobile=" + mobile + ", email=" + email + ", packages=" + packages
				+ ", charges=" + charges + "]";
	}

}

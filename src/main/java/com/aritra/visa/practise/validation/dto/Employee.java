package com.aritra.visa.practise.validation.dto;

import com.aritra.visa.practise.validation.annotation.Validation;

public class Employee {
	@Validation(mandatory = true, maxLength = 1000)
	private String firstName;
	@Validation(maxLength = 500)
	private String lastName;
	@Validation(mandatory = true, regex = "(0/91)?[7-9][0-9]{9}")
	private String mobileNumber;
	
	private Address address;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
}

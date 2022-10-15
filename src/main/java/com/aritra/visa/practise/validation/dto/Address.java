package com.aritra.visa.practise.validation.dto;

import com.aritra.visa.practise.validation.annotation.Validation;

public class Address {
	@Validation(mandatory = true, maxLength = 1000)
	private String addressLine1;
	private String addressLine2;
	@Validation(mandatory = true)
	private String city;
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}

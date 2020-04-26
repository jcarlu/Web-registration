package com.techelevator.model;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * User
 */
public class Subscriber {
	
	private String hexId;
	
    @NotBlank(message = "First Name is required")
    @Pattern(regexp = "^[a-zA-Z-']+$")
    private String firstName;
    
    @Pattern(regexp = "^[a-zA-Z-']+$")
    private String lastName;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Please enter a valid email address")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;
    
    @Pattern(regexp = "^\\D?(\\d{3})\\D?\\D?(\\d{3})\\D?(\\d{4})$", message = "Invalid phone number") 
    private String phoneNumber;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHexId() {
		return hexId;
	}

	public void setHexId(String hexId) {
		this.hexId = hexId;
	}

    


}
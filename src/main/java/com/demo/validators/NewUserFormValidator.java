package com.demo.validators;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class NewUserFormValidator {
	
	@Email
	private String email;
	
	@Size(min = 1, max = 255, message = "Please enter between {min} and {max} characters.")
	private String name;
	
	@Size(min = 1, max = 255, message = "Please enter between {min} and {max} characters.")
	private String surname;
	
	@Size(min = 8, max = 255, message = "Please enter between {min} and {max} characters.")
	private String password;
	
	public String getPassword() {
		return password;
	}
	
	private String civility;
	
	private String profile;
	
	private String groupClass;

	public String getGroupClass() {
		return groupClass;
	}

	public void setGrouClass(String groupClass) {
		this.groupClass = groupClass;
	}

	public String getCivility() {
		return civility;
	}

	public void setCivility(String civility) {
		this.civility = civility;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@NotNull(message="not match")
	private String confirmPassword;

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setPassword(String password) {
	    this.password = password;
	    checkPassword();//check
	}   

	public void setConfirmPassword(String confirmPassword) {
	    this.confirmPassword = confirmPassword;
	    checkPassword();//check
	}

	private void checkPassword() {
	    if(this.password == null || this.confirmPassword == null){
	        return;
	    }else if(!this.password.equals(confirmPassword)){
	        this.confirmPassword = null;
	    }
	}
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	@Override
	public String toString() {
		return profile;
	}

}

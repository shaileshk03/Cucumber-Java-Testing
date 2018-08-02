package com.pizzahut.helper.Userdata;


public class userData {
		
	String firstName;
	String lastName;
	String phoneNumber;
	String emailAddress;
	String userName;
	String Password;
	String confirmPassword;
	
	
	 public userData(String firstName,String lastName, String phoneNumber,String emailAddress,String userName, String Password,String confirmPassword) {
	  this.firstName = firstName;
	  this.lastName = lastName;
	  this.phoneNumber = phoneNumber;
	  this.emailAddress = emailAddress;
	  this.userName = userName;
	  this.Password = Password;
	  this.confirmPassword = confirmPassword;
	 }
	
	 public String getFirstName() {
		return this.firstName; 
	 }
	
    public String getLastName() {
    	return this.lastName;
    }

    public String getPhoneNumber() {
    	return this.phoneNumber;
    }

    public String getEmailAddress() {
	   return this.emailAddress;
    }

    public String getUserName() {
	   return this.userName;
    }
 
    public String getPassword() {
    	return this.Password;
    }

    public String getConfirmPassword() {
    	return this.confirmPassword;
    }
    
    
}

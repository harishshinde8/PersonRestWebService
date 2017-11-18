package com.test.jersey;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String pinCode;	
	private String birthDate;
	private String isActive;
	
	public Person(int id) {
		this.id=id;
	}
	
	public Person(int id,String fname,String lname,String email,String pincode,String birthDate,String isActive) {
		this.id=id;
		this.fname=fname;
		this.lname=lname;
		this.email=email;
		this.pinCode=pincode;
		this.birthDate=birthDate;
		this.isActive=isActive;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override
	public boolean equals(Object obj) {
		 if(this == obj)
	            return true;
	         
	        if(obj == null || obj.getClass()!= this.getClass())
	            return false;
	        
	        Person person = (Person) obj;
	         
	        // comparing the state of argument with 
	        // the state of 'this' Object.
	        return (person.id == this.id);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.id;
	}
}
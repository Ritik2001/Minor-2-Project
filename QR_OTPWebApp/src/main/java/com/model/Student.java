package com.model;

public class Student {
	private String firstName;
	private String lastName; 
	private String sapid;
	private String emailID;
	private String password; 
	private String dob;
	private String qrdetails;
	private String branch;
	private String year;
	public Student(String firstName, String lastName, String sapid, String emailID, String password, String dob,
			String qrdetails, String branch, String year) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sapid = sapid;
		this.emailID = emailID;
		this.password = password;
		this.dob = dob;
		this.qrdetails = qrdetails;
		this.branch = branch;
		this.year = year;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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
	public String getSapid() {
		return sapid;
	}
	public void setSapid(String sapid) {
		this.sapid = sapid;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getQrdetails() {
		return qrdetails;
	}
	public void setQrdetails(String qrdetails) {
		this.qrdetails = qrdetails;
	}
	

}

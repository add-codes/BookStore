package com.green.java.Client.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerID;
	
	@Column(name = "EMAIL")
	private String customerEmail;
	
	@Column(name = "PASSWORD")
	private String customerPassword;
	
	@Column(name = "FIRST_NAME")
	private String customerFirstName;
	
	@Column(name = "LAST_NAME")
	private String customerLastName;

	@Column(name = "AGE")
	private Integer customerAge;
	
	@Column(name = "GENDER")
	private String customerGender;
	
	@Column(name = "PHONE_NUMBER")
	private String customerPhoneNumber;
	
	@Column(name = "RANK_MEMBER")
	private Integer customerRankMember;
	
	@Column(name = "CREATED_DATE")
	private Date customerCreatedDate;

	@Column(name = "STATUS")
	private Boolean customerStatus;

	public Customer() {
		super();
	}

	public Customer(Integer customerID, String customerEmail, String customerPassword, String customerFirstName,
			String customerLastName, Integer customerAge, String customerGender, String customerPhoneNumber,
			Integer customerRankMember, Date customerCreatedDate, Boolean customerStatus) {
		super();
		this.customerID = customerID;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerAge = customerAge;
		this.customerGender = customerGender;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerRankMember = customerRankMember;
		this.customerCreatedDate = customerCreatedDate;
		this.customerStatus = customerStatus;
	}

	public Customer(Integer customerID, String customerEmail, String customerFirstName, String customerLastName,
			Integer customerAge, String customerGender, String customerPhoneNumber, Integer customerRankMember,
			Date customerCreatedDate, Boolean customerStatus) {
		super();
		this.customerID = customerID;
		this.customerEmail = customerEmail;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerAge = customerAge;
		this.customerGender = customerGender;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerRankMember = customerRankMember;
		this.customerCreatedDate = customerCreatedDate;
		this.customerStatus = customerStatus;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public Integer getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(Integer customerAge) {
		this.customerAge = customerAge;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public Integer getCustomerRankMember() {
		return customerRankMember;
	}

	public void setCustomerRankMember(Integer customerRankMember) {
		this.customerRankMember = customerRankMember;
	}

	public Date getCustomerCreatedDate() {
		return customerCreatedDate;
	}

	public void setCustomerCreatedDate(Date customerCreatedDate) {
		this.customerCreatedDate = customerCreatedDate;
	}

	public Boolean getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(Boolean customerStatus) {
		this.customerStatus = customerStatus;
	}
	
	
	
}

package com.green.java.Admin.entity.customer;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.green.java.Admin.entity.home.Address;

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
	private String customerPhone;

	@Column(name = "RANK_MEMBER")
	private Integer customerRank;

	@Column(name = "CREATED_DATE")
	private Date customerCreatedDate;

	@Column(name = "STATUS")
	private Boolean customerStatus;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "ADDRESS_STAFF_CUSTOMER",
				joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
				inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID"))
	private Set<Address> addressCustomer = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "CUSTOMER_DISCOUNT",
				joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
				inverseJoinColumns = @JoinColumn(name = "DISCOUNT_ID"))
	private Set<Discount> discountCustomer = new HashSet<>();
	

	public Customer() {
		super();
	}

	public Customer(Integer customerID, String customerEmail, String customerPassword, String customerFirstName,
			String customerLastName, Integer customerAge, String customerGender, String customerPhone,
			Integer customerRank, Date customerCreatedDate, Boolean customerStatus) {
		super();
		this.customerID = customerID;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerAge = customerAge;
		this.customerGender = customerGender;
		this.customerPhone = customerPhone;
		this.customerRank = customerRank;
		this.customerCreatedDate = customerCreatedDate;
		this.customerStatus = customerStatus;
	}

	public Customer(Integer customerID, String customerEmail, String customerFirstName, String customerLastName,
			Integer customerAge, String customerGender, String customerPhone, Integer customerRank,
			Date customerCreatedDate, Boolean customerStatus) {
		super();
		this.customerID = customerID;
		this.customerEmail = customerEmail;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerAge = customerAge;
		this.customerGender = customerGender;
		this.customerPhone = customerPhone;
		this.customerRank = customerRank;
		this.customerCreatedDate = customerCreatedDate;
		this.customerStatus = customerStatus;
	}

	public Set<Address> getAddressCustomer() {
		return addressCustomer;
	}

	public void setAddressCustomer(Set<Address> addressCustomer) {
		this.addressCustomer = addressCustomer;
	}

	public Set<Discount> getDiscountCustomer() {
		return discountCustomer;
	}

	public void setDiscountCustomer(Set<Discount> discountCustomer) {
		this.discountCustomer = discountCustomer;
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

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public Integer getCustomerRank() {
		return customerRank;
	}

	public void setCustomerRank(Integer customerRank) {
		this.customerRank = customerRank;
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

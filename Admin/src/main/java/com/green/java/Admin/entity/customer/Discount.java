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

@Entity
@Table(name = "DISCOUNT")
public class Discount {

	@Id
	@Column(name = "DISCOUNT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer discountID;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "VALUE")
	private Integer value;

	@Column(name = "EXPIRED")
	private Date expired;
	
	@ManyToMany(mappedBy = "customerDiscount")
	private Set<Customer> discountCustomer = new HashSet<Customer>();

	public Discount() {
		super();
	}

	public Discount(Integer discountID, String description, Integer value, Date expired) {
		super();
		this.discountID = discountID;
		this.description = description;
		this.value = value;
		this.expired = expired;
	}

	public Set<Customer> getDiscountCustomer() {
		return discountCustomer;
	}

	public void setDiscountCustomer(Set<Customer> discountCustomer) {
		this.discountCustomer = discountCustomer;
	}

	public Integer getDiscountID() {
		return discountID;
	}

	public void setDiscountID(Integer discountID) {
		this.discountID = discountID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Date getExpired() {
		return expired;
	}

	public void setExpired(Date expired) {
		this.expired = expired;
	}

}

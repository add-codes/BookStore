package com.green.java.Client.entity;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id
	@Column(name = "ADDRESS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressID;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "CITY")
	private String city;

	@Column(name = "DISTRICT")
	private String district;

	@Column(name = "WARD")
	private String ward;

	@Column(name = "STREET")
	private String street;

	@Column(name = "NUMBER")
	private Integer number;

	public Address() {
		super();
	}

	public Address(Integer addressID, String country, String city, String district, String ward, String street,
			Integer number) {
		super();
		this.addressID = addressID;
		this.country = country;
		this.city = city;
		this.district = district;
		this.ward = ward;
		this.street = street;
		this.number = number;
	}

	public Integer getAddressID() {
		return addressID;
	}

	public void setAddressID(Integer addressID) {
		this.addressID = addressID;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}

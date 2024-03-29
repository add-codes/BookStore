package com.green.java.Admin.entity.home;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.green.java.Admin.entity.customer.Customer;
import com.green.java.Admin.entity.staff.Staff;

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
	private String houseNumner;

	@ManyToMany(mappedBy = "staffAddress")
	private Set<Staff> addressStaff = new HashSet<Staff>();
	
	@ManyToMany(mappedBy = "customerAddress")
	private Set<Customer> addressCustomer = new HashSet<Customer>();

	public Address() {
		super();
	}

	public Address(Integer addressID, String country, String city, String district, String ward, String street,
			String houseNumner) {
		super();
		this.addressID = addressID;
		this.country = country;
		this.city = city;
		this.district = district;
		this.ward = ward;
		this.street = street;
		this.houseNumner = houseNumner;
	}

	public Set<Staff> getAddressStaff() {
		return addressStaff;
	}

	public void setAddressStaff(Set<Staff> addressStaff) {
		this.addressStaff = addressStaff;
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

	public String getHouseNumner() {
		return houseNumner;
	}

	public void setHouseNumner(String houseNumner) {
		this.houseNumner = houseNumner;
	}

}

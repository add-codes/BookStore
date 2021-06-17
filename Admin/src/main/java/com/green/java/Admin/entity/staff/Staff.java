package com.green.java.Admin.entity.staff;

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
@Table(name = "STAFF")
public class Staff {

	@Id
	@Column(name = "STAFF_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer staffID;

	@Column(name = "USERNAME")
	private String staffUsername;

	@Column(name = "PASSWORD")
	private String staffPassword;

	@Column(name = "FIRST_NAME")
	private String staffFirstName;

	@Column(name = "LAST_NAME")
	private String staffLastName;

	@Column(name = "EMAIL")
	private String staffEmail;

	@Column(name = "AGE")
	private Integer staffAge;

	@Column(name = "GENDER")
	private String staffGender;

	@Column(name = "PHONE_NUMBER")
	private String staffPhone;

	@Column(name = "STATUS")
	private Boolean staffStatus;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "STAFF_ROLE", 
				joinColumns = @JoinColumn(name = "STAFF_ID"), 
				inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private Set<Role> staffRole = new HashSet<>();

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "ADDRESS_STAFF", 
				joinColumns = @JoinColumn(name = "STAFF_ID"), 
				inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID"))
	private Set<Address> staffAddress = new HashSet<>();

	public Staff() {
		super();
	}

	public Staff(Integer staffID, String staffUsername, String staffPassword, String staffFirstName,
			String staffLastName, String staffEmail, Integer staffAge, String staffGender, String staffPhone,
			Boolean staffStatus) {
		super();
		this.staffID = staffID;
		this.staffUsername = staffUsername;
		this.staffPassword = staffPassword;
		this.staffFirstName = staffFirstName;
		this.staffLastName = staffLastName;
		this.staffEmail = staffEmail;
		this.staffAge = staffAge;
		this.staffGender = staffGender;
		this.staffPhone = staffPhone;
		this.staffStatus = staffStatus;
	}

	public Staff(Integer staffID, String staffUsername, String staffFirstName, String staffLastName, String staffEmail,
			Integer staffAge, String staffGender, String staffPhone, Boolean staffStatus) {
		super();
		this.staffID = staffID;
		this.staffUsername = staffUsername;
		this.staffFirstName = staffFirstName;
		this.staffLastName = staffLastName;
		this.staffEmail = staffEmail;
		this.staffAge = staffAge;
		this.staffGender = staffGender;
		this.staffPhone = staffPhone;
		this.staffStatus = staffStatus;
	}

	public Set<Role> getStaffRole() {
		return staffRole;
	}

	public void setStaffRole(Set<Role> staffRole) {
		this.staffRole = staffRole;
	}

	public Set<Address> getStaffAddress() {
		return staffAddress;
	}

	public void setStaffAddress(Set<Address> staffAddress) {
		this.staffAddress = staffAddress;
	}

	public Integer getStaffID() {
		return staffID;
	}

	public void setStaffID(Integer staffID) {
		this.staffID = staffID;
	}

	public String getStaffUsername() {
		return staffUsername;
	}

	public void setStaffUsername(String staffUsername) {
		this.staffUsername = staffUsername;
	}

	public String getStaffPassword() {
		return staffPassword;
	}

	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}

	public String getStaffFirstName() {
		return staffFirstName;
	}

	public void setStaffFirstName(String staffFirstName) {
		this.staffFirstName = staffFirstName;
	}

	public String getStaffLastName() {
		return staffLastName;
	}

	public void setStaffLastName(String staffLastName) {
		this.staffLastName = staffLastName;
	}

	public String getStaffEmail() {
		return staffEmail;
	}

	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}

	public Integer getStaffAge() {
		return staffAge;
	}

	public void setStaffAge(Integer staffAge) {
		this.staffAge = staffAge;
	}

	public String getStaffGender() {
		return staffGender;
	}

	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender;
	}

	public String getStaffPhone() {
		return staffPhone;
	}

	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}

	public Boolean getStaffStatus() {
		return staffStatus;
	}

	public void setStaffStatus(Boolean staffStatus) {
		this.staffStatus = staffStatus;
	}

}

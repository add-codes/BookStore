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

@Entity
@Table(name = "ROLE")
public class Role {

	@Id
	@Column(name = "ROLE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleID;

	@Column(name = "ROLE_NAME")
	private String roleName;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToMany(mappedBy = "staffRole")
	private Set<Staff> roleStaff = new HashSet<>();
	
	public Role() {
		super();
	}

	public Role(Integer roleID, String roleName, String description) {
		super();
		this.roleID = roleID;
		this.roleName = roleName;
		this.description = description;
	}

	public Set<Staff> getRoleStaff() {
		return roleStaff;
	}

	public void setRoleStaff(Set<Staff> roleStaff) {
		this.roleStaff = roleStaff;
	}

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

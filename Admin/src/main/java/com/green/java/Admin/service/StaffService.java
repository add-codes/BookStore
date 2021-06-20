package com.green.java.Admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.java.Admin.dao.staff.StaffRepository;
import com.green.java.Admin.entity.staff.Staff;

@Service
@Transactional
public class StaffService {
	
	@Autowired
	private StaffRepository staffRepository;
	
	public List<Staff> getAllStaff() {
		return (List<Staff>) staffRepository.findAll();
	}
	
	public Staff getStaffByUsername(String username) {
		return staffRepository.getStaffByUsername(username);
	}
	
	public void registerStaffAccount(Staff staff) {
		staff.getStaffUsername();
		staff.getStaffPassword();
		staff.getStaffEmail();
		staff.getStaffStatus();
		
		staffRepository.save(staff);
	}
	
	public void updateStaffPassword(Staff staff) {
		staff.getStaffPassword();
		
		staffRepository.save(staff);
	}
	
	public void updateStaffProfile(Staff staff) {
		staff.getStaffFirstName();
		staff.getStaffLastName();
		staff.getStaffEmail();
		staff.getStaffAge();
		staff.getStaffGender();
		staff.getStaffPhone();
		staff.getStaffAddress();
		
		staffRepository.save(staff);
	}

}

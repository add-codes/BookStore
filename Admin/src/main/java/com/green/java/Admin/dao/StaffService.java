package com.green.java.Admin.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.java.Admin.entity.Staff;

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

}

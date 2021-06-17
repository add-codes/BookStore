package com.green.java.Admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.green.java.Admin.dao.staff.StaffRepository;
import com.green.java.Admin.entity.staff.Staff;
import com.green.java.Admin.helper.Announcement;
import com.green.java.Admin.security.StaffDetails;

public class StaffDetailsService implements UserDetailsService{
	
	@Autowired
	private StaffRepository staffRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Staff staff = staffRepository.getStaffByUsername(username);
		
		System.out.println(" ---------- " + username +" ---------- ");
		
		if (staff == null) {
			System.out.println("loadUserByUsername with not found username");
			throw new UsernameNotFoundException(Announcement.usernameNotFound);
		}
		
		return new StaffDetails(staff);
	}

}

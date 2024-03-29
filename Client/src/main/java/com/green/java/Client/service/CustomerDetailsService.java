package com.green.java.Client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.green.java.Client.dao.CustomerRepository;
import com.green.java.Client.entity.customer.Customer;
import com.green.java.Client.helper.Announcement;
import com.green.java.Client.security.CustomerDetails;

public class CustomerDetailsService implements UserDetailsService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer =  customerRepository.getCustomerByEmail(username);
		
		System.out.println(" ---------- " + customer.getCustomerEmail() + " ---------- ");
		
		if (customer == null) {
			System.out.println("loadUserByUsername with not found first name");
			throw new UsernameNotFoundException(Announcement.usernameNotFound);
		}
		
		return new CustomerDetails(customer);
	}
	
}

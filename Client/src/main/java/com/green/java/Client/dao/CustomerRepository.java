package com.green.java.Client.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.green.java.Client.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query("SELECT customer FROM Customer customer WHERE customer.customerFirstName = :customerFirstName")
	public Customer getCustomerByFirstName(@Param("customerFirstName") String customerFirstName);
	
}

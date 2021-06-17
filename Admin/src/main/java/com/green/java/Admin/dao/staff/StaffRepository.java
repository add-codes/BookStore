package com.green.java.Admin.dao.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.green.java.Admin.entity.staff.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer>{

	@Query("SELECT staff FROM Staff staff WHERE staff.staffUsername = :staffUsername")
	public Staff getStaffByUsername(@Param("staffUsername") String staffUsername);
	
}

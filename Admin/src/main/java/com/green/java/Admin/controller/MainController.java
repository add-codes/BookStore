package com.green.java.Admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.java.Admin.dao.StaffService;
import com.green.java.Admin.entity.staff.Staff;

@Controller
public class MainController {

	@Autowired
	public StaffService staffService;

	@GetMapping("/login")
	public String showLoginPage(Model model) {
//		Staff staff = new Staff();
//		model.addAttribute("ADMIN", staff);
		return "login";
	}
	
//	@PostMapping("/dologin")
//	public String staffLogin(@ModelAttribute("ADMIN") Staff formStaff) {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		Staff staff = staffService.getStaffByUsername(formStaff.getStaffUsername());
//		if (staff != null && encoder.matches(formStaff.getStaffPassword(), staff.getStaffPassword())) {
//			return "redirect:/";
//		} else {
//			return "redirect:/login";
//		}
//	}
	
//	@GetMapping("/500")
//	public String showServerErrorPage() {
//		return "500";
//	}
//	
//	@GetMapping("/404")
//	public String showErrorPage() {
//		return "404";
//	}
//
//	
//	@GetMapping("/403")
//	public String showAccessDeniedPage() {
//		return "403";
//	}


//	@RequestMapping("/")
//	public String home(Model model) {
//		List<Staff> staffList = staffService.getAllStaff();
//		return "adminHome";
//	}

}

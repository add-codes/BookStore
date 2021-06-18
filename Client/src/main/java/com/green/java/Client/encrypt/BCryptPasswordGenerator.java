package com.green.java.Client.encrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordGenerator {

	public static void main(String[] args) {
		BCryptPasswordEncoder encryptPassword = new BCryptPasswordEncoder();
		System.out.println("Password was encrypted: " + encryptPassword.encode("555"));
	}

}

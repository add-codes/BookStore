package com.green.java.Client.handler;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class OnAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String name = authentication.getName();
		Collection<? extends GrantedAuthority> authority = authentication.getAuthorities();
		System.out.println("AuthenticationSuccess: Login Success --- " + name + " --- Go to home page");
		System.out.println("GrantedAuthority: " + authority);
		response.sendRedirect("/");
	}

}

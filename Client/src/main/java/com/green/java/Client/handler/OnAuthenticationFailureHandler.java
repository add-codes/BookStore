package com.green.java.Client.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class OnAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		if (exception instanceof UsernameNotFoundException) {
			UsernameNotFoundException usernameException = (UsernameNotFoundException) exception;
			System.out.println("UsernameNotFoundException: " + usernameException.getMessage());
		}
		
		System.out.println("AuthenticationException: " + exception.getClass().getName());
		System.out.println("AuthenticationFailure: Login Failed");
		
		response.sendRedirect("/500");
	}

}

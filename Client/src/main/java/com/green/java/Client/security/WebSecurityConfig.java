package com.green.java.Client.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.green.java.Client.service.CustomerDetailsService;

@Configuration()
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public CustomerDetailsService customerDetailsService() {
		return new CustomerDetailsService();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/assets/**", "/bootstrap/**", "/css/**", "/fonts/**",
				"/js/**", "/images/**")
			.permitAll();
		//	.anyRequest().authenticated();
		//	.and().formLogin().loginPage("/login").permitAll(); // Admin or Staff must login to access their role page
	}
	
}

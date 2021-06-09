package com.green.java.Admin.security;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.green.java.Admin.service.StaffDetailsService;

@Configuration()
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public StaffDetailsService staffDetailsService() {
		return new StaffDetailsService();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers( "/", "/404", "/500", "/403","/css/**", "/img/**", "/contactform/**", "/lib/**")
			.permitAll().anyRequest().authenticated();
		//	.and().formLogin().loginPage("/login").permitAll(); // Admin or Staff must login to access their role page
	}
	
}

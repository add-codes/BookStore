package com.green.java.Admin.security;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.green.java.Admin.handler.OnAuthenticationFailureHandler;
import com.green.java.Admin.handler.OnAuthenticationSuccessHandler;
import com.green.java.Admin.handler.OnLogoutSuccessHandler;
import com.green.java.Admin.service.StaffDetailsService;

@Configuration()
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private OnLogoutSuccessHandler logoutSuccessHandler;
	
	@Autowired
	private OnAuthenticationSuccessHandler authSuccessHandler;
	
	@Autowired
	private OnAuthenticationFailureHandler authFailureHandler;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public StaffDetailsService staffDetailsService() {
		return new StaffDetailsService();
	}
	
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(staffDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**", "/img/**", "/contactform/**", "/lib/**")
			.permitAll().anyRequest().authenticated()
			.and().formLogin().loginPage("/login").permitAll() // Admin or Staff must login to access their role page
			.usernameParameter("txtUsername")
			.passwordParameter("txtPassword")
			.loginProcessingUrl("/dologin")
			.failureHandler(authFailureHandler)
			.successHandler(authSuccessHandler)
			.and().logout().permitAll()
			.logoutSuccessHandler(logoutSuccessHandler) // After click logout button, staff is navigated to login page
			.and().rememberMe()	// Remember me check box
			.and().exceptionHandling().accessDeniedPage("/404"); 
	}
	
}

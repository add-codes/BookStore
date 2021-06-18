package com.green.java.Client.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.green.java.Client.handler.OnAuthenticationFailureHandler;
import com.green.java.Client.handler.OnAuthenticationSuccessHandler;
import com.green.java.Client.service.CustomerDetailsService;

@Configuration()
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public CustomerDetailsService customerDetailsService() {
		return new CustomerDetailsService();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(customerDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/assets/**", "/bootstrap/**", "/css/**", "/fonts/**",
				"/js/**", "/images/**")
			.permitAll()
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/login").permitAll()
			.usernameParameter("txtEmail")
			.passwordParameter("txtPassword")
			.loginProcessingUrl("/dologin")
			.failureHandler(new OnAuthenticationFailureHandler())
			.successHandler(new OnAuthenticationSuccessHandler())
			.and().exceptionHandling().accessDeniedPage("/404");
	}
	
}

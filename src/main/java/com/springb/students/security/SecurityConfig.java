package com.springb.students.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.springb.students.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	InMemoryUserDetailsManager userDetailsManager() {
		
		return new InMemoryUserDetailsManager();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf()
				.disable()
				.authorizeHttpRequests()
				.antMatchers("/*")
				.permitAll()
				.and()
				.authorizeHttpRequests()
				.antMatchers("/students/**")
				.hasRole("students")
				.and()
				.authorizeHttpRequests()
				.antMatchers("/teachers/**")
				.hasRole("teachers")
				.and()
				.formLogin()
				.and()
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider1 = new DaoAuthenticationProvider();
		authenticationProvider1.setUserDetailsService(userDetailsService());
		authenticationProvider1.setPasswordEncoder(passwordEncoder());
		return authenticationProvider1;
	}
	
	
}

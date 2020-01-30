package com.wildcodeschool.myProjectWithSecurity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class ShieldConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		//.antMatchers("/").hasRole("")
		.antMatchers("/avengers/assemble").hasRole("HERO")
		.antMatchers("/secret-bases").hasRole("DIRECTOR")
		.and()
				// some more method calls
				.formLogin().and().httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser("Steve Guy").password(encoder.encode("pass")).roles("HERO")
		.and()
		.withUser("Tony Stark").password(encoder.encode("pass")).roles("HERO")
		.and()
		.withUser("Nick Fury").password(encoder.encode("123")).roles("DIRECTOR")
		.and()
		.withUser("Stefan").password(encoder.encode("Chef")).roles("HERO","DIRECTOR");

	}

}
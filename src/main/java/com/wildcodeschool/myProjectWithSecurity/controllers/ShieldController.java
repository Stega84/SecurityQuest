package com.wildcodeschool.myProjectWithSecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ShieldController {

	@GetMapping("/")
	public String hello() {
		return "Welcome to Shield";
	}
	
	@GetMapping("/avengers/assemble")
	public String heros() {
		return "Avengers.....Asseebmle";
	}
	
	@GetMapping("/secret-bases")
	public String director(){
		return "Bonn, Darmstadt usw......";
	}
}

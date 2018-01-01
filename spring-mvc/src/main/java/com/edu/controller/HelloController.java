package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private HelloRespository helloRespository;
	
	@RequestMapping("/mvc")
	public String hello() {
		return helloRespository.getHello();
	}
}

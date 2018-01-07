package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.repository.HelloRespository;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private HelloRespository helloRespository;
	
	public HelloController() {
		System.out.println("---HelloController 被容器初始化了。---------------");
	}
	
	@RequestMapping("/mvc")
	public String hello() {
		return helloRespository.getHello();
	}
}

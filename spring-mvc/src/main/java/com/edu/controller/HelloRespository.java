package com.edu.controller;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRespository {

	public String getHello() {
		return "hello";
	}
	
}

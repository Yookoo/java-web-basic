package com.edu.repository;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRespository {

	public HelloRespository() {
		System.out.println("-----HelloRespository 被容器初始化了。------------------------");
	}
	public String getHello() {
		return "hello";
	}
	
}

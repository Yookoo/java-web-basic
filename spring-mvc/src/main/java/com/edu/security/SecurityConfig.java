package com.edu.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity //启用安全配置
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	/**
	 * 配置用户存储；
	 * 指定哪些请求需要认证，哪些请求不需要认证，以及所需要的权限；
	 * 提供一个自定义的登录页面，替代原来简单的默认登录页。
	 * @throws Exception 
	 * 
	 */
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
			.withUser("user").password("password").roles("USER").and()
			.withUser("admin").password("password").roles("USER","ADMIN");
	}
	

}

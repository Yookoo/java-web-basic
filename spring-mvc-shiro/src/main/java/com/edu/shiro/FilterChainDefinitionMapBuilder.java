package com.edu.shiro;

import java.util.LinkedHashMap;

/**
 * 管理不同页面的访问权限
 * @author zhu
 *
 */
public class FilterChainDefinitionMapBuilder {

	public LinkedHashMap<String, String> build() {
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("/login.jsp", "anon");
		map.put("/shiro/login", "anon");
		map.put("/shiro/logout", "logout");
		map.put("/user.jsp", "roles[user]");
		map.put("/admin.jsp", "roles[admin]");
		map.put("/**", "authc");
		return map;
	}
}

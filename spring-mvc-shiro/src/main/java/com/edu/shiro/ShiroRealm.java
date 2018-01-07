package com.edu.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
/**
 * ShiroRealm 
 * @author zhu
 *
 */
public class ShiroRealm extends AuthorizingRealm {
	
	
	
	/**
	 * 	认证方法
	 * 
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("AuthenticationToken:"+ token);
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		if("unknown".equals(username)) {
			throw new UnknownAccountException("用户不存在！");
		}
		if ("monster".equals(username)) {
			throw new LockedAccountException("用户被锁定！");
		}
		Object principal = username;
		
		Object credentials = "8e56a40e92622217019f774aa9d9afdc";
		
		String realmName = super.getName();
		
		AuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realmName);
		return info;
	}
	
	/**
	 * Authorizing : 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("doGetAuthorizationInfo:"+ principals);
		/**
		 * 获取用户信息。
		 */
		Object principal = principals.getPrimaryPrincipal();
		
		/**
		 * 授权
		 */
		Set<String> roles = new HashSet<>();
		roles.add("user");
		if ("admin".equals(principal)) {
			roles.add("admin");
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		return info;
	}

	

}

package com.edu.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Test {

	public static void main(String[] args) {
		int hashIterations=5;
		Object salt=null;
		Object credentials="123456";
		String hashAlgorithmName="MD5";
		Object result = new SimpleHash(hashAlgorithmName,credentials ,salt, hashIterations);
		System.out.println("MD5:"+ result);
	}
}

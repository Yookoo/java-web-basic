package com.css.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(new Date());
		System.out.println(dateString.toString());
	}

}

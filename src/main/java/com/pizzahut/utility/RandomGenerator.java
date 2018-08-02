package com.pizzahut.utility;

import java.util.Random;

public class RandomGenerator {

	private static final String char_list="a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,w,x,w,z";
	private static final int char_length= 10;
	
	public static String getRandomString() {
		StringBuffer strbuff = new StringBuffer();
		for(int i =0; i<char_length; i++) 
		{
			int number = getRandomNumber();
			char ch = char_list.charAt(number);
			strbuff.append(ch);
		}
		return strbuff.toString();
	}
	
	
	public static int getRandomNumber() {
		int randomInt =0;
		Random randomnumber = new Random();
		randomInt =randomnumber.nextInt(char_list.length());
		
		if(randomInt -1 == -1) 
		{
		return randomInt -1;
		} else {
	     return randomInt;	 	
	   }	
    }
 }

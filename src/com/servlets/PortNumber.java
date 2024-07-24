package com.servlets;

import java.util.Random;

public class PortNumber {

	public static String getPort(){
		String num = "0123456789";
		Random rnd = new Random();
		char [] otp = new char[5];
		for(int i = 0; i < otp.length; i++){
			otp[i] = num.charAt(rnd.nextInt(num.length()));
		}
		String p = new String(otp);
		return p;
	}

	public static String getUserKey() {
		// TODO Auto-generated method stub
		String num = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		char [] otp = new char[6];
		for(int i = 0; i < otp.length; i++){
			otp[i] = num.charAt(rnd.nextInt(num.length()));
		}
		String p = new String(otp);
		return p;
	}

	public static String getKeys1() {
		// TODO Auto-generated method stub
		String num = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		char [] otp = new char[16];
		for(int i = 0; i < otp.length; i++){
			otp[i] = num.charAt(rnd.nextInt(num.length()));
		}
		String p = new String(otp);
		return p;
	}
	public static String getKeys() {
		// TODO Auto-generated method stub
		String num = "0123456789abcdefghijklSTUVWXYZ";
		Random rnd = new Random();
		char [] otp = new char[16];
		for(int i = 0; i < otp.length; i++){
			otp[i] = num.charAt(rnd.nextInt(num.length()));
		}
		String p = new String(otp);
		return p;
	}
	public static String getTrapdoorKeys() {
		// TODO Auto-generated method stub
		String num = "0123456789abcdefghijklSTUVWXYZuvwxyz";
		Random rnd = new Random();
		char [] otp = new char[16];
		for(int i = 0; i < otp.length; i++){
			otp[i] = num.charAt(rnd.nextInt(num.length()));
		}
		String p = new String(otp);
		return p;
	}
	public static String getUserPk() {
		// TODO Auto-generated method stub
		String num = "0123456789abcdefghijklSTUVWXYZuvwxyz";
		Random rnd = new Random();
		char [] otp = new char[7];
		for(int i = 0; i < otp.length; i++){
			otp[i] = num.charAt(rnd.nextInt(num.length()));
		}
		String p = new String(otp);
		return p;
	}
	public static String getMk() {
		// TODO Auto-generated method stub
		String num = "0123456789abcdefghijklSTUVWXYZuvwxyz";
		Random rnd = new Random();
		char [] otp = new char[7];
		for(int i = 0; i < otp.length; i++){
			otp[i] = num.charAt(rnd.nextInt(num.length()));
		}
		String p = new String(otp);
		return p;
	}
	public static String getCSPPk() {
		// TODO Auto-generated method stub
		String num = "0123456789abcdefghijklSTUVWXYZuvwxyz";
		Random rnd = new Random();
		char [] otp = new char[7];
		for(int i = 0; i < otp.length; i++){
			otp[i] = num.charAt(rnd.nextInt(num.length()));
		}
		String p = new String(otp);
		return p;
	}
}

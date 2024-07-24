package com.dao;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.ECGenParameterSpec;
import java.util.Random;

public class RandomeString {
	String pub_bYte, msk_bYte,prv_bYte;
	public static String getSaltString() {
        String SALTCHARS = "0123456789abcdefghijklSTUVWXYZuvwxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

	public static String getAccNO() {
        String SALTCHARS = "123456789012345678901234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

	public static String getFid() {
        String SALTCHARS = "123456789012345678901234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

	public static String getMasterKey() {
        String SALTCHARS = "1234567890abcdefghi";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	public static String getSecretKey() {
        String SALTCHARS = "1234567890abcdefghi";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	public void setUp(){
		 KeyPairGenerator kpg;
		 try{
		 kpg = KeyPairGenerator.getInstance("EC","SunEC");
		 ECGenParameterSpec ecsp;
		 ecsp = new ECGenParameterSpec("sect163k1");
		 
		 kpg.initialize(ecsp);

		 KeyPair kp = kpg.genKeyPair();
		 PrivateKey privKey = kp.getPrivate();
		 PublicKey pubKey = kp.getPublic();
		 }catch(Exception e){}
		 }
	public static String getPrivateKey() {
	        String SALTCHARS = "678rstuvwxyz590abcdefg1234pqhijk";
	        StringBuilder salt = new StringBuilder();
	        Random rnd = new Random();
	        while (salt.length() < 5) { // length of the random string.
	            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	            salt.append(SALTCHARS.charAt(index));
	        }
	        String saltStr = salt.toString();
	        return saltStr;

	    }
	public void setUpTrapdoor(){
		 KeyPairGenerator kpg;
		 try{
		 kpg = KeyPairGenerator.getInstance("EC","SunEC");
		 ECGenParameterSpec ecsp;
		 ecsp = new ECGenParameterSpec("sect163k1");
		 
		 kpg.initialize(ecsp);

		 KeyPair kp = kpg.genKeyPair();
		 PrivateKey privKey = kp.getPrivate();
		 PublicKey pubKey = kp.getPublic();
		 }catch(Exception e){}
		 }
	public static String getTrapdoorKey() {
        String SALTCHARS = "1234567890abcdefghiABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
}

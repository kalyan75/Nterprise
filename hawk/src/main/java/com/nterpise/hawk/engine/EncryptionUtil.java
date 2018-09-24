package com.nterpise.hawk.engine;



import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptionUtil  {
	
	
	public static String decrypt (String encryptedText, String passPhrase) {
		StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
		decryptor.setPassword(passPhrase);
		String decryptedText = decryptor.decrypt(encryptedText);
		return decryptedText;
	}

	public static String encrypt (String pass, String passPhrase) {
		StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
		decryptor.setPassword(passPhrase);
		String decryptedText = decryptor.encrypt(pass);
		System.out.println(decryptedText);
		return decryptedText;
	}
	
	public static void main (String arg[]) {
		
		
	}

}
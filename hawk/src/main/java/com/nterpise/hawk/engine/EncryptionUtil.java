package com.nterpise.hawk.engine;



import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptionUtil  {
	
	
	public static String decrypt (String encryptedText, String passPhrase) {
		StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
		decryptor.setPassword(passPhrase);
		String decryptedText = decryptor.decrypt(encryptedText);
		return decryptedText;
	}


}
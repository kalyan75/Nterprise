package com.vha.middleware.matrix;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import com.jcraft.jsch.UserInfo;

public class EncryptionUtil  {
	
	public static String encrypt (String key, String salt) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword("J@ycr@ftR0ck$");
		String encryptedText = encryptor.encrypt(key);
		System.out.println("Encrypted text is: " + encryptedText);
		return encryptedText;
	}
	
	public static String decrypt (String encryptedText) {
		StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
		decryptor.setPassword("J@ycr@ftR0ck$");
		String decryptedText = decryptor.decrypt(encryptedText);
		return decryptedText;
	}

	public static void main(String arg[]) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword("J@ycr@ftR0ck$");
		String encryptedText = encryptor.encrypt("");
		System.out.println("Encrypted text is: " + encryptedText);

		StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
		decryptor.setPassword("J@ycr@ftR0ck$");
		String decryptedText = decryptor.decrypt(encryptedText);
		System.out.println("Decrypted text is: " + decryptedText);

	}

}
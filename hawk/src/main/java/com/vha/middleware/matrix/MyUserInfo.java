package com.vha.middleware.matrix;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import com.jcraft.jsch.UserInfo;

public class MyUserInfo implements UserInfo {

	private String userName;
	private String password;
	
	public MyUserInfo(String user, String password) {
		this.userName = user;
		this.password = password;
	}

	public String getPassphrase() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return "Kalyan77";
	}

	public boolean promptPassphrase(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean promptPassword(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean promptYesNo(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void showMessage(String arg0) {
		// TODO Auto-generated method stub

	}

	public static void main(String arg[]) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword("J@ycr@ftR0ck$");
		String encryptedText = encryptor.encrypt("Kalyan77");
		System.out.println("Encrypted text is: " + encryptedText);

		StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
		decryptor.setPassword("J@ycr@ftR0ck$");
		String decryptedText = decryptor.decrypt(encryptedText);
		System.out.println("Decrypted text is: " + decryptedText);

	}

}
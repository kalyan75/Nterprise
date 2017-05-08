package com.nterpise.hawk.engine;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import com.jcraft.jsch.UserInfo;


/**
 * 
 * @author Kalyan
 *
 */
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
		return password;
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

	}

}
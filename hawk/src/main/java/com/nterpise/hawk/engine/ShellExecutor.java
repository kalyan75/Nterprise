package com.nterpise.hawk.engine;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.jcraft.jsch.JSchException;

/**
 * 
 * @author Kalyan Ramakrishnan
 *
 */
public class ShellExecutor implements Runnable {
	private static String USER = null;
	private static String PASSPHRASE = null;
	private static String PASS = null;
	private String host;
	private String command;

	

	

	// ThreadLocal<String> cache = new Thread
	public ShellExecutor(String host, String command, String user, String passphrase, String password) {
		this.host = host;
		this.command = command;
		USER = user;
		PASSPHRASE = passphrase;
		PASS = password;
	}

	public void run() {
		try {
			executeShell(host, command);
		} catch (JSchException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void executeShell(String host, String command) throws JSchException, IOException {
		String pass = EncryptionUtil.decrypt(PASS, PASSPHRASE);

		String result = new SearchUtil().search(USER, host, command, pass);
	}

}

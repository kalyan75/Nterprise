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

	
	
	static {
		InputStream input = null;
		try {
			input = Thread.currentThread().getContextClassLoader().getResourceAsStream("hawk.properties");
			Properties props = new Properties();
			props.load(input);
			USER = props.getProperty("hawk.username");
			PASSPHRASE = props.getProperty("hawk.passphrase");
			PASS = props.getProperty("hawk.encrypted.password");
			// _config.load(input);
		} catch (Exception ex) {

		}
	}
	

	// ThreadLocal<String> cache = new Thread
	public ShellExecutor(String host, String command) {
		this.host = host;
		this.command = command;
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

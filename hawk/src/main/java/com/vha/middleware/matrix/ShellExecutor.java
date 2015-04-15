package com.vha.middleware.matrix;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class ShellExecutor implements Runnable {
	
	private static final String USER = "KRMAKRIS";
	private static final String PASSWORD = "nDGLPb2+lra5sUwh63nwhUf2do3SLGtB";
	private String host;
	private String command;
	
	public ShellExecutor (String host, String command) {
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

	private void executeShell(String host, String command)
			throws JSchException, IOException {
		JSch jsch = new JSch();
		Session session = jsch.getSession("KRMAKRIS", host, 22);
		session.setConfig("StrictHostKeyChecking", "no");
		session.setPassword(EncryptionUtil.decrypt(PASSWORD));
		session.connect();
		Channel channel = session.openChannel("exec");
		((ChannelExec) channel).setCommand(command);
		channel.setInputStream(null);
		((ChannelExec) channel).setErrStream(System.err);
		InputStream in = channel.getInputStream();
		channel.connect();
		print(host, command, in);
		channel.disconnect();
		session.disconnect();
	}

	private void print(String host, String command, InputStream in)
			throws IOException {
		System.out.println("================================================================================================");
		System.out.println("Searching "+host+", command: "+command+"\n"+ IOUtils.toString(in));
		System.out.println("================================================================================================");
	}
}

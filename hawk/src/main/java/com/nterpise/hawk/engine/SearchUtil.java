package com.nterpise.hawk.engine;


import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

/**
 * 
 * @author Kalyan Ramakrishnan
 * 
 *
 */
public class SearchUtil {
	
	public static String search (String user, String host, String command, String password) throws JSchException, IOException {
		JSch jsch = new JSch();
		Session session = jsch.getSession(user, host, 22);
		session.setConfig("StrictHostKeyChecking", "no");
		session.setPassword(password);
		session.connect();
		Channel channel = session.openChannel("exec");
		((ChannelExec) channel).setCommand(command);
		channel.setInputStream(null);
		((ChannelExec) channel).setErrStream(System.err);
		InputStream in = channel.getInputStream();
		channel.connect();
		String result = IOUtils.toString(in);
		System.out.println("================================================================================================");
		System.out.println("Searching "+host+", command: "+command+"\n"+ result);
		System.out.println("================================================================================================");
		channel.disconnect();
		session.disconnect();
		return result;
	}


}
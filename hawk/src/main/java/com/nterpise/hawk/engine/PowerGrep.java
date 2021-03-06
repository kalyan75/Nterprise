package com.nterpise.hawk.engine;

import java.io.InputStream;
/* -*-mode:java; c-basic-offset:2; indent-tabs-mode:nil -*- */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author Kalyan Ramakrishnan
 *
 */
public class PowerGrep {

	private static String servers;
	private static String command;
	private static String USER = null;
	private static String PASSPHRASE = null;
	private static String PASS = null;

	static {
		InputStream input = null;
		try {
			input = Thread.currentThread().getContextClassLoader().getResourceAsStream("hawk.properties");
			Properties props = new Properties();
			props.load(input);
			servers = props.getProperty("server.elastic.prod");
			setCommand(props.getProperty("hawk.log.grep.command1"));
			USER = props.getProperty("hawk.username");
			PASSPHRASE = props.getProperty("hawk.passphrase");
			PASS = props.getProperty("hawk.encrypted.password");
			// _config.load(input);
		} catch (Exception ex) {

		}
	}

	public static void main(String[] arg) {
		
		long time = System.currentTimeMillis();
		try {
			ArrayList<String> hosts = getServers();
			ExecutorService executor = Executors.newFixedThreadPool(hosts.size());
            
			for (Iterator<String> iterator = hosts.iterator(); iterator.hasNext();) {
				String host = (String) iterator.next();
				Runnable worker = new ShellExecutor(host, getCommand(), USER, PASSPHRASE, PASS);
	            executor.execute(worker);
			}
	        executor.shutdown();
	        while (!executor.isTerminated()) {
	        }
	        System.out.println("Finished all threads");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println((System.currentTimeMillis() - time));
	}

	private static ArrayList<String> getServers() {
		String[] hosts = servers.split(",");
		return new ArrayList<String>(Arrays.asList(hosts));
	}

	public static String getCommand() {
		return command;
	}

	public static void setCommand(String command) {
		PowerGrep.command = command;
	}



}

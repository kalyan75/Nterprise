package com.vha.middleware.matrix;

/* -*-mode:java; c-basic-offset:2; indent-tabs-mode:nil -*- */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PowerGrep {

	public static void main(String[] arg) {
		
		long time = System.currentTimeMillis();
		try {
			ArrayList<String> talendHosts = talendServers();
			//String command = "ls -lrt /tmp";
			//String command = "awk -- 'NR > 20'   /opt/talend/Talend-Runtime-V5.3.1/log/tesb.log";
			String command = "grep 'Exception:'   /opt/talend/Talend-Runtime-V5.3.1/log/*.log";
			ExecutorService executor = Executors.newFixedThreadPool(talendHosts.size());
            
			for (Iterator<String> iterator = talendHosts.iterator(); iterator.hasNext();) {
				String host = (String) iterator.next();
				Runnable worker = new ShellExecutor(host, command);
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

	private static ArrayList<String> talendServers() {
		ArrayList<String> talendHosts = new ArrayList<String>();
		talendHosts.add("tj1-51");
		talendHosts.add("tj2-51");
		talendHosts.add("tr1-51");
		talendHosts.add("tr2-51");
		return talendHosts;
	}



}
package com.nterpise.hawk.bean;


import java.util.List;



public class SearchResult {
	private String serverName;
	private List<Command> commandResults;
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public List<Command> getCommandResults() {
		return commandResults;
	}
	public void setCommandResults(List<Command> commandResults) {
		this.commandResults = commandResults;
	}
	
	
	
}
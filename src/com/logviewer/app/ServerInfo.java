package com.logviewer.app;

public class ServerInfo {

	String name;
	String logFileName;
	String systemProperty;

	public ServerInfo(String name, String systemProperty, String logFileName) {
		this.name = name;
		this.systemProperty = systemProperty;
		this.logFileName = logFileName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogFileName() {
		return logFileName;
	}

	public void setLogFileName(String logFileName) {
		this.logFileName = logFileName;
	}

	public String getSystemProperty() {
		return systemProperty;
	}

	public void setSystemProperty(String systemProperty) {
		this.systemProperty = systemProperty;
	}

}

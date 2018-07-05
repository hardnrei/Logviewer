package com.logviewer.common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.logviewer.app.ServerInfo;

public class Constant {

	private static final List<ServerInfo> serverInfoList = new ArrayList<>();

	static {
		serverInfoList.add(new ServerInfo("TOMCAT", "catalina.home", File.separator + "logs" + File.separator + "catalina.out"));
		serverInfoList.add(new ServerInfo("JBOSS", "jboss.server.log.dir", File.separator + "server.log"));
	}

	public static List<ServerInfo> getServerinfolist() {
		return serverInfoList;
	}

}

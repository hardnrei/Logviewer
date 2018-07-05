package com.logviewer.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.logviewer.common.Constant;

public class LoadOnStartUpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	static Logger logger = Logger.getLogger(LoadOnStartUpServlet.class);

	public void init() {

		InputStream configStream = this.getClass().getResourceAsStream("config.properties");
		Properties configProperty = new Properties();
		try {
			configProperty.load(configStream);
		} catch (IOException e) {

			e.printStackTrace();
		}

		Config.setLOG_PATH(configProperty.getProperty("LOG_PATH") == null ? "" : configProperty.getProperty("LOG_PATH").trim());

		Config.setLINE_COUNT(Integer.parseInt(configProperty.getProperty("LINE_COUNT") == null ? "15000" : configProperty.getProperty("LINE_COUNT").trim()));
		Config.setINTERVAL_SECOND(Integer.parseInt(configProperty.getProperty("INTERVAL_SECOND") == null ? "300" : configProperty.getProperty("INTERVAL_SECOND").trim()));
		Config.setHIGHTLIGHT_TEXT(configProperty.getProperty("HIGHTLIGHT_TEXT") == null ? "error,Error,Caused by,Exception" : configProperty.getProperty("HIGHTLIGHT_TEXT").trim());
		Config.setHIGHTLIGHT_TEXT_ARRAY(Config.getHIGHTLIGHT_TEXT().split(","));

		logger.info("------- LOAD PROPERTIES * ---------------");
		logger.info("LOG_PATH                : " + Config.getLOG_PATH());
		logger.info("LINE_COUNT              : " + Config.getLINE_COUNT());
		logger.info("INTERVAL_SECOND         : " + Config.getINTERVAL_SECOND());
		logger.info("HIGHTLIGHT_TEXT         : " + Config.getHIGHTLIGHT_TEXT());
		logger.info("HIGHTLIGHT_TEXT LENGTH  : " + Config.getHIGHTLIGHT_TEXT_ARRAY().length);

		logger.info("");

		/* Determine log file location */
		if (Config.getLOG_PATH().isEmpty()) {

			String serverName = getServletContext().getServerInfo().toUpperCase();
			logger.info("Detected server : " + serverName);
			for (ServerInfo serverInfo : Constant.getServerinfolist()) {
				if (serverName.contains(serverInfo.getName())) {

					Config.setLOG_PATH(System.getProperty(serverInfo.getSystemProperty()) + serverInfo.getLogFileName());
				}
			}

		}
		logger.info("PATH LOG USED WILL BE  : " + Config.getLOG_PATH());
		logger.info("");
	}
}

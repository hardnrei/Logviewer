package com.logviewer.app;

public class Config {

	private static String LOG_PATH;
	private static Integer LINE_COUNT;
	private static Integer INTERVAL_SECOND;
	private static String HIGHTLIGHT_TEXT;
	private static String[] HIGHTLIGHT_TEXT_ARRAY;

	public static String getLOG_PATH() {
		return LOG_PATH;
	}

	public static void setLOG_PATH(String lOG_PATH) {
		LOG_PATH = lOG_PATH;
	}

	public static Integer getLINE_COUNT() {

		return LINE_COUNT;
	}

	public static void setLINE_COUNT(Integer lINE_COUNT) {

		LINE_COUNT = lINE_COUNT;
	}

	public static Integer getINTERVAL_SECOND() {

		return INTERVAL_SECOND;
	}

	public static void setINTERVAL_SECOND(Integer iNTERVAL_SECOND) {

		INTERVAL_SECOND = iNTERVAL_SECOND;
	}

	public static String getHIGHTLIGHT_TEXT() {

		return HIGHTLIGHT_TEXT;
	}

	public static void setHIGHTLIGHT_TEXT(String hIGHTLIGHT_TEXT) {

		HIGHTLIGHT_TEXT = hIGHTLIGHT_TEXT;
	}

	public static String[] getHIGHTLIGHT_TEXT_ARRAY() {

		return HIGHTLIGHT_TEXT_ARRAY;
	}

	public static void setHIGHTLIGHT_TEXT_ARRAY(String[] hIGHTLIGHT_TEXT_ARRAY) {

		HIGHTLIGHT_TEXT_ARRAY = hIGHTLIGHT_TEXT_ARRAY;
	}

}

package com.logviewer.app;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;

@SuppressWarnings("deprecation")
public class ViewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ViewServlet() {

		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StringBuilder logContent = new StringBuilder();
		File crunchifyFile = new File(Config.getLOG_PATH());
		RandomAccessFile readFileAccess = new RandomAccessFile(crunchifyFile, "r");
		Long length = crunchifyFile.length();

		readFileAccess.seek(length - Config.getLINE_COUNT());

		String crunchifyLine = null;
		while ((crunchifyLine = readFileAccess.readLine()) != null) {
			logContent.append(StringEscapeUtils.escapeHtml4(crunchifyLine)).append("<br/>");
		}

		String log = highlightedText(logContent.toString());

		response.getWriter().print(log);
		readFileAccess.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	private String highlightedText(String str) {

		for (String text : Config.getHIGHTLIGHT_TEXT_ARRAY()) {
			str = str.replace(text, "<span class='hlight'>" + text + "</span>");
		}
		return str;
	}

}

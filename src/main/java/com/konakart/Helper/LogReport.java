package com.konakart.Helper;

import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.lf5.LogRecordFilter;

/**
 * Log Report:This will show status of exection.
 * 
 * @author indira.saravanan
 *
 */

public class LogReport {
	Logger logger = null;

	// This will give info of exection.
	public void logReport(String message) {
		PropertyConfigurator.configure(Constants.LOG_PATH);
		logger = Logger.getLogger(LogRecordFilter.class.getName());
		logger.info(message);
	}
}

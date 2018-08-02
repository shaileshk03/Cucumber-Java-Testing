package com.pizzahut.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeHelper {

	public static String getCurrentDateAndTime() {
		DateFormat dateformat = new SimpleDateFormat("_yyyy-mm-dd_HH-mm-ss");
		Calendar cal = Calendar.getInstance();
		String time ="" + dateformat.format(cal.getTime());
		return time;
	}
	
	public static String getCurrentDate() {
		return getCurrentDateAndTime().substring(0, 11);
	}
	
}

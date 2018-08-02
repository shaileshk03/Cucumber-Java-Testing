package com.pizzahut.helper.Logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.pizzahut.utility.ResourceHelper;

public class LoggerHelper {

	private static boolean root = false;

	public static Logger getLogger(Class clas) {

		if (root) {
			return Logger.getLogger(clas);
		}

		PropertyConfigurator
				.configure(ResourceHelper.getResourcePath("/src/main/resources/configfile/log4j.properties"));
		root = true;
		return Logger.getLogger(clas);
	}

}

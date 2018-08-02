package com.pizzahut.configReader;

import java.util.Properties;

import com.pizzahut.configureBrowser.BrowserType;
import com.pizzahut.utility.ResourceHelper;

public class PropertyFileReader implements configReader {

	private Properties prop = null;

	public PropertyFileReader() {
		prop = new Properties();
		try {
			prop.load(
			ResourceHelper.getResourcePathInputStream("\\src\\main\\resources\\configfile\\config.properties"));
		} catch (Exception e) {
		}
	}

	public String getWebsite() {
		return prop.getProperty("Website");
	}

	public BrowserType getBrowser() {
		return BrowserType.valueOf(prop.getProperty("Browser"));
	}

	public int getPageLoadTimeOut() {
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(prop.getProperty("ImplcitWait"));
	}

	public int getImplicitWait() {
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}

	public String getPassword() {
		return prop.getProperty("Password");
	}

	public String getUserName() {
		return prop.getProperty("Username");
	}

}

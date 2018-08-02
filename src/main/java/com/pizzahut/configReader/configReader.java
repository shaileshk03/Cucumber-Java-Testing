package com.pizzahut.configReader;

import com.pizzahut.configureBrowser.BrowserType;

public interface configReader {	

	public String getWebsite();
	public BrowserType getBrowser();
	public int getPageLoadTimeOut();
	public int getExplicitWait();
	public int getImplicitWait();
	public String getPassword();
	public String getUserName();
		
 }

package com.pizzahut.helper.AssertionHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.pizzahut.helper.Logger.LoggerHelper;

public class verificationHelper {

	private static final Logger log = LoggerHelper.getLogger(verificationHelper.class);
	

	public static synchronized boolean verifyElementPresent(WebElement element) {
		boolean isDisplayed = false;
		try {
			isDisplayed = element.isDisplayed();
	        log.info(element.getText());
		} catch (Exception e) {
		  log.error("Element Not Found" + e);
		}
		return isDisplayed;
	}
	
	
	public static synchronized boolean verifyElementNotPresent(WebElement element) {
		boolean isDisplayed = false;
		try {
			isDisplayed = element.isDisplayed();
			log.info(element.getText());
		} catch (Exception e) {
			isDisplayed  = true;
		}
		
	return isDisplayed;
	}
	
	


	
	
}

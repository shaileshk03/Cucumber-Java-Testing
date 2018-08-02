package com.pizzahut.helper.Alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pizzahut.helper.Logger.LoggerHelper;

public class AlertHelper {

	WebDriver driver;
	Logger log = LoggerHelper.getLogger(AlertHelper.class);
	
	
	public AlertHelper(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Alert getAlert() {
	return driver.switchTo().alert();
	}
	
	public void AcceptAlert() {
		getAlert().accept();
	}
	
	public void DismissAlert() {
		getAlert().dismiss();
	}
	
	
    public String getAlertText() {
    String text = getAlert().getText();
    return text;
    }
	
    public boolean isAlertPresent() {
    	try {
			driver.switchTo().alert();
			log.info("true");
			return true;
		} catch (NoAlertPresentException e) {
			log.info("false");
			return false;
		}	
    }
    
    public void AcceptAlertIfPresent() {
    	if(!isAlertPresent())
    	return;
    	AcceptAlert();
    }
    
    public void DismissAlertIfPresent() {
    	if(!isAlertPresent())
    	return;
    	DismissAlert();
    }
    
    public void AcceptPrompt(String text) {
    	if(!isAlertPresent())
        	return;
    	Alert alert = getAlert();
    	alert.sendKeys(text);
        alert.accept();
    }
    
    
}

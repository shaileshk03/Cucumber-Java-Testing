package com.pizzahut.helper.Browser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.pizzahut.helper.Logger.LoggerHelper;


public class BrowserHelper {

	private WebDriver driver;
    private Logger log = LoggerHelper.getLogger( BrowserHelper.class);	
	
    public BrowserHelper(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		log.debug("BrowserHelper : " +this.driver.hashCode());
	}
	
    public void goForward() {
    	driver.navigate().forward();
    }
    
    public void goBack() {
    	driver.navigate().back();
    }
    
	public void refresh() {
	   driver.navigate().refresh();
	}
	
	public void reSizeBrowser() {
		Dimension d = new Dimension(800, 480);
		driver.manage().window().setSize(d);
	}
	
	public Point getLocation(WebElement element) {
		return element.getLocation();
	}
	
	public Set<String> getWindowHandles(){
		return driver.getWindowHandles();
	}
	
	public void switchTOWindow(int index) {
	  LinkedList<String> windowId = new LinkedList<String>(getWindowHandles()); 
	  if(index < 0 || index > windowId.size())
		  throw new IllegalArgumentException("Invalid Index " + index);
	   driver.switchTo().window(windowId.get(0));
	   log.info(index);
	}
	
	public void switchTOParentWindow() {
		LinkedList<String> windowId = new LinkedList<String>(getWindowHandles());
		driver.switchTo().window( windowId.get(0));
	}
	
	public void switchToParentWithChildClose() {
		switchTOParentWindow();
		LinkedList<String> windowId = new LinkedList<String>(getWindowHandles());
		for(int i =1 ; i < windowId.size(); i++) {
			driver.switchTo().window(windowId.get(i));
			driver.close();
		}
	}
	
	public void switchTOFrame(String nameOrID) {
		driver.switchTo().frame(nameOrID);
	}
	
	public ArrayList<String> tagCount(){
		return new ArrayList<String>(driver.getWindowHandles());
	}
	
	
}

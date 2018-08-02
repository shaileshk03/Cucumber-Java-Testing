package com.pizzahut.helper.DropDown;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.pizzahut.helper.Logger.LoggerHelper;

public class dropDownHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(dropDownHelper.class);
	
	public dropDownHelper(WebDriver driver) {
		this.driver=driver;
	    PageFactory.initElements(driver, this);
	}
	
	public void selectUsingVisibleValue(WebElement element, String VisibleValue) {
		Select select = new Select(element);
	    select.selectByVisibleText(VisibleValue);
	    log.info("Locator :" + element + "VisibleValue" + VisibleValue);
	}
	
	public String getSelectedValue(WebElement element) {
		String value = new Select(element).getFirstSelectedOption().getText();
		log.info("element :" + element + "value : "+ value);
		return value;
	}
	
	public void selectUsingIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
		log.info("Element : " + element + "Index "+ index);
	}
	
	public void selectUsingValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
		log.info("Element : " + element + "value" + value);
	}
	
	public List<String> getAllDropDownValues(WebElement locator) {
		Select select = new Select(locator);
		List<WebElement> elementList = select.getOptions();
	    List<String> valueList = new LinkedList<String>();  
	    for(WebElement element : elementList) {
	    	valueList.add(element.getText());
	    }
	 return valueList;
	}
	
	 public void selectDate(By locator, String day) {
		 List<WebElement> days = driver.findElements(locator);
		 Iterator<WebElement> itr = days.iterator();
		 while(itr.hasNext()) {
			 WebElement click = itr.next();
			String text = click.getText().trim().toString();
			if(text.equals(days)) {
				log.info(day);
				click.click();
			 break;
			}
		 }
	 }
	
	 public void selectMonth(By locator, String Month) {
		 List<WebElement> month = driver.findElements(locator);
		 Iterator<WebElement> itr = month.iterator();
		 while(itr.hasNext()) {
			 WebElement pickMonth = itr.next();
			 String text = pickMonth.getText().trim().toString();
			 if(text.equals(Month)) {
				 pickMonth.click();
				 break;
			 }
		 }
	 }
	 
	 public void selectYear(By locator, String Year) {
		 List<WebElement> year = driver.findElements(locator);
		 Iterator<WebElement> itr = year.iterator();
		 while(itr.hasNext()) {
		  WebElement pickYear = itr.next();
		  String text = pickYear.getText().trim().toString();
		  if(text.equals(Year)) {
			  pickYear.click();
			  break;
		  }
		 }
	  }
	 
	 public void uploadPicture(WebElement locator, String path) throws AWTException {
		locator.click();
	   try {
			StringSelection select = new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		    Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
		}
	 }
	 
}

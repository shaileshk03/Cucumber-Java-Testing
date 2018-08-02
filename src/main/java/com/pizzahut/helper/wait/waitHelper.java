package com.pizzahut.helper.wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pizzahut.helper.Logger.LoggerHelper;

public class waitHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(waitHelper.class);

	
	public waitHelper(WebDriver driver) {
		this.driver = driver;
		log.debug("waitHelper :" + this.driver.hashCode());
	}
	
	public void setImplicitWait(long timeout, TimeUnit unit) {
		log.info(timeout);
	  	driver.manage().timeouts().implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
	}
	
	public WebDriverWait getWait(int timeOutInSeconds, int PollingEveryMillSec) {
	 log.debug("");
	 WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
	 wait.pollingEvery(PollingEveryMillSec, TimeUnit.MILLISECONDS);
	 wait.ignoring(NoSuchElementException.class);
	 wait.ignoring(ElementNotVisibleException.class);
	 wait.ignoring(StaleElementReferenceException.class);
	 wait.ignoring(NoSuchFrameException.class);
	 return wait;
	 }
	
	public void waitForElementVisible(WebElement locator, int timeOutInSeconds, int PollingEveryInMillSec) {
	 WebDriverWait wait = getWait(timeOutInSeconds, PollingEveryInMillSec);
	 wait.until(ExpectedConditions.visibilityOf(locator));	
	}
	
	public WebElement waitForElement(WebDriver driver, long time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElement(WebDriver driver, WebElement element, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver ,timeout);
	    wait.until(ExpectedConditions.visibilityOf(element));
	 }
}

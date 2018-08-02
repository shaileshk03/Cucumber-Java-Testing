package com.pizzahut.helper.TestBase;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.pizzahut.configReader.ObjectRepo;
import com.pizzahut.configReader.PropertyFileReader;
import com.pizzahut.configureBrowser.BrowserType;
import com.pizzahut.configureBrowser.ChromeBrowser;
import com.pizzahut.configureBrowser.FirefoxBrowser;
import com.pizzahut.helper.Logger.LoggerHelper;
import com.pizzahut.utility.ResourceHelper;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestBase {

	private final Logger log = LoggerHelper.getLogger(TestBase.class);
	public static WebDriver driver;
		
	public void waitForElement(WebElement element, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	    wait.ignoring(NoSuchElementException.class);
	    wait.ignoring(ElementNotVisibleException.class);
	    wait.ignoring(StaleElementReferenceException.class);
		wait.pollingEvery(240, TimeUnit.SECONDS);
		wait.until(elementLocated(element));
	}
	
	public Function <WebDriver, Boolean> elementLocated(final WebElement element){
		return new Function<WebDriver, Boolean>(){
			public Boolean apply(WebDriver driver) {			
				return element.isDisplayed();
			}
		};
	}
	
	public WebElement getElement(By locator) {
		if(IsElementPresentQuick(locator)) 
		return driver.findElement(locator);
		try {
			throw new NoSuchElementException("No Such Element " + locator);
		} catch (RuntimeException e) {
			log.error(e);
			throw e;
		}
	}
	
	public boolean IsElementPresentQuick(By locator) {
		log.info(locator);
		boolean flag = driver.findElements(locator).size() >=1;
		log.info(flag);
		return flag;
	}
	
	public WebElement getElementWithNull(By locator) {
		log.info(locator);
		try {
			return driver.findElement(locator);
		} catch (NoSuchElementException e) {
			//ignore
		}
		return null;
	}
	
	public String takeScreenShort(String name) throws IOException {
		if(driver instanceof HtmlUnitDriver) {
			log.fatal("Html Unit Driver can not take ScreenShot");
			return "";
		}
		File destDir = new File(ResourceHelper.getResourcePath("screenshots/"));
		if(!destDir.exists()) 
			destDir.mkdir();
		File destPath = new File(destDir.getAbsolutePath() + System.getProperty("file.separator")+ name +".jpg");
		try {
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), destPath);
		} catch (IOException e) {
		   log.error(e);
			throw e;
		}
		log.info(destPath.getAbsolutePath());
	 return destPath.getAbsolutePath();
	}
	
	
	public WebDriver getBrowserObject(BrowserType btype) throws Exception {
		try {
			switch (btype) {

			case Chrome:
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				return chrome.getChromeDriver(chrome.getChromeCapabilities());

			case Firefox:
				FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
				return firefox.getFirefoxDriver(firefox.getFirefoxCapabilities());

			default:
				throw new Exception("Driver Not Found :" + new PropertyFileReader().getBrowser());
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public void setupDriver(BrowserType btype) throws Exception {
		driver = getBrowserObject(btype);

	}

	@Before()
	public void before() throws Exception {
		ObjectRepo.reader = new PropertyFileReader();
		setupDriver(ObjectRepo.reader.getBrowser());
		
	}

	@After()
	public void after(Scenario scenario) {
	 driver.quit();
	}

}

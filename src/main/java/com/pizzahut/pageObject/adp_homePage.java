package com.pizzahut.pageObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pizzahut.helper.Logger.LoggerHelper;

public class adp_homePage {

	WebDriver driver;
	private static Logger log = LoggerHelper.getLogger(adp_homePage.class);
	
		
	@FindBy(xpath="//li[@class='region-selector']")
	WebElement hoverObj;
	
	@FindBy(xpath="//li[@class='region-selector']")
	WebElement sumMenu;
	
	@FindBy(xpath="//*[@id=\"ctl02\"]/header[1]/nav/ul/li[1]/ul/li[2]/a")
	WebElement Click_Austrilia;

	public adp_homePage(WebDriver driver) {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
	}
	
	
	public void hoverOnUnitedstateLnk() throws InterruptedException {
	 Actions act = new Actions(driver);	
	 WebDriverWait  wait = new WebDriverWait(driver,20); 
	 wait.until(ExpectedConditions.visibilityOf(hoverObj));
	 act.moveToElement(hoverObj).build().perform();		
	 Thread.sleep(1000);
	 List<WebElement> allCountries = driver.findElements(By.xpath("//ul[@class='region-options']"));
	 for(WebElement ele : allCountries) 
	    {
	     String countyNames = ele.getText();
	     log.info(countyNames);
	    }
	  }
	
	    
	  @SuppressWarnings("unlikely-arg-type")
	public void getAllCountries() throws InterruptedException {    
		boolean flag = false;
		List<WebElement> countyList = driver.findElements(By.xpath("//li[@class='region-selector']"));
		for(int i =0; i< countyList.size(); i++) 
		{
			if(countyList.contains("Argentina\r\n" + 
					"Australia\r\n" + 
					"Brazil\r\n" + 
					"Canada (English)\r\n" + 
					"Canada (French)\r\n" + 
					"Chile\r\n" + 
					"China\r\n" + 
					"France\r\n" + 
					"Germany\r\n" + 
					"Hong Kong\r\n" + 
					"India\r\n" + 
					"Italy\r\n" + 
					"Netherlands\r\n" + 
					"Peru\r\n" + 
					"Philippines\r\n" + 
					"Poland\r\n" + 
					"Singapore\r\n" + 
					"Spain\r\n" + 
					"Switzerland\r\n" + 
					"United Kingdom\r\n" + 
					"United States*"))
			{
				flag = true;
				break;
			} else {
				flag = false;
			}
		}
		  
	  }
	
	
	  public void clickOnAustralia() {
		 Click_Austrilia.click();   
	  }
	  
	  
	  public void fetchAllLinksOnHomePageAndVerifyActive() {
		List<WebElement> links =  driver.findElements(By.tagName("a"));
		log.info(links.size());
		for(int i =0; i<links.size(); i++)
		{
		    WebElement ele = links.get(i);
		    String url = ele.getAttribute("href");
		    verifyLinkActive(url);
		}  
	  }
	  
	  public static void verifyLinkActive(String linkUrl) {
		  try {
			  URL url = new URL(linkUrl);
			  HttpURLConnection httpUrlConn = (HttpURLConnection)url.openConnection();
			  httpUrlConn.setConnectTimeout(3000);
			  httpUrlConn.connect();
			  
			  if(httpUrlConn.getResponseCode() == 200) 
			    {
				  log.info(linkUrl+" - "+httpUrlConn.getResponseMessage());
			    }	  
			  if(httpUrlConn.getResponseCode() == httpUrlConn.HTTP_NOT_FOUND) 
			   {
				  log.info(linkUrl +" - " + httpUrlConn.getResponseMessage() + " - "+ httpUrlConn.HTTP_NOT_FOUND);
			   }
	 	     } catch (Exception e) {
		    }
	       }
	  
	
  }

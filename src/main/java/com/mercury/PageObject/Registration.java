package com.mercury.PageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pizzahut.helper.Logger.LoggerHelper;
import com.pizzahut.helper.TestBase.TestBase;
import com.pizzahut.helper.Userdata.userData;

import cucumber.api.DataTable;
import junit.framework.Assert;

public class Registration {

	public Logger log = LoggerHelper.getLogger(Registration.class);
	WebDriver driver;
	
	public Registration(WebDriver driver) {
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[contains(text(),'REGISTER')]")
	public static WebElement Registration_lnk;
	
	@FindBy(xpath="//input[@name='firstName']")
	public static WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastName']")
	public static  WebElement LastName;
	
	@FindBy(xpath="//input[@name='phone']")
	public static WebElement Phone;
	
	@FindBy(xpath="//input[@id='userName']")
	public static WebElement Email;
	
	@FindBy(xpath="//input[@name='address1']")
	public static WebElement Address;
	
	@FindBy(xpath="//input[@name='city']")
	public static WebElement city;
	
	@FindBy(xpath="//input[@name='state']")
	public static WebElement state;
	
   @FindBy(xpath="//input[@name='postalCode']")
   public static WebElement postal_code;	
	
   @FindBy(xpath="//input[@id='email']")
   public static WebElement UserName;
   
   @FindBy(xpath="//input[@name='password']")
   public static WebElement Password;
   
   @FindBy(xpath="//input[@name='confirmPassword']")
   public static WebElement Confirm_Password;
   
   @FindBy(xpath="//input[contains(@src,'submit.gif')]")
   public static WebElement submitBtn;
   
   @FindBy(xpath="//*[contains(text(),'Thank you for registering')]")  
   public static WebElement ThankForRegistration;
   
   
	public void provideData(DataTable userData) 
	{
		List<List<String>>  data = userData.raw();
		for(int i = 0; i <data.size(); i++) 
		{
			log.info(data.get(i).toString());
		}
		firstName.sendKeys(data.get(0).get(1).toString());
		LastName.sendKeys(data.get(1).get(1).toString());
		Phone.sendKeys(data.get(2).get(1).toString());
		Email.sendKeys(data.get(3).get(1).toString());
		UserName.sendKeys(data.get(4).get(1).toString());
		Password.sendKeys(data.get(5).get(1).toString());
		Confirm_Password.sendKeys(data.get(6).get(1).toString());
	}
	
	
	public void verifyRegistrationText() {
	String msg = ThankForRegistration.getText();
	log.info(msg);
	Assert.assertTrue("Text is not getting displayed properly", msg.contains("Thank you for registering.")); 	
	}
	
	// Multiple Registration 
	public void provideMultipleData(DataTable userData) {
		List<List<String>> details = userData.raw();
		for(int i = 1; i <details.size(); i++ ) 
		 {	
			    log.info("");
			    Registration.firstName.sendKeys(details.get(i).get(0).toString());
			    Registration.LastName.sendKeys(details.get(i).get(1).toString());
			    Registration.Phone.sendKeys(details.get(i).get(2).toString());
			    Registration.Email.sendKeys(details.get(i).get(3).toString());
			    Registration.UserName.sendKeys(details.get(i).get(4).toString());
			    Registration.Password.sendKeys(details.get(i).get(5).toString());
			    Registration.Confirm_Password.sendKeys(details.get(i).get(6).toString());
			    Registration.submitBtn.click();
				
				String msg = Registration.ThankForRegistration.getText();
				log.info(msg);
				
				WebElement register = Registration.Registration_lnk;
				((JavascriptExecutor) TestBase.driver).executeScript("arguments[0].setAttribute('target','_self');",register);
	    		   register.click();
		    }
	
	}
	
	
	
	
	 
}

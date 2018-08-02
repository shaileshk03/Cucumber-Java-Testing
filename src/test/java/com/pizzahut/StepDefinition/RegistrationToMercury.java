package com.pizzahut.StepDefinition;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mercury.PageObject.Registration;
import com.pizzahut.configReader.ObjectRepo;
import com.pizzahut.helper.Logger.LoggerHelper;
import com.pizzahut.helper.TestBase.TestBase;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationToMercury {

	private static final Logger log = LoggerHelper.getLogger(RegistrationToMercury.class);
	Registration  page = new Registration(TestBase.driver);
	
	
	@When("^Registration page Displayed$")
	public void registration_page_Displayed() throws Throwable {
	  // Navigate to URL 
	  TestBase.driver.get(ObjectRepo.reader.getWebsite());
	  log.info("Registration Page Displayed");
	    // Wait for element 
	    WebDriverWait wait = new WebDriverWait(TestBase.driver,10);	 	    
	    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("REGISTER"))); 
	    // Clicking element to open the page in same window 
	    WebElement register = page.Registration_lnk;	   
	    JavascriptExecutor js = (JavascriptExecutor) TestBase.driver;
		js.executeScript("arguments[0].setAttribute('target','_self');",register);
	    register.click();  
	}

	
	@Then("^I enter valid data on registration page and check if registration is successfull$")
	public void i_enter_valid_data_on_registration_page_and_check_if_registration_is_successfull(DataTable arg1) throws Throwable {
	    page.provideMultipleData(arg1);
	}

		
	@Then("^I enter valid data on page$")
	public void i_enter_valid_data_on_page(DataTable arg1) throws Throwable {
	   page.provideData(arg1);
	}
	

	@Then("^Click on Submit Button$")
	public void click_on_Submit_Button() throws Throwable {
	  page.submitBtn.click();
	}

	@Then("^Thank you for registering: should be displayed$")
	public void thank_you_for_registering_should_be_displayed() throws Throwable {
	  page.verifyRegistrationText();
	}

	@Then("^Click on Signoff$")
	public void click_on_Signoff() throws Throwable {
	  
	}

	@Then("^Close the Browser$")
	public void close_the_Browser() throws Throwable {
	    
	}
	
}

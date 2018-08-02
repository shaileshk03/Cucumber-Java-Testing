package com.pizzahut.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.pizzahut.configReader.ObjectRepo;
import com.pizzahut.helper.Logger.LoggerHelper;

public class FeedBackPage {
	
	WebDriver driver;
	private Logger log = LoggerHelper.getLogger(FeedBackPage.class);
	com.pizzahut.helper.wait.waitHelper waitHelper;
	
	 @FindBy(xpath="//input[@value=1]")
	  private WebElement Great_Exp_Radiotbn;
		
	  @FindBy(xpath="//select[@id='city_id']")
	  private WebElement select_city;  
	
	  @FindBy(xpath="//select[@id='storeId']")
	  private WebElement select_Store;
	  
	  @FindBy(xpath="//input[@name='next']")
	  private WebElement Next_btn;
	  
	  
	public FeedBackPage(WebDriver driver) {
	  this.driver = driver;	
	  PageFactory.initElements(driver, this);  
	 // waitHelper.waitForElement(driver, Great_Exp_Radiotbn, ObjectRepo.reader.getExplicitWait());
	 }
	
	 public void setGreatExpRadioBtn() {
	  this.Great_Exp_Radiotbn.click();
	 }

	 public void selectYourCity(String select_city) throws InterruptedException {
		new Select(this.select_city).selectByVisibleText("Hyderabad");
		Thread.sleep(5000);
	 }
	
	 public void selectYourStore(String select_Store) {
		new Select(this.select_Store).selectByVisibleText("Madhapur");
	 }
	
	 public dinein_infoPage clickOnNextBtn() {
		 this.Next_btn.click();
		 return new dinein_infoPage(driver);
	 }
	
}

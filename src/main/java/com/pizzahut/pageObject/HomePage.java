package com.pizzahut.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pizzahut.configReader.ObjectRepo;
import com.pizzahut.helper.Logger.LoggerHelper;
import com.pizzahut.helper.wait.waitHelper;

public class HomePage {

  WebDriver driver;
  private final Logger log = LoggerHelper.getLogger(HomePage.class);
  waitHelper waitHelper;
  
  public HomePage(WebDriver driver) {
   this.driver = driver;
   PageFactory.initElements(driver, this);	  
   waitHelper = new waitHelper(driver);
   waitHelper.waitForElement(driver, Dine_In_Feedback, ObjectRepo.reader.getExplicitWait());
  }
	
  @FindBy(xpath="//img[@src='images/dienien-icon.png']")
  private WebElement Dine_In_Feedback;
    
  
  public void clickOnDienienLink() {
    Dine_In_Feedback.click();
    log.info(Dine_In_Feedback);
  }
	
  public FeedBackPage enterDetails(WebElement element) {
	  waitHelper.waitForElement(driver, element, ObjectRepo.reader.getExplicitWait());
	  return new FeedBackPage(driver);
  }
	
	
}

package com.pizzahut.pageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.pizzahut.helper.DropDown.dropDownHelper;
import com.pizzahut.helper.Logger.LoggerHelper;

public class dinein_infoPage {

	WebDriver driver;
	private Logger log = LoggerHelper.getLogger(dinein_infoPage .class);
	dropDownHelper ddHelper = new dropDownHelper(driver);
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement customer_Name;

	@FindBy(xpath="//select[@id='typeselector']")
	private WebElement select_gender;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@name='phone']")
	private WebElement phone_number;
	
	@FindBy(xpath="//select[@name='preferred_time']")
	private WebElement preferred_time;
	
	@FindBy(xpath="//textarea[@id='address']")
	private WebElement your_address;
	
	@FindBy(xpath="//input[@id='date_of_visit']")
	private WebElement selectDays;
	
	@FindBy(xpath="//input[@name='time_of_visit' and @value='3-7pm']")
	private WebElement timeOfVisit;
	
	@FindBy(xpath="//textarea[@name='your_feedback']")
	private WebElement YourFeedback;
	
	@FindBy(xpath="//input[@name='how_often_u_visit' and @value='weekly']")
	private WebElement HowOftenYouVisit;
	
	@FindBy(xpath="//input[@name='image1']")
	private WebElement uploadPictures;
	
	@FindBy(xpath="//input[@name='res_clean' and @value='yes']")
	private WebElement WasRestaurantClean;
	
	@FindBy(xpath="//input[@name='service_hospitable' and @value='yes']")
	private WebElement WashospitableFriendly;
	
	@FindBy(xpath="//input[@name='receive_wat_ordered' and @value='yes']")
	private WebElement didYouReceiveWhatOrdered;
	
	@FindBy(xpath="//input[@name='res_maintained' and @value='yes']")
	private WebElement WasRestaurantWellMaintained;
	
	@FindBy(xpath="//input[@name='food_liking' and @value='yes']")
	private WebElement WasTheFoodYouLiking;
	
	@FindBy(xpath="//input[@name='serve_speedly' and @value='no']")
	private WebElement WereYouServedSpeedly;
	
	@FindBy(xpath="//input[@name='got_value_for_money' and @value='yes']")
	private WebElement didYouFeelValueForMoney;
	
	@FindBy(xpath="//input[@name='will_visit_pizzahut' and @value='yes']")
	private WebElement willYouvisitPizzahutInNearFuture;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement submitBtn;
	
	
	
	public dinein_infoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterCustomerName(String customerName) {
		customer_Name.sendKeys(customerName);
	}
	
	public void selectGender(String select_gender) {
		new Select(this.select_gender).selectByVisibleText("Male");
	}
	
	public void enterEmailAddress(String email) {
		this.email.sendKeys(email);
	}
	
	public void enterPhoneNum(String phone_number) {
		this.phone_number.sendKeys(phone_number);
	}
	
	public void selectPreferredTimeToContact(String preferred_time) {
	   new Select(this.preferred_time).selectByIndex(2);;	
	}
	
	public void enterAddress(String address) throws InterruptedException {
		this.your_address.sendKeys(address);
	    Thread.sleep(5000);
	}
	
	public void setDateOFVisit(String day) {
	List<WebElement> days = driver.findElements(By.xpath("//input[@id='date_of_visit']"));
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
	
	public void selectTimeOfVisit() {
	 timeOfVisit.click();
	}
	
	public void enterFeedback(String YourFeedback) {
	 this.YourFeedback.sendKeys(YourFeedback);
	}
	
	public void HowOften_YouVisit() {
	this.HowOftenYouVisit.click();
	}
	
	 public void uploadYourPicture() throws AWTException {
     ddHelper.uploadPicture(uploadPictures, "C:\\Users\\Dell Vostro\\Downloads\\4155647_Alex_n.jpg");	  
	 }
	
	public void selectWasRestaurantClean() {
		 this.WasRestaurantClean.click();
	}
	
	public void selectWashospitableFriendly() {
		this.WashospitableFriendly.click();
	}
	 
	public void selectdidYouReceiveWhatOrdered() {
		this.didYouReceiveWhatOrdered.click();
	}
	
	public void selectWasRestaurantWellMaintained() {
		this.WasRestaurantWellMaintained.click();
	}
	
	public void selectWasTheFoodYouLiking() {
		this.WasTheFoodYouLiking.click();
	}

	public void selectWereYouServedSpeedly() {
		this.WereYouServedSpeedly.click();
	}
	
	public void selectdidYouFeelValueForMoney() {
		this.didYouFeelValueForMoney.click();
	}
	
	public void selectwillYouvisitPizzahutInNearFuture() {
		this.willYouvisitPizzahutInNearFuture.click();
	}

	public void clickOnSumitBtn() {
		this.submitBtn.click();
	}
	
	
}



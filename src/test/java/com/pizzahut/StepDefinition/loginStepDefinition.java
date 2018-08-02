package com.pizzahut.StepDefinition;


import org.apache.log4j.Logger;

import com.pizzahut.configReader.ObjectRepo;
import com.pizzahut.helper.Logger.LoggerHelper;
import com.pizzahut.helper.TestBase.TestBase;
import com.pizzahut.pageObject.FeedBackPage;
import com.pizzahut.pageObject.HomePage;
import com.pizzahut.pageObject.dinein_infoPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

  
public class loginStepDefinition {
	
	private Logger log = LoggerHelper.getLogger(loginStepDefinition.class);
	HomePage hpage;	
	FeedBackPage fpage;
	dinein_infoPage dineInfo = new dinein_infoPage(TestBase.driver);
	
	@Given("^User navigate to url$")
	public void user_navigate_to_url() throws Throwable {
    TestBase.driver.get(ObjectRepo.reader.getWebsite());
	}

	@Given("^User click on dine link$")
	public void user_click_on_dine_link() throws Throwable {
	 hpage = new HomePage(TestBase.driver);
	 hpage.clickOnDienienLink();
	}

	@Given("^User select radio button$")
	public void user_select_radio_button() throws Throwable {
	 fpage = new FeedBackPage(TestBase.driver);
	 fpage.setGreatExpRadioBtn();
	}

	@Given("^User select city \"([^\"]*)\"$")
	public void user_select_city(String arg1) throws Throwable {
	fpage = new FeedBackPage(TestBase.driver);
	fpage.selectYourCity(arg1);	
	}

	@Given("^User select store \"([^\"]*)\"$")
	public void user_select_store(String arg1) throws Throwable {
	  fpage = new FeedBackPage(TestBase.driver);
	  fpage.selectYourStore(arg1);
	}

	@Then("^User click on next button$")
	public void user_click_on_next_button() throws Throwable {
		fpage = new FeedBackPage(TestBase.driver);
	    fpage.clickOnNextBtn();
	    Thread.sleep(8000);
	}

	@Then("^User enter customer Name \"([^\"]*)\"$")
	public void user_enter_customer_Name(String arg1) throws Throwable {
		dineInfo.enterCustomerName(arg1);
	}

	@Then("^User enter select gender as \"([^\"]*)\"$")
	public void user_enter_select_gender_as(String arg1) throws Throwable {
		dineInfo.selectGender(arg1);
	}

	@Then("^User enter emailaddress as \"([^\"]*)\"$")
	public void user_enter_emailaddress_as(String arg1) throws Throwable {
		dineInfo.enterEmailAddress(arg1);
	}

	@Then("^User enter phone number as \"([^\"]*)\"$")
	public void user_enter_phone_number_as(String arg1) throws Throwable {
		dineInfo.enterPhoneNum(arg1);
	}

	@Then("^User select preferred time as \"([^\"]*)\"$")
	public void user_select_preferred_time_as(String arg1) throws Throwable {
		dineInfo.selectPreferredTimeToContact(arg1);
	}

	@Then("^User enter Address as \"([^\"]*)\"$")
	public void user_enter_Address_as(String arg1) throws Throwable {
		dineInfo = new dinein_infoPage(TestBase.driver);
		dineInfo.enterAddress(arg1);
	}

	
	@Then("^User select a date as \"([^\"]*)\"$")
	public void user_select_a_date_as(String arg1) throws Throwable {
	  dineInfo.setDateOFVisit(arg1);
	}
	
	@Then("^User select time of visit$")
	public void user_select_time_of_visit() throws Throwable {
		 dineInfo.selectTimeOfVisit();
	}

	@Then("^User enter your feedback as \"([^\"]*)\"$")
	public void user_enter_your_feedback_as(String arg1) throws Throwable {
		 dineInfo.enterFeedback(arg1);
	}

	@Then("^User options how often do you visit pizza hut$")
	public void user_options_how_often_do_you_visit_pizza_hut() throws Throwable {
		 dineInfo.HowOften_YouVisit();
	}

	@Then("^User upload picture$")
	public void user_upload_picture() throws Throwable {
		 dineInfo.uploadYourPicture();
		 Thread.sleep(5000);
	}

	@Then("^User select was restaurant clean$")
	public void user_select_was_restaurant_clean() throws Throwable {
		dineInfo.selectWasRestaurantClean();
	}

	@Then("^User select Was hospitable Friendly$")
	public void user_select_Was_hospitable_Friendly() throws Throwable {
		dineInfo.selectWashospitableFriendly();
	}

	@Then("^User select did You Receive What Ordered$")
	public void user_select_did_You_Receive_What_Ordered() throws Throwable {
		dineInfo.selectdidYouReceiveWhatOrdered();
	}

	@Then("^User select Was Restaurant Well Maintained$")
	public void user_select_Was_Restaurant_Well_Maintained() throws Throwable {
		dineInfo.selectWasRestaurantWellMaintained();
	}

	@Then("^User select Was The Food You Liking$")
	public void user_select_Was_The_Food_You_Liking() throws Throwable {
		dineInfo.selectWasTheFoodYouLiking();
	}

	@Then("^User select Were You Served Speedly$")
	public void user_select_Were_You_Served_Speedly() throws Throwable {
		dineInfo.selectWereYouServedSpeedly();
	}

	@Then("^User select did You Feel Value For Money$")
	public void user_select_did_You_Feel_Value_For_Money() throws Throwable {
		dineInfo.selectdidYouFeelValueForMoney();
	}

	@Then("^User select will You visit Pizzahut In Near Future$")
	public void user_select_will_You_visit_Pizzahut_In_Near_Future() throws Throwable {
		dineInfo.selectwillYouvisitPizzahutInNearFuture();
	}

	@Then("^User click on sumbit button$")
	public void user_click_on_sumbit_button() throws Throwable {
		dineInfo.clickOnSumitBtn();
	}

	@Then("^User close the browser$")
	public void user_close_the_browser() throws Throwable {
	    TestBase.driver.quit();
	}


	

}

package com.pizzahut.StepDefinition;

import org.apache.log4j.Logger;

import com.pizzahut.configReader.ObjectRepo;
import com.pizzahut.helper.Logger.LoggerHelper;
import com.pizzahut.helper.TestBase.TestBase;
import com.pizzahut.pageObject.adp_homePage;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class adp_Stepdef {

	private Logger log = LoggerHelper.getLogger(adp_Stepdef.class);
	
	adp_homePage adp = new adp_homePage(TestBase.driver);
	
	@Given("^User nevigate to home page|and hover on united state link$")
	public void user_nevigate_to_home_page_and_hover_on_united_state_link() throws Throwable {
	    TestBase.driver.get(ObjectRepo.reader.getWebsite());
	    log.info("Navigating to URL"+ TestBase.driver.getTitle());
	}
	
	@Given("^User select hover on united state link fetch all the list of counties$")
	public void user_select_hover_on_united_state_link_fetch_all_the_list_of_counties() throws Throwable {
	    adp.hoverOnUnitedstateLnk();
	}

	@When("^verify all countries list available in list$")
	public void verify_all_countries_list_available_in_list() throws Throwable {
	   adp.getAllCountries();
	}

	@Then("^click on one of the link$")
	public void click_on_one_of_the_link() throws Throwable {
	   adp.clickOnAustralia();
	   log.info("clicked on Link");
	}
	
	@Then("^User featch all links and Verify all links are active$")
	public void user_featch_all_links_and_Verify_all_links_are_active() throws Throwable {
	    adp.fetchAllLinksOnHomePageAndVerifyActive();
	}
	
	
}

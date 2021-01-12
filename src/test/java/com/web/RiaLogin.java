package com.web;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RiaLoginPO;
import erg.base.BaseClass;
//import erg.base.BackgroundHook;

public class RiaLogin {

	WebDriver driver;
	RiaLoginPO pObj;

	@Given("validate the browser")
	public void validate_the_browser() {
		driver = BaseClass.getDriver();
		pObj = new RiaLoginPO(driver);
	}

	@Given("User opens the browser and navigates to home page")
	public void user_opens_the_browser_and_navigates_to_home_page() {
		BaseClass.getURL("https://www.riamoneytransfer.com/us/en/sign-in");
		BaseClass.waitScenario(pObj.username_textbox);
	}


	@When("User enters username and password and click submit button")
	public void user_enters_username_and_password_and_click_submit_button() {
		BaseClass.enterText(pObj.username_textbox, BaseClass.credentialProperty("username"));
		BaseClass.enterText(pObj.password_textbox, BaseClass.credentialProperty("password"));
		BaseClass.clickElement(pObj.signIn_button);
	}


	@Then("User logs in successfully and lands on dashboard")
	public void user_logs_in_successfully_and_lands_on_dashboard() {

	}

}

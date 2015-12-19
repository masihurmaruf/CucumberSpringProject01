/**
 * 
 */
package com.paxovision.steps;

import static org.hamcrest.MatcherAssert.assertThat;


import static org.hamcrest.Matchers.*;



import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Masihur
 *
 */
public class HomePageSteps extends StepBase{
	
	
	
	@Then("^Paxotech Heatclinic home page should show$")
	public void broadleaf_Commerce_home_page_should_show() throws Throwable {
	    String title = driver.getTitle().trim().toUpperCase();
	    assertThat(title, equalTo("Broadleaf Demo - Heat Clinic".toUpperCase()));
	}

	@When("^User click login link$")
	public void user_click_login_link() throws Throwable {
	    heatclinic.homePage().showLogInPage();
	}
	
	@Then("^Welcome message should display with \"([^\"]*)\"$")
	public void welcome_message_should_display_with(String name) throws Throwable {
		heatclinic.loginPage().verifyWelcomeMessage(name);
	}
	@When("^User Click the Register Page Link$")
	public void user_Click_the_Register_Page_Link() throws Throwable {
		heatclinic.homePage().showRegisterPage();
	}
	@When("^User Click the Heatclinic Logo$")
	public void user_Click_the_Heatclinic_Logo() throws Throwable {
		heatclinic.homePage().heatclinicLogo();
	}
	@When("^User Click the Home link$")
	public void user_Click_the_Home_link() throws Throwable {
		heatclinic.homePage().homeLink();
	}
	@When("^User Click the Hot Sauces link$")
	public void user_Click_the_Hot_Sauces_link() throws Throwable {
	    heatclinic.homePage().hotSaucesPage();
	}
	@When("^User Click the Merchandise link$")
	public void user_Click_the_Merchandise_link() throws Throwable {
	    heatclinic.homePage().merchandisePage();
	}

	

}

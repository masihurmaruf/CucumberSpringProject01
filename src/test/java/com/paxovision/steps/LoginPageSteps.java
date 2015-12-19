/**
 * 
 */
package com.paxovision.steps;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Masihur
 *
 */
public class LoginPageSteps extends StepBase{
	
	
	
	@When("^Enter \"([^\"]*)\" as email address$")
	public void enter_as_email_address(String email) throws Throwable {
		heatclinic.loginPage().enterEmail(email);
	}

	@When("^Enter \"([^\"]*)\" as password$")
	public void enter_as_password(String password) throws Throwable {
		heatclinic.loginPage().enterPassword(password);
	}

	@When("^Click login button$")
	public void click_login_button() throws Throwable {
		heatclinic.loginPage().logIn();
	}
	@Then("^Invalid email or password message should display$")
	public void invalid_email_or_password_message_should_display() throws Throwable {
	    String msg = "The e-mail address and/or password entered do not match our records. Please try again";
		heatclinic.loginPage().verifyErrorMessage(msg);
	}
	@Then("^Login Page Should Show$")
	public void login_Page_Should_Show() throws Throwable {
		String title = driver.getTitle().trim().toUpperCase();
	    assertThat(title, equalTo("Login - Broadleaf Demo - Heat Clinic".toUpperCase()));
	}

}

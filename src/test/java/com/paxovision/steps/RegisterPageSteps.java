/**
 * 
 */
package com.paxovision.steps;

import cucumber.api.java.en.Then;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * @author Masihur
 *
 */
public class RegisterPageSteps extends StepBase{
	
	@Then("^Register Page Should Show$")
	public void register_Page_Should_Show() throws Throwable {
	    String title = driver.getTitle().trim().toUpperCase();
	    assertThat(title, equalTo("Register - Broadleaf Demo - Heat Clinic".toUpperCase()));
	}
}

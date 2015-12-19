/**
 * 
 */
package com.paxovision.steps;

import java.net.URL;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * @author Masihur
 *
 */
public class ApplicationSteps extends StepBase{
	
	
	
	@Given("^As a not validated user$")
	public void as_a_not_validated_user() throws Throwable {
	
	}

	@When("^Browse to the application$")
	public void browse_to_the_application() throws Throwable {
//	    
		String url = environment.getProperty("root.url");
		driver.navigate().to(url);
	}
}

/**
 * 
 */
package com.paxovision.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import cucumber.api.java.en.Then;

/**
 * @author Masihur
 *
 */
public class HotSaucesSteps extends StepBase{
	
	@Then("^Paxotech Heatclinic Hot Sauces page should show$")
	public void paxotech_Heatclinic_Hot_Sauces_page_should_show() throws Throwable {
		 String title = driver.getTitle().trim().toUpperCase();
		 assertThat(title, equalTo("Hot Sauces - Broadleaf Demo - Heat Clinic".toUpperCase()));
	}
	

}

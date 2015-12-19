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
public class MerchandiseSteps extends StepBase{
	@Then("^Paxotech Heatclinic Merchandise page should show$")
	public void paxotech_Heatclinic_Merchandise_page_should_show() throws Throwable {
		 String title = driver.getTitle().trim().toUpperCase();
		 assertThat(title, equalTo("Merchandise - Broadleaf Demo - Heat Clinic".toUpperCase()));
	}
}

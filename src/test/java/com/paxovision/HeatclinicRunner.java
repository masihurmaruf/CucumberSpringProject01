/**
 * 
 */
package com.paxovision;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.util.StringUtils;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author Masihur
 *
 */
//-Dbrowser="chrome" -Dcucumber.options="--tags @smoke" -DenvTarget="dev1"
@RunWith(Cucumber.class)
@CucumberOptions(
		//dryRun = false
		//strict = true
		monochrome = true,
		//tags = {"@smoke"},
		//tags = {"@functional","@debug"},/*AND*/
		//tags = {"@functional","@debug"},/*OR*/
		//tags = {"@functional","@debug","@debug"},/*AND-OR*/
		features = "src/test/resources/features/",
		glue = {"com.paxovision.steps", "com.paxovision.heatclinic.framework.hooks"},
		plugin = {
				"pretty",
				"html:target/test-output",
				"json:target/test-report.json",
				"json:target/cucumber-report.json",
				"junit:target/test-report.xml"
		}
		)
public class HeatclinicRunner {
	@BeforeClass
	public static void setUp(){
		
		String envTarget = System.getProperty("envTarget");
		if(!StringUtils.hasText(envTarget)){
			envTarget = "default";
			System.setProperty("envTarget", envTarget);
		}
		
		String browser = System.getProperty("browser");
		if(!StringUtils.hasText(browser)){
			browser = "firefox";
			System.setProperty("browser", browser);
		}
	}

}

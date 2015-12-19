/**
 * 
 */
package com.paxovision.heatclinic.framework.hooks;

import java.io.File;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import org.monte.screenrecorder.ScreenRecorder ;

import com.paxovision.heatclinic.framework.SpecializedScreenRecorder;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * @author Masihur
 *
 */
public class CucumberHooks {
	

	@Autowired
	protected WebDriver driver;
	
	private ScreenRecorder screenRecorder;
	private String executionFeature;
	private String executionScenario;
	
	@Before
	public void beforeScenario(Scenario scenario) throws Exception{
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		String scenarioId = scenario.getId();
		String featureName = scenarioId.substring(0, scenarioId.indexOf(";"));
		
		this.executionFeature = featureName;
		this.executionScenario = scenario.getName();
		
		startRecording();
		
	}
	@After
	public void afterScenario(Scenario scenario) throws Exception{
		if(scenario.isFailed()){
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");//stick it in the report
			
		}
		//driver.close
		stopRecording();
	}
	private void startRecording() throws Exception{
		String useDir = System.getProperty("user.home");
		File file = new File(useDir + "/CucumberVideos/" + this.executionFeature.replaceAll("[^a-zA-Z0-9.-]", "_"));
		String fileNameStartWith = this.executionScenario.replaceAll("[^a-zA-Z0-9.-]", "_");
		this.screenRecorder = new SpecializedScreenRecorder(file, fileNameStartWith);
		this.screenRecorder.start();
	}
	private void stopRecording() throws Exception{
		this.screenRecorder.stop();
	}


}

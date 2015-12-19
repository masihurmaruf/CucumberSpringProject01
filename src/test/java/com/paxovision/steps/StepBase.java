/**
 * 
 */
package com.paxovision.steps;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.paxovision.heatclinic.framework.pages.Application;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


/**
 * @author Masihur
 *
 */
public class StepBase {
	
	@Autowired
	protected WebDriver driver;
	@Autowired
	protected Application heatclinic;
	@Autowired
	protected Environment environment;
	
	
}

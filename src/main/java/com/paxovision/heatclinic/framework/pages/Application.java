/**
 * 
 */
package com.paxovision.heatclinic.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 * @author Masihur
 *
 */
@Service
public class Application {
	
	@Autowired
	private WebDriver driver = null;
	@Autowired
	private HomePage homePage = null;
	@Autowired
	private LoginPage loginPage = null;
	
	public HomePage homePage(){
		PageFactory.initElements(driver, homePage);
		return homePage;
	}
	public LoginPage loginPage(){
		PageFactory.initElements(driver, loginPage);
		return loginPage;
	}
	
	
}

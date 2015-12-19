/**
 * 
 */
package com.paxovision.heatclinic.framework.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * @author Masihur
 *
 */
@Service
public class HomePage extends Page{


//	@FindBy(how = How.XPATH, using = "")
	private WebElement logInLink;
	public WebElement loginLink(){
		logInLink = waitForElement(By.xpath("//*[@id='cart_info']/a/span[text() = 'Login']"));
		return logInLink;
	}
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='search']//input[@name = 'q']")
	private WebElement searchBox;
	
	@FindBy(how = How.XPATH, using = "//input[@id='search_button']")
	private WebElement searchButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id='logo']/h1/a")
	private WebElement heatclinicLogo;
	
	@FindBy(how = How.XPATH, using = "//*[@id='cart_info']//span[text() = 'Register']")
	private WebElement registerLink;
	
	@FindBy(how = How.XPATH, using = "//*[@id='content']//a[text() = 'Home']")
	private WebElement homePageLink;

	@FindBy(how = How.XPATH, using = "//a[text() = 'Hot Sauces']")
	private WebElement hotSaucesPageLink;

	@FindBy(how = How.XPATH, using = "//a[text() = 'Merchandise']")
	private WebElement merchandisePageLink;
	
	@FindBy(how = How.XPATH, using = "//a[text() = 'Clearance']")
	private WebElement clearancePageLink;

	
	
	
	public void showLogInPage (){
		loginLink().click();
	}
	
	public void searchText(String textToSearch){
		searchBox.clear();
		searchBox.sendKeys(textToSearch);
		searchButton.submit();
		
	}
	
	public void heatclinicLogo(){
		heatclinicLogo.click();
	}
	
	public void showRegisterPage(){
		registerLink.click();
	}
	
	public void homeLink(){
		homePageLink.click();
	}
	
	public void hotSaucesPage(){
		hotSaucesPageLink.click();
	}
	
	public void merchandisePage(){
		merchandisePageLink.click();
	}
	public void clearancePage(){
		clearancePageLink.click();
		
	}
	
	
	
	

}

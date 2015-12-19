/**
 * 
 */
package com.paxovision.heatclinic.framework.pages;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.equalTo;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Service;

/**
 * @author Masihur
 *
 */
@Service
public class LoginPage extends Page{

	public LoginPage() {
		PageFactory.initElements(this.driver, this);
	}
	@FindBy(how = How.NAME, using = "j_username")
	private WebElement email;
	
	@FindBy(how = How.NAME, using = "j_password")
	private WebElement password;
	
	@FindBy(how = How.CSS, using = ".login_button.big.red")
	private WebElement loginButton ;
	
	@FindBy(how = How.XPATH, using = "//*[@id='cart_info']/span/a")
	private WebElement welcomeName ;
	
	@FindBy(how = How.XPATH, using = "//*[@id='login']/span[@class = 'error']/p")
	private WebElement errorMessage ;
	
	
	
	
	
	
	public void enterEmail(String emailText){
		email.sendKeys(emailText);
	}
	public void enterPassword(String passwordText){
		password.sendKeys(passwordText);
	}
	
	public void logIn(){
		loginButton.click();
	}
	public void logIn(String emailText, String passwordText){
		email.sendKeys(emailText);
		password.sendKeys(passwordText);
		loginButton.click();
	}
	public void verifyWelcomeMessage(String name){
		String nameActual = welcomeName.getText().trim().toUpperCase();
		assertThat(nameActual, equalTo(name.toUpperCase()));
	}
	public void verifyErrorMessage(String msg){
		String errorMessageActual = errorMessage.getText().trim().toUpperCase();
		assertThat(errorMessageActual, equalTo(msg.toUpperCase()));
	}
	
	
}

/**
 * 
 */
package com.paxovision.heatclinic.framework.pages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Function;

/**
 * @author Masihur
 *
 */
public abstract class Page {
	@Autowired
	protected WebDriver driver = null;
	
	
	public WebElement findElementWait(By by){
		Wait<WebDriver> wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(visibiltyOfElement(by));
		return element;
		
		
		
	}
	private ExpectedCondition<WebElement> visibiltyOfElement(final By by){
		return new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver d){
				try{
					Thread.sleep(500);
				}catch(Exception e){}
				
				WebElement element = d.findElement(by);
				if(element.isDisplayed()){
					return element;
				}
				return null;
			}	
		};
	}
	public WebElement waitForElement(final By locator){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
		
		WebElement foo = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver){
				return driver.findElement(locator);
			}
		});
		return foo;
	}
	
	
	public WebElement waitForElementDisplayed(final By locator, int timeToWaitInSec){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(timeToWaitInSec, TimeUnit.SECONDS)
				.pollingEvery(100, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement foo = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver){
				WebElement element = driver.findElement(locator);
				if(element.isDisplayed()){
					return element;
				}
				return null;
			}
		});
		return foo;
	}
	public WebElement waitForElementNotDisplayed(final By locator){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MICROSECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement foo = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver){
				WebElement element = driver.findElement(locator);
				if(element.isDisplayed()){
					return null;
				}
				return element;
			}
		});
		return foo;
	}
	public WebElement waitForElementDisplayed(final By locator){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MICROSECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement foo = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver){
				WebElement element = driver.findElement(locator);
				if(element.isDisplayed()){
					return element;
				}
				return null;
			}
		});
		return foo;
	}
	private String textToWait;
	public WebElement waitForElementDisplayed(final By locator, String text){
		textToWait = text;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MICROSECONDS)
				.ignoring(NoSuchElementException.class);
		
		WebElement foo = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver){
				WebElement element = driver.findElement(locator);
				if(element.getText().contentEquals(textToWait)){
					return element;
				}
				return null;
			}
		});
		return foo;
	}
	public void delayFor(int milliSecond){
		try{
			Thread.sleep(milliSecond);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}
	public void hoverItem(WebElement element){
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}
	public void hoverItem(By by){
		WebElement element = driver.findElement(by);
		hoverItem(element);
	}
	public void hoverItemEx(WebElement element){
		Locatable hoverItem = (Locatable) element;
		Mouse mouse = ((HasInputDevices) driver).getMouse();
		mouse.mouseMove(hoverItem.getCoordinates());
	}
	public void hoverItemEx(By by){
		WebElement element = driver.findElement(by);
		hoverItemEx(element);
		
	}
	public void verifyTitle(String title){
		String titleModified = title.trim().toUpperCase();
		assertThat(titleModified, is(equalTo(driver.getTitle().trim().toUpperCase())));
	}
	
}

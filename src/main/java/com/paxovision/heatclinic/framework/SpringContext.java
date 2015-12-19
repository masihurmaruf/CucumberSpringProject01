/**
 * 
 */
package com.paxovision.heatclinic.framework;



import java.io.File;
import java.net.MalformedURLException;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.xerces.util.URI.MalformedURIException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @author Masihur
 *
 */
@Configuration
public class SpringContext {
	@Bean(destroyMethod="quit")
	public WebDriver getDriver(){
		WebDriver driver = null;
		
		String browser = System.getProperty("browser");
//		String browser = "firefox";
		
		if(browser.contentEquals("firefox")){
			driver = new FirefoxDriver();
		
		}
		else if(browser.contentEquals("chrome")){
			File chromeDriverFile = new File(System.getProperty("user.dir") + "/driver/32/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", chromeDriverFile.getAbsolutePath());
			driver = new ChromeDriver();
		}
//		else if(browser.contentEquals("remote")){
//			DesiredCapabilities caps = DesiredCapabilities.firefox();
//
//			try {
//				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
//			} catch (MalformedURLException e) {
//				
//				e.printStackTrace();
//			}
//			
//		}
		else if(browser.contentEquals("internet explorer")){
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setJavascriptEnabled(true);
			capabilities.setBrowserName("internet explorer");
			capabilities.setCapability("ignoreZoomSetting", true);
			capabilities.setCapability("requireWindowFocus", true);

			File driverFile = new File(System.getProperty("user.dir") + "/driver/32/IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", driverFile.getAbsolutePath());
			driver = new InternetExplorerDriver(capabilities);
		}
//		else{
//			driver = new FirefoxDriver();
//		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		return driver;
	}

}

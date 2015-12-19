/**
 * 
 */
package com.paxovision.heatclinic.framework;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.util.StringUtils;

/**
 * @author Masihur
 *
 */
@Configuration
@PropertySource(value = {
		"classpath:properties/${envTarget}.webdriver.properties"
})
public class PropertySourceConfig {
	@Bean
	public static PropertySourcesPlaceholderConfigurer getProperty() throws IOException{
		
//		System.out.println("Hi there");
//		String envTarget = System.getProperty("envTarget");
//		if(!StringUtils.hasText(envTarget)){
//			envTarget = "default";
//			System.setProperty("envTarget", envTarget);
//		}
//		PropertySourcesPlaceholderConfigurer propertyConfigurer = new PropertySourcesPlaceholderConfigurer();
//		propertyConfigurer.setLocation(new PathMatchingResourcePatternResolve().getResource("classpath:properties/" + envTarget + ".webdriver.properties"));
//		return propertyConfigurer;
		
		return new PropertySourcesPlaceholderConfigurer();
	}

}

package com.facebook.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.facebook.facebook.BaseClass;
import com.facebook.property.ConfigurationHelper;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\ADMIN\\eclipse-selenium\\facebook\\src\\test\\java\\com\\facebook\\feature\\Facebook.feature",glue ="com.facebook.stepdefinition",monochrome = true,
plugin = {"pretty",
		"html:Report/html.html",
		"json:Report/json.json",
		"junit:Report/xml.xml"})

public class TestRunner extends BaseClass{
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void setUP() throws IOException {
		
		String browser = ConfigurationHelper.getInstant().getBrowser();
	    
		driver = LaunchBrowser(browser);
		
	}
	
	@AfterClass
	public static void tearDown() {
		
		close();

	}

}

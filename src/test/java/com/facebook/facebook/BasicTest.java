package com.facebook.facebook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.facebook.pom.LogInPage;
import com.facebook.pom.SignUp;
import com.facebook.pom.SingleTonDesignPattern;
import com.facebook.property.ConfigurationHelper;

public class BasicTest extends BaseClass {
	public static WebDriver driver;
		
	
	
	public static void main(String[] args) throws Exception {
		
		String browser = ConfigurationHelper.getInstant().getBrowser();
		
		driver =LaunchBrowser(browser);
		
		SingleTonDesignPattern st = new SingleTonDesignPattern(driver);
		
		String url = ConfigurationHelper.getInstant().getUrl();
		
		launchUrl(url);
		
		String userName = ConfigurationHelper.getInstant().getUserName();
		
		userInput(st.getLogInPage().getUsername(), userName);
		
		String password = ConfigurationHelper.getInstant().getPassword();
		
		userInput(st.getLogInPage().getPassword(), password);
		
		clickOnElement(st.getLogInPage().getLoginButton());
		
		sleep();
		
		navigatBack();
		
		clickOnElement(st.getLogInPage().getCreateAccount());
		
		
		String firstName = ConfigurationHelper.getInstant().getFirstName();
		
		userInput(st.getSignUp().getFirstName(), firstName);
		
		String lastName = ConfigurationHelper.getInstant().getLastName();
		
		userInput(st.getSignUp().getLastName(), lastName);
		
		
		screenShot("facebook");
		
		
	}

}

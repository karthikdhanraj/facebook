package com.facebook.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SingleTonDesignPattern {
	
	public static WebDriver driver;
	
	
	public SingleTonDesignPattern(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}


	public LogInPage getLogInPage() {
		
		LogInPage lp = new LogInPage(driver);
		return lp;
		
	}
	
	
	public SignUp getSignUp() {
		
		SignUp sp = new SignUp(driver);
		return sp;

	}

}

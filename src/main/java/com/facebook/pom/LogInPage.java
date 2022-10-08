package com.facebook.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	public static WebDriver driver;
	
	
	@FindBy(tagName = "h2")
	private WebElement text;
	
	@FindBy(id = "email")
	private WebElement username;
	
	@FindBy(id = "pass")
	private WebElement password;
	
	@FindBy(name = "login")
	private WebElement loginButton; 
	
	@FindBy(xpath = "(//a[@role='button'])[2]")
	private WebElement createAccount;
		
	
	public LogInPage(WebDriver driver2) {
		this.driver= driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getText() {
		return text;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public WebElement getCreateAccount() {
		return createAccount;
	}
	
	

}

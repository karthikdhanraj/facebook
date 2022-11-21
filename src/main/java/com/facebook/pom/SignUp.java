package com.facebook.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {
	public static WebDriver driver;
	
	
	@FindBy(name = "firstname")
	private WebElement firstName;
	
	@FindBy(name = "lastname")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@aria-label='Mobile number or email address']")
	private WebElement emailOrPhone;
	
	@FindBy(xpath = "//input[@aria-label='Re-enter email address']")
	private WebElement reEnterEmailId;
	
	@FindBy(xpath = "(//input[@type='password'])[2]")
	private WebElement newPassword;
	
	

	@FindBy(name  = "birthday_day")
	private WebElement dobDay;
	
	@FindBy(name = "birthday_month")
	private WebElement dobMonth;
	
	@FindBy(name = "birthday_year")
	private WebElement dobYear;
	
	@FindBy(xpath = "//span[@data-name='gender_wrapper']/span[1]")
	private WebElement genderFemale;
	
	@FindBy(xpath = "//span[@data-name='gender_wrapper']/span[2]")
	private WebElement genderMale;
	
	@FindBy(xpath = "//span[@data-name='gender_wrapper']/span[3]")
	private WebElement genderCustom;
	
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement submit;
	
	
	
	public WebElement getReEnterEmailId() {
		return reEnterEmailId;
	}

	
	public WebElement getNewPassword() {
		return newPassword;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public WebElement getDobDay() {
		return dobDay;
	}

	public WebElement getDobMonth() {
		return dobMonth;
	}

	public WebElement getDobYear() {
		return dobYear;
	}

	public WebElement getGenderMale() {
		return genderMale;
	}

	public WebElement getGenderFemale() {
		return genderFemale;
	}

	public WebElement getGenderCustom() {
		return genderCustom;
	}

	public WebElement getSubmit() {
		return submit;
	}

	
	
			
			
	
	
	
	
	public SignUp(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmailOrPhone() {
		return emailOrPhone;
	}
	
	
	
	

}

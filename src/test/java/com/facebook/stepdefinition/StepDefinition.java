package com.facebook.stepdefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;


import com.facebook.facebook.BaseClass;
import com.facebook.pom.SingleTonDesignPattern;
import com.facebook.property.ConfigurationHelper;
import com.facebook.runner.TestRunner;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass{
	
	public static WebDriver driver= TestRunner.driver;
	
	SingleTonDesignPattern st = new SingleTonDesignPattern(driver);
	
	@When("Use Launch The WebPagThen")
	public void use_launch_the_web_pag_then() throws IOException {

		String url = ConfigurationHelper.getInstant().getUrl();
		
		launchUrl(url);
	   
	}

	@Then("User Enter The UserName And Password")
	public void user_enter_the_user_name_and_password() throws Exception {
        
		String userName = ConfigurationHelper.getInstant().getUserName();
		
		userInput(st.getLogInPage().getUsername(), userName);
		
		String password = ConfigurationHelper.getInstant().getPassword();
		
		userInput(st.getLogInPage().getPassword(), password);
		
	   }

	@Then("User Enter The LogInButton")
	public void user_enter_the_log_in_button() throws Exception {
        
		clickOnElement(st.getLogInPage().getLoginButton());
		
		sleep();
	    
	   }

	@Then("User Navigate To SignUp Page")
	public void user_navigate_to_sign_up_page() throws Exception {
         
		navigatBack();
         
        clickOnElement(st.getLogInPage().getCreateAccount());
		
	   }

	@Then("Use Enter The First Last Name And Phone Number")
	public void use_enter_the_first_last_name_and_phone_number() throws IOException {
	   
        String firstName = ConfigurationHelper.getInstant().getFirstName();
		
		userInput(st.getSignUp().getFirstName(), firstName);
		
		String lastName = ConfigurationHelper.getInstant().getLastName();
		
		userInput(st.getSignUp().getLastName(), lastName);
		
		}
	
	@Then("ScreenShot The Page")
	public void screen_shot_the_page() throws IOException {
		
		screenShot("facebook");
	    
	}



}

package com.facebook.stepdefinition;

import java.io.IOException;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.facebook.facebook.BaseClass;
import com.facebook.pom.SingleTonDesignPattern;
import com.facebook.property.ConfigurationHelper;
import com.facebook.runner.TestRunner;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass{
	
	public static WebDriver driver= TestRunner.driver;
	
	SingleTonDesignPattern st = new SingleTonDesignPattern(driver);
	
	@When("User Launch The WebPagThen")
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
	
	@Then("User Screenshot The Error Page")
	public void user_screenshot_the_error_page() throws IOException {
	   
		screenShot("loginerror");
		
	}

	@Then("User Navigate To SignUp Page")
	public void user_navigate_to_sign_up_page() throws Exception {
         
		navigatBack();
         
        clickOnElement(st.getLogInPage().getCreateAccount());
		
	   }

	
	
	@Then("User Enter The First Last Name And Phone Number or EmailId")
	public void user_enter_the_first_last_name_and_phone_number_or_email_id() throws Exception {
		
		 
        String firstName = ConfigurationHelper.getInstant().getFirstName();
		
		userInput(st.getSignUp().getFirstName(), firstName);
		
		String lastName = ConfigurationHelper.getInstant().getLastName();
		
		userInput(st.getSignUp().getLastName(), lastName);
		
		sleep();
		
		String emailId = ConfigurationHelper.getInstant().getEmailId();
		
		userInput(st.getSignUp().getEmailOrPhone(), emailId);
		
		userInput(st.getSignUp().getReEnterEmailId(), emailId);
		
		String newPassword = ConfigurationHelper.getInstant().getNewPassword();
		
		userInput(st.getSignUp().getNewPassword(),newPassword);
		
		sleep();
	  
	}

	@Then("User Enter The DoB")
	public void user_enter_the_do_b() throws IOException {
		
		String dob = ConfigurationHelper.getInstant().getDob();
		String[] dobSplit = dob.split("/");
		
	    String year = dobSplit[2];
	    String month = dobSplit[1];
	    String day = dobSplit[0];
	   
	    
	    Select dayDropDown = new Select(st.getSignUp().getDobDay());
	    
	    dayDropDown.selectByVisibleText(day);
	    
	    Select monthDropDown = new Select(st.getSignUp().getDobMonth());
	    
	    monthDropDown.selectByValue(month);
	    
	    Select yearDropDown = new Select(st.getSignUp().getDobYear());
	    
	    yearDropDown.selectByValue(year);
	    
	    
	   }

	@Then("User Enter The Gender")
	public void user_enter_the_gender() throws Exception {
		
		String gender = ConfigurationHelper.getInstant().getGender();
		
		if (gender.equalsIgnoreCase("male")) {
			
			clickOnElement(st.getSignUp().getGenderMale());
			
			}else if (gender.equalsIgnoreCase("female")) {
				
				clickOnElement(st.getSignUp().getGenderFemale());
				
			} else if (gender.equalsIgnoreCase("custom")) {
				
				clickOnElement(st.getSignUp().getGenderCustom());
				
			}
		
		}

	@Then("User SignUP And Take ScreenShot")
	public void user_sign_up_and_take_screen_shot() throws Exception {
	    
		clickOnElement(st.getSignUp().getSubmit());
		
		sleep();
		
		screenShot("newaccount");
	}
	
	



}

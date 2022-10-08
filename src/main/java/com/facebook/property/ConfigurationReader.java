package com.facebook.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ConfigurationReader {
	
	
	
	private static Properties p;
	
	public ConfigurationReader() throws IOException {
		
		File f = new File("C:\\Users\\ADMIN\\eclipse-selenium\\facebook\\src\\main\\java\\com\\facebook\\property\\Facebook.properties");
		
		FileInputStream fi = new FileInputStream(f);
		
	    p = new Properties();
		
		p.load(fi);

}
	
	public String getBrowser() {
		
		String browser = p.getProperty("browser");
		return browser;
		
	}
	
	public String getUrl() {
		
		String url = p.getProperty("url");
		return url;

	}
	
	public String getUserName() {
		
		String username = p.getProperty("username");
		return username;

	}
	
	public String getPassword() {
		
		String password = p.getProperty("password");
	    return password;

	}
	
	public String getFirstName() {
		
		String firstname = p.getProperty("firstname");
		return firstname;

	}
	
	public String getLastName() {
		String lastname = p.getProperty("lastname");
		return lastname;

	}
	
	
	
}

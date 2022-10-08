 package com.facebook.facebook;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	
    public static WebDriver driver;
	
	public static void userInput(WebElement element, String value) {
		element.sendKeys(value);
		}
	
	public static void clickOnElement(WebElement element) {
		element.click();
	    }
	
	public static void printText(WebElement element) {
		
		String text = element.getText();
		System.out.println("the text is " +text);
		
		}
	
	public static void isEnabled(WebElement element) {
		boolean check = element.isEnabled();
		System.out.println("check whether the element is enabled "+check);

	}
	
	public static void isDisplayed(WebElement element) {
		boolean a = element.isDisplayed();
		System.out.println("The Element is Displayed" +a);

	}
	
	public static WebDriver LaunchBrowser(String browser) {
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\eclipse-selenium\\facebook\\driver\\chromedriver.exe");
		    driver = new ChromeDriver();
			
		}else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			
		}else if (browser.equalsIgnoreCase("gecko")) {
			driver = new FirefoxDriver();
			
		}else {
			System.out.println("Invalid Browser");
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}
	
	
	public static String launchUrl(String url) {
		driver.get(url);
		return url;

	}
	
	public static void currentUrl(String url) {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

	}
	
	public static void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);

	}
	
	public static void close() {
		driver.close();

	}
	
	public static void quit() {
		driver.quit();

	}
	
	public static void accepAlert(String text) {
		Alert alert = driver.switchTo().alert();
		if (text.equalsIgnoreCase("ok")) {
			alert.accept();
			
		}else if (text.equalsIgnoreCase("cancel")) {
			alert.dismiss();
		}
		else {
			System.out.println("invalid argument");
		}
	}
	
	public static void alertPromt(String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);

	}
	
	public static void actions(String options, WebElement element) {
		Actions act = new Actions(driver);
		
		if (options.equalsIgnoreCase("move")) {
			act.moveToElement(element).perform();;
			
		}else if (options.equalsIgnoreCase("right")) {
			act.contextClick(element).perform();;
			
		}else if (options.equalsIgnoreCase("click")) {
			act.click(element).perform();
			
		}else if (options.equalsIgnoreCase("double")) {
			act.doubleClick(element).perform();
			
		}else {
			System.out.println("invalid option");
		}

	}
	public static void screenShot(String name) throws IOException {
		
			TakesScreenshot tk = (TakesScreenshot) driver;
			File Sour = tk.getScreenshotAs(OutputType.FILE);
			File Des = new File("C:\\Users\\ADMIN\\eclipse-selenium\\facebook\\Report\\screenshot\\" + name + ".png");
			
			FileUtils.copyFile(Sour, Des);
		} 
		
	
	
	public static void sleep() throws Exception {
		
			Thread.sleep(3000);
			}
	
	
	
	public static void Drag(WebElement drag, WebElement drop) {
		
			Actions ac = new Actions(driver);
			ac.dragAndDrop(drag, drop).build().perform();
			// ac.clickAndHold(drag).moveToElement(drop).release(drop).build().perform();
		
		}
	
	public static void SelectBy(WebElement element, String option, String value) {
		
			Select s = new Select(element);
			if (option.equalsIgnoreCase("index")) {
				int x = Integer.parseInt(value);
				s.selectByIndex(x);
			} else if (option.equalsIgnoreCase("value")) {
				s.selectByValue(value);
			} else if (option.equalsIgnoreCase("text")) {
				s.selectByVisibleText(value);
			} else if (option.equalsIgnoreCase("deindex")) {
				int y = Integer.parseInt(value);
				s.deselectByIndex(y);
			} else if (option.equalsIgnoreCase("devalue")) {
				s.deselectByValue(value);
			} else if (option.equalsIgnoreCase("detext")) {
				s.deselectByVisibleText(value);
			}

		}
	
	
	public static void getoption(WebElement element, String option) {
		
			Select s2 = new Select(element);
			if (option.equalsIgnoreCase("getoption")) {
				List<WebElement> options = s2.getOptions();
				for (WebElement all : options) {
					System.out.println(all.getText());
				}
			} else if (option.equalsIgnoreCase("getfirst")) {
				WebElement firstSelectedOption = s2.getFirstSelectedOption();
				System.out.println(firstSelectedOption.getText());
			} else if (option.equalsIgnoreCase("getall")) {
				List<WebElement> allSelectedOptions = s2.getAllSelectedOptions();
				for (WebElement x : allSelectedOptions) {
					System.out.println(x.getText());
				}
			}
	
		}
	
	
	public static void Deselectall(WebElement element) {
		
			Select s3 = new Select(element);

			s3.deselectAll();

		
		}
	
	public static void IsMultiple(WebElement element) {
	
			Select s4 = new Select(element);
			boolean multiple = s4.isMultiple();
			System.out.println(multiple);
	        }
	public static void Navigate(String name) {
		
			if (name.equalsIgnoreCase("back")) {
				driver.navigate().back();
			} else if (name.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			} else if (name.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			}

		}
	
	public static void navigatBack() {
		driver.navigate().back();

	}

	}



	
	
	
	
	



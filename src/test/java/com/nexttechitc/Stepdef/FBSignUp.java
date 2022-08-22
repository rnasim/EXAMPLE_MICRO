package com.nexttechitc.Stepdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.nexttechitc.Pageobjectmodel.FBSignUpPOM;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FBSignUp {
	WebDriver driver;
	@Given("^user visiting facebook url$")
	public void user_visiting_facebook_url() throws Throwable {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
			//setProperty = hashmap(    Key				,    Value = path 
			driver = new ChromeDriver();
			
			/*======================================================================
			 *::::::::::::::::::::::::::  SOFT WAIT  :::::::::::::::::::::::::::::::
			 * Implicit/global wait:
			 * 		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 * 		- syncs to give wait time for when a lot of people are using the server
			 * 		- between browser and URL
			 * Explicit/Local wait(Web driver wait):
			 * 		WebDriverWait wait = new WebDriverWait(driver, 20);
			 ======================================================================*/
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			//=============================================================================
				/*
				 * Maximize the window:
				 * 		1. Why? 
				 * 			When the window is minimize not all web elements are visible that is 
				 * 			why we have to maximize the window
				 * 		2. You cannot click on any web element if the element is not visible
				 * 		
				 */
			driver.manage().window().maximize();
			//==============================================================================
					
			
			// how to open the url?
			driver.get("https://www.facebook.com/reg");
			Thread.sleep(3000); //Hard wait
			
			
			
		}catch(Exception e) {
			System.out.println("Browser and url not opening");
		}
	}

	@When("^user enter \"([^\"]*)\" and\"([^\"]*)\" and valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enter_and_and_valid_and(String arg1, String arg2, String arg3, String arg4) throws Throwable {
	    try {
	    	FBSignUpPOM fbsignup = new FBSignUpPOM(driver);
	    	
	    	fbsignup.firstname().sendKeys(arg1);
	    	fbsignup.lastname().sendKeys(arg2);
	    	fbsignup.email().sendKeys(arg3);
	    	fbsignup.password().sendKeys(arg4);
	    	
	    }
	    catch(Exception e) {
	    	System.out.println("element not found exception");
	    }
	}

	@Then("^user select dropdown Month and dropdown Day and dropdown Year$")
	public void user_select_dropdown_Month_and_dropdown_Day_and_dropdown_Year() throws Throwable {
		try {
	    	FBSignUpPOM fbsignup1 = new FBSignUpPOM(driver);
	    	Select dropdown = new Select(fbsignup1.click_month);
	    	
	    	dropdown.selectByIndex(2);
	    	Thread.sleep(3000);
	    	
	    	Select dropdown1 = new Select(fbsignup1.click_day);
	    	
	    	dropdown1.selectByValue("2");
	    	Thread.sleep(3000);
	    	
	    	Select dropdown2 = new Select(fbsignup1.click_year);
	    	
	    	dropdown2.selectByVisibleText("2000");
	    	Thread.sleep(3000);
	    	
		}catch (Exception e) {
			System.out.println("element not found exception");
		}
	}
}

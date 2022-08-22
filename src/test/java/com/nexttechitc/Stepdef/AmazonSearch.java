package com.nexttechitc.Stepdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nexttechitc.Pageobjectmodel.AmazonSearchPOM;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonSearch {
	WebDriver driver;
	@Given("^user visit amazon homepage$")
	public void user_visit_amazon_homepage() throws Throwable {
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
			driver.get("https://www.amazon.com/");
			Thread.sleep(3000); //Hard wait
			
			
			
		}catch(Exception e) {
			System.out.println("Browser and url not opening");
		}
		
	}

	@When("^user type \"([^\"]*)\" and click search icon$")
	public void user_type_and_click_search_icon(String arg1) throws Throwable {
	   try {
		   AmazonSearchPOM searchObj = new AmazonSearchPOM(driver);
		   searchObj.AmazonSearch().sendKeys(arg1);
		   searchObj.searchIcon().click();
		   WebDriverWait wait = new WebDriverWait(driver, 20); 
		   // local wait
		   
	   }catch(Exception e) {
		   System.out.println("SendKeys() or click() not working!");
	   }
	}

	@Then("^user should able to see the expected product$")
	public void user_should_able_to_see_the_expected_product() throws Throwable {
	    /*========================================================================
	     * How to terminate the browser Window:
	     *	1. driver.close();
	     *	2. driver.quit();
	     *
	     * What is the difference between .close() and .quit():
	     *	1. driver.close(): 
	     *			Only the current browser window will close.
	     *	2. driver.quit();
	     *			All the browser windows will close at once.
	     *	     ***This is the standard and most used*****
	     *
		==========================================================================*/
		driver.close();
	    driver.quit();
	}
}

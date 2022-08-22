package com.nexttechitc.Stepdef;


import com.nexttechitc.Pageobjectmodel.DellActionPOM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DellAction {
	WebDriver driver;
	@Given("^user visits Dell homepage$")
	public void user_visits_Dell_homepage() throws Throwable {
		
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
			driver.get("https://www.dell.com/en-us");
			Thread.sleep(3000); //Hard wait
			
			
			
		}catch(Exception e) {
			System.out.println("Browser and url not opening");
		}
	}

	@When("^user go to Solutions dropdown menu and able to see View All Solutions$")
	public void user_go_to_Solutions_dropdown_menu_and_able_to_see_View_All_Solutions() throws Throwable {
	    try {
	    	
	    	Actions act = new Actions(driver);
	    	
	    	DellActionPOM actionObj = new DellActionPOM(driver);
	    		    	
	    	act.moveToElement(actionObj.allSolution()).build().perform();
	    	
	    	actionObj.viewAllSolution().click();
	    	
	    }catch(Exception e) {
	    	System.out.println("Element not found Exception");
	    }
		
		
		
		/*DellActionPOM contactus = new DellActionPOM(driver);
	    contactus.contactus().click();
	   */
	    
	}

	@Then("^user redirects to solution portfolio$")
	public void user_redirects_to_solution_portfolio() throws Throwable {
	    
	}
}

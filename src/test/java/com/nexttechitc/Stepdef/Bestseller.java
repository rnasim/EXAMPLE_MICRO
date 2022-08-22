package com.nexttechitc.Stepdef;

import com.nexttechitc.Pageobjectmodel.BestsellerPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Bestseller {
	WebDriver driver;
	@Given("^user visits Amazon homepage$")
	public void user_visits_Amazon_homepage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		//setProperty = hashmap(    Key				,    Value = path 
		driver = new ChromeDriver();
		//--------------------------------------------------------------------------------------
		// how to open the url?
		driver.get("https://www.amazon.com/");
		Thread.sleep(3000);
	}

	@When("^user clicks on Best seller$")
	public void user_clicks_on_Best_seller() throws Throwable {
	    BestsellerPOM bestseller = new BestsellerPOM(driver);
	    bestseller.bestseller().click();
	    
	    Thread.sleep(3000);
	    
	    BestsellerPOM newReleases = new BestsellerPOM(driver);
	    newReleases.click_newReleases().click();
	}

	@Then("^user should be able to redirect to the Best Seller Page$")
	public void user_should_be_able_to_redirect_to_the_Best_Seller_Page() throws Throwable {
	    
	}
}

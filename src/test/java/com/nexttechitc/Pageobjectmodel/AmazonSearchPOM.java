package com.nexttechitc.Pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearchPOM {
	WebDriver driver;
	public AmazonSearchPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="field-keywords")
	WebElement type_AmazonSearch;
	public WebElement AmazonSearch() {
		return type_AmazonSearch;
	}
	
	@FindBy(id="nav-search-submit-button")
	WebElement click_searchIcon;
	public WebElement searchIcon() {
		return click_searchIcon;
	}
	
	
}

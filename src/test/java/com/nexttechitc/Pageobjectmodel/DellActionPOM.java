package com.nexttechitc.Pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class DellActionPOM {
	WebDriver driver;
	public DellActionPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "/html/body/main/section[1]/header/div[2]/div[2]/nav/ul/li[3]/button/span")
	WebElement click_allSolution;
	public WebElement allSolution(){
		return click_allSolution;
	}
	
	@FindBy(xpath = "/html/body/main/section[1]/header/div[2]/div[2]/nav/ul/li[3]/ul/li[3]/a")
	WebElement click_viewAllSolution;
	public WebElement viewAllSolution() {
		return click_viewAllSolution;
	}
	/*@FindBy(xpath = "//a[@class=\"mh-contact-btn mh-flyout-link no-chevron\"]")
	WebElement click_contactus;
	public WebElement contactus(){
		return click_contactus;
	}
	*/
}

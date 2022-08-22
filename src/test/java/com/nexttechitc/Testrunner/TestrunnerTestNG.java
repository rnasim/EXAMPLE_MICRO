package com.nexttechitc.Testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public class TestrunnerTestNG {
	 @CucumberOptions ( // annotation cucumber options helps connect feature folder to stepdef package
			 features = {"Features"},
			 glue = {"com.nexttechitc.Stepdef"}
			 //tags= {"@sc2","@sc1"}
			 )
			 public class TestRunner extends AbstractTestNGCucumberTests{}

}

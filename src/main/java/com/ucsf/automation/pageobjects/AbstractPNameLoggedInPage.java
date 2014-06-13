package com.ucsf.automation.pageobjects;
import org.openqa.selenium.WebDriver;


public class AbstractPNameLoggedInPage   {

	
	protected WebDriver driver;
	
	public WebDriver getDriver(){
		return this.driver;
	}
	
	public AbstractPNameLoggedInPage(WebDriver driver) {
		this.driver = driver;
		
		
		}

}

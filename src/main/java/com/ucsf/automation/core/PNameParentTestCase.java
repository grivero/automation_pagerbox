package com.ucsf.automation.core;
 
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import com.ucsf.automation.pageobjects.CompensationEditPage;
import com.ucsf.automation.pageobjects.CompensationPerEmployeeTab;
import com.ucsf.automation.pageobjects.CompensationTab;
import com.ucsf.automation.pageobjects.ContactsTab;
import com.ucsf.automation.pageobjects.MainPage;
import com.ucsf.automation.pageobjects.NewCompensationButton;
import com.ucsf.automation.pageobjects.WhitePage;



public class PNameParentTestCase {
	
	protected MainPage mainPage;
	protected CompensationTab compensationTab;
	protected NewCompensationButton newCompensationButton;
	protected CompensationEditPage compensationEditPage;
	protected WhitePage whitePage;
	protected CompensationPerEmployeeTab compensationPerEmployeeTab;
	protected ContactsTab contactsPage;

	protected CommonPName common;
	public void initCommon(WebDriver driver) {
		this.common = new CommonPName(driver);
	}
	
	private WebDriver driver;

	protected WebDriver getDriver(){
		return this.driver;
	}


	
	protected void generateTestEnvironment() {
		this.mainPage = new MainPage(getDriver());
		this.compensationTab = new CompensationTab(getDriver());
		this.newCompensationButton = new NewCompensationButton(getDriver());
		this.compensationEditPage = new  CompensationEditPage(getDriver());
		this.whitePage = new WhitePage(getDriver());
		this.compensationPerEmployeeTab = new CompensationPerEmployeeTab(this.getDriver());
		this.contactsPage = new ContactsTab(this.getDriver());
		
	}
	
	@BeforeMethod
	public void setup() throws MalformedURLException{
		
		generateTestEnvironment();		
		this.driver = new FirefoxDriver();
		//this.getDriver().get("https://www.pagerbox.com/search/index.cfm?fuseaction=search&keywords=4430000"); MUST IMPLEMENT IN AUTOMATION CLASS
		
	}

	@AfterClass
	public void quit(){
		driver.quit();
	}
}

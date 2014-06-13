package com.ucsf.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Altimetrik
 *
 */

public class MainPage extends AbstractPNameLoggedInPage {

	@FindBy(how=How.CSS,using="[id='01ri0000000X2sz_Tab'] > a")
    private WebElement compensationsTab;
	
	@FindBy(how=How.CSS,using="[id='01ri0000000X2sz_Tab'] > a")
	private WebElement compensationsPerEmployTab;
	
	@FindBy(how=How.CSS,using="[id='Contact_Tab'] > a")
	private WebElement contactTab;

	private WebDriver driver;
	
	//Click Options
	public void clickCompensationTab(){
		compensationsTab.click();
		//this.compensationsTab.click();
	}
	
	public void clickCompenastionsPerEmployeeTab(){
		compensationsPerEmployTab.click();
	}
	
	public void clickContactTab(){
		contactTab.click();
	}
	
	/**
	 * @param driver
	 */
	public MainPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}

		
}

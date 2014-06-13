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
public class CloudServicesPage extends AbstractPNameLoggedInPage  {
	
	@FindBy(how=How.ID,using="01ri0000000X2sz_Tab")
	private WebElement compensationsTab;
	
	@FindBy(how=How.ID,using="01ri0000000X2t0_Tab")
	private WebElement compensationsPerEmployTab;
	
	@FindBy(how=How.ID,using="Contact_Tab")
	private WebElement contactTab;
	
	
	public void clickCompensationTab(){
		compensationsTab.click();
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
	public CloudServicesPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}	
}
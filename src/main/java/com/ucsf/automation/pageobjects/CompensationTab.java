package com.ucsf.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class CompensationTab extends AbstractPNameLoggedInPage  {

	@FindBy(how=How.CSS,using=".pbButton > .btn")
	private WebElement newCompensationButton;

	@FindBy(how=How.CSS,using="span.fBody > .btn")
	private WebElement allCompansations;

	@FindBy(how=How.CSS,using="#home_Tab > a")
	private WebElement mainTab;

	
	
	//Click Options
	public void clickNewCompensationButton(){
		newCompensationButton.click();
	}

	public void clickAllCompensations(){	
		allCompansations.click();
	}

	public void clickMainTab(){
		mainTab.click();
	}
	
	/**
	 * @param driver
	 */
	public CompensationTab(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}


}

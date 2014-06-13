package com.ucsf.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class ContactsTab extends AbstractPNameLoggedInPage {
	
	@FindBy(how=How.CSS,using=".btn + [name='mm']")
	private WebElement requestUpdateButton;
	
	@FindBy(how=How.CSS,using=".textBlock > .topName")
	private WebElement topNameLabel;
	
	private WebDriver driver;
	
	public boolean isRequestUpdateDispayed(){
		return requestUpdateButton.isDisplayed();
	}
	
	public String getTopNameLabelName(){
		return this.topNameLabel.getText();
	}
	
	
	public ContactsTab(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
}

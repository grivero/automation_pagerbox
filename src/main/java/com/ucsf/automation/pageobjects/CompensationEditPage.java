package com.ucsf.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class CompensationEditPage extends AbstractPNameLoggedInPage {
	
	@FindBy(how=How.CSS,using=".mainTitle")
	private WebElement detailsLabel;
	
	@FindBy(how=How.CSS,using=".pbButton > [name=del]")
	private WebElement deleteButton;
	
	private WebDriver driver;
	
	public boolean isDetailsLabelDisplayed(){
		return detailsLabel.isDisplayed();
	}
	
	public void clickDeleteButton(){
		deleteButton.click();
	}
	
	public boolean isDeleteButtonPresent(){
		
		try {
			boolean aux;
			aux = this.deleteButton.isDisplayed();
			return aux;
		} catch (Exception e) {	
			return false;
		}
	}
	
	//Accepts alert when deleting
	public void clickDeleteButtonAccept(){
		this.clickDeleteButton();
		this.driver.switchTo().alert().accept();
		
	}
	
	//Dismiss alert and don't delete
	public void clickDeleteButtonCancel(){
		this.clickDeleteButton();
		this.driver.switchTo().alert().dismiss();
	}
	
	public CompensationEditPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}



}

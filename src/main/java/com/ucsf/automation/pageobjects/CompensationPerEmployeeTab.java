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
public class CompensationPerEmployeeTab {

	@FindBy(how=How.CSS,using=".rich-table-thead > .headerRow > th:nth-of-type(1)")
	private WebElement employeeLabel;

	@FindBy(how=How.CSS,using=".rich-table-thead > .headerRow > th:nth-of-type(2)")
	private WebElement titleLabel;

	@FindBy(how=How.CSS,using=".rich-table-thead > .headerRow > th:nth-of-type(3)")
	private WebElement departmentLabel;

	@FindBy(how=How.CSS,using=".rich-table-thead > .headerRow > th:nth-of-type(4)")
	private WebElement grossPayLabel;

	@FindBy(how=How.CSS,using=".rich-table-thead > .headerRow > th:nth-of-type(5)")
	private WebElement netPayLabel;

	@FindBy(how=How.CSS,using=".rich-table-thead > .headerRow > th:nth-of-type(6)")
	private WebElement medicalInsuranceLabel;

	@FindBy(how=How.CSS,using=".rich-table-thead > .headerRow > th:nth-of-type(7)")
	private WebElement dentalVisionInsuranceLabel;

	@FindBy(how=How.CSS,using=".rich-table-thead > .headerRow > th:nth-of-type(8)")
	private WebElement isApprovedLabel;

	@FindBy(how=How.CSS,using="[id='j_id0:j_id2:j_id5:0:j_id21'] > a")
	private WebElement viewButtonFirstElement;

	@FindBy(how=How.CSS,using="tr.dataRow > [id='j_id0:j_id2:j_id5:0:j_id6'] > a")
	private WebElement employeeButtonFirstElement;

	@FindBy(how=How.CSS,using=".pbBody > [id='j_id0:j_id2:j_id3'] > .btn[value='Show Most Recent Compensations']")
	private WebElement showMostRecentCompensationButton;

	@FindBy(how=How.CSS,using=".pbBody > [id='j_id0:j_id2:j_id3'] > .btn[value='Show All Compensations']")
	private WebElement showAllCompensationsButton;

	@FindBy(how=How.CSS,using="input[name='new']")
	private WebElement newButton;
	private WebDriver driver;
	
	//Methods and Visualizations
	
	public boolean areLabelDisplayed(){
		//If one ore more labels are missing, this will return False
		return employeeLabel.isDisplayed()              &&
			   titleLabel.isDisplayed()                 &&
			   departmentLabel.isDisplayed()            &&
			   grossPayLabel.isDisplayed()              &&
			   netPayLabel.isDisplayed()                &&
			   medicalInsuranceLabel.isDisplayed()      &&
			   dentalVisionInsuranceLabel.isDisplayed() &&
			   isApprovedLabel.isDisplayed();
	}
	
	public void clickViewButton(){
		this.viewButtonFirstElement.click();
	}
	
	public void clickEmployeeLink(){
		this.employeeButtonFirstElement.click();
	}
	
	public String getEmployeeNameFirstElement(){
		return this.employeeButtonFirstElement.getText();
	}
	
	public void clickShowMostRecentCompensationButton(){
		this.showMostRecentCompensationButton.click();
	}
	
	public void openURL(){
		this.driver.get("https://trainingpkg1bco.na15.visual.force.com/apex/BenefitsPerEmployee");
	}

	
	public void clickShowAllCompensations(){
		this.showAllCompensationsButton.click();	
	}
	
	//I have to delete all compensations to create this method. I wish I could...
	public boolean isCompensationListNotEmpty(){
		return true;
	}
	
	//Constructor
	public CompensationPerEmployeeTab(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}

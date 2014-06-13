package com.ucsf.automation.pageobjects;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class NewCompensationButton extends AbstractPNameLoggedInPage {
	
	@FindBy(how=How.CSS,using=".btn[name='save']")
	private WebElement saveButton;
	
	@FindBy(how=How.ID,using="CF00Ni000000Bld3h")
	private WebElement employeeField;
	
	@FindBy(how=How.ID,using="00Ni000000Bld3o")
	private WebElement grossPayField;
	
	@FindBy(how=How.ID,using="errorDiv_ep")
	private WebElement errorDisplay;
	
	@FindBy(how=How.CSS,using=".detailList > tbody > tr > .dataCol > [tabindex='5']")
	private WebElement hasMedicalInsurenceCheckBox;
	
	@FindBy(how=How.CSS,using=".detailList > tbody > tr > .dataCol > [tabindex = '3']")
	private WebElement dentalCheckbox;
	
	@FindBy(how=How.CSS,using=".dataCol > input[tabindex='5']")
	private WebElement approvedCheckbox;
	
	
	//Picklist options from MedicalInsurance
	@FindBy(how=How.CSS,using=".requiredInput > span > span > [tabindex='8'] > [value='']")
	private WebElement medicalInsureancePicklistNoneValue;
	
	@FindBy(how=How.CSS,using=".requiredInput > span > span > [tabindex='8'] > [value='Employee only']")
	private WebElement medicalInsureancePicklistEmployeeOnlyValue;
	
	@FindBy(how=How.CSS,using=".requiredInput > span > span > [tabindex='8'] > [value='Employee and partner']")
	private WebElement medicalInsureancePicklistEmployeeAndPartnerValue;
	
	@FindBy(how=How.CSS,using=".requiredInput > span > span > [tabindex='8'] > [value='Employee and family']")
	private WebElement medicalInsureancePicklistEmployeeAndFamilyValue;
	
	
	
	//Piclist options from DentalInsurance
	@FindBy(how=How.CSS,using=".dataCol > .requiredInput > span[style='white-space:nowrap;''] > span > [tabindex='6'] > [value='']")
	private WebElement dentalInsurancePicklistNoneValue;
	
	@FindBy(how=How.CSS,using=".dataCol > .requiredInput > span[style='white-space:nowrap;''] > span > [tabindex='6'] > [value='Employee Only']")
	private WebElement dentalInsurancePicklistEmployeeOnlyValue;
	
	@FindBy(how=How.CSS,using=".dataCol > .requiredInput > span[style='white-space:nowrap;''] > span > [tabindex='6'] > [value='Employee and partner']")
	private WebElement dentalInsurancePicklistEmployeeAndPartnerValue;
	
	@FindBy(how=How.CSS,using=".dataCol > .requiredInput > span[style='white-space:nowrap;''] > span > [tabindex='6'] > [value='Employee and family']")
	private WebElement dentalInsurancePicklistEmployeeAndFamilyValue;
	
	
	
	
	
	
	//Click & Visualizations Methods
	
	public boolean isErrorDisplayDisplayed(){
		
		return this.errorDisplay.isDisplayed();
	}
	
	public void clickSaveButton (){
		
		this.saveButton.click();
	}
	
	public void enterEmployeeText(String text){
	
		this.employeeField.sendKeys(text);
	}
	
	public void enterGrossPayText(String text){
		
		this.grossPayField.sendKeys(text);
	}
	
	public void checkMedicalInsurenceCheckBox(){
		
		this.hasMedicalInsurenceCheckBox.click();
		
	}
	
	public void checkIsApprovedCheckbox(){
		
		this.approvedCheckbox.click();
		
	}
	
	public void checkDentalInsuranceCheckbox(){
		
		this.dentalCheckbox.click();
		
	}
	
	public void selectMedialInsuranceCheckboxRandomOption(){
		
		Random r = new Random();
		
		int Low = 1;
		int High = 4;
		int R = r.nextInt(High-Low) + Low;
	
		//This will call the method with a random number between 1 and 3. 0 can't be selected because --None-- is not an accepted value
		this.selectMedicalInsurancePicklistOption(R);
	}
	
	
	//This will select an option on the Medical Insurance Checkbox from the 4 options. The integer on the argument will select which option (from 0 to 3)
	private void selectMedicalInsurancePicklistOption(int i){
		switch (i) {
		case 0: this.medicalInsureancePicklistNoneValue.click();
			break;
		
		case 1: this.medicalInsureancePicklistEmployeeOnlyValue.click();
			break;
			
		case 2: this.medicalInsureancePicklistEmployeeAndPartnerValue.click();
			break;
			
		case 3: this.medicalInsureancePicklistEmployeeAndFamilyValue.click();
			break;	
		}
	}
	
	//This will select an option on the Dental Insurance Checkbox from the 4 options. The integer on the argument will select which option (from 0 to 3)
	private void selectDentalInsurancePicklistOption(int i){
		switch (i){
		
		case 0: this.dentalInsurancePicklistNoneValue.click();
			break;
		
		case 1: this.dentalInsurancePicklistEmployeeOnlyValue.click();
			break;
		
		case 2: this.dentalInsurancePicklistEmployeeAndPartnerValue.click();
			break;
		
		case 3: this.dentalInsurancePicklistEmployeeAndFamilyValue.click();
			break;
		}
	}
	
	
	//Select one by one the elements on Medical Picklist
	public void selectAllMedicalPlans(){
		for (int i = 0; i>4; i++){
			this.selectMedicalInsurancePicklistOption(i);
		}
	}
	
	//Select one by one the elements on Dental Picklist
	public void selectAllDentalPlans(){
		for (int i = 0; i>4; i++){
			this.selectDentalInsurancePicklistOption(i);
		}
		
	}
	
	
	
	
	
	/**
	 * @param driver
	 */
	public NewCompensationButton(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}

}

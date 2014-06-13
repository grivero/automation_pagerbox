package com.ucsf.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class WhitePage  extends AbstractPNameLoggedInPage {

	@FindBy(how=How.CSS,using="#bodyCell>table>tbody>tr>td>span")
	private WebElement title;
		
	//Is title displayed?
	public boolean isTitleDisplayed(){
		try {
			boolean aux;
			aux = this.title.isDisplayed();
			return aux;
			
		} catch (Exception e) {
			return false;
		}
		
	}


	public WhitePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

}


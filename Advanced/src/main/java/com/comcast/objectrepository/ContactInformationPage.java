package com.comcast.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInformationPage extends BasePage{

	public ContactInformationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//div[@id='tblContactInformation']/table/tbody/tr[2]/td[2]/span")
	private WebElement actualLastName;

	public WebElement getActualLastName() {
		return actualLastName;
	}
	
	
	
	

}

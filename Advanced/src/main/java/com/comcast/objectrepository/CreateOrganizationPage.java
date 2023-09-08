package com.comcast.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateOrganizationPage extends BasePage{

	public CreateOrganizationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(name = "accountname")
	private WebElement orgNameTextField;
	
	@FindBy(xpath = "(//input[@name='button'])[1]")
	private WebElement saveOrganizationButton;
	
	@FindBy(name = "industry")
	private WebElement industryTypeDropdown;
	
	@FindBy(id = "phone")
	private WebElement phoneNumTextField;

	public WebElement getOrgNameTextField() {
		return orgNameTextField;
	}

	public WebElement getSaveOrganizationButton() {
		return saveOrganizationButton;
	}

	public WebElement getIndustryTypeDropdown() {
		return industryTypeDropdown;
	}

	public WebElement getPhoneNumTextField() {
		return phoneNumTextField;
	}
	
	

}

package com.comcast.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationsPage extends BasePage{

	public OrganizationsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrganizationButton;

	public WebElement getCreateOrganizationButton() {
		return createOrganizationButton;
	}

}

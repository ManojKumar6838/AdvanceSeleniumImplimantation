package com.comcast.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListOfOrganizationsPage extends BasePage{

	public ListOfOrganizationsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//a[text()='TYSS']")
	private WebElement orgName;

	public WebElement getOrgName() {
		return orgName;
	}

}

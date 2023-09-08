package com.comcast.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationInformationPage extends BasePage{

	public OrganizationInformationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//div[@id='tblOrganizationInformation']/table/tbody/tr[1]/td[2]/span")
	private WebElement actualOrgName;
	
	@FindBy(xpath = "//div[@id='tblOrganizationInformation']/table/tbody/tr[2]/td[4]/span")
	private WebElement actualPhoneNum;

	public WebElement getActualOrgName() {
		return actualOrgName;
	}

	public WebElement getActualPhoneNum() {
		return actualPhoneNum;
	}
	
	
	

}

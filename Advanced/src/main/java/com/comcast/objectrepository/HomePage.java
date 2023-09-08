package com.comcast.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "(//a[contains(text(),'Organizations')])[1]")
	private WebElement organizationsLink;
	
	@FindBy(xpath = "(//a[text()='Contacts'])[1]")
	private WebElement contactsLink;

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}
	
	@FindBy(xpath = "//td[@style='padding-right:10px;']/table/tbody/tr/td[2]")
	private WebElement logoutIcon;
	
	@FindBy(partialLinkText = "Sign Out")
	private WebElement signoutButton;

	public WebElement getLogoutIcon() {
		return logoutIcon;
	}

	public WebElement getSignoutButton() {
		return signoutButton;
	}
	
	

}

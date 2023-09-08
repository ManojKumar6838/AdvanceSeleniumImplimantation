package com.comcast.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ContactsPage extends BasePage{

	public ContactsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContactButton;

	public WebElement getCreateContactButton() {
		return createContactButton;
	}
	
	//Just practice
	@FindBys({@FindBy(xpath = "1st xpath"), @FindBy(id = "2nd locator")})
	private WebElement userName;
	
	//Just practice
	@FindAll({@FindBy(xpath = "1st xpath"), @FindBy(id = "2nd locator")})
	private WebElement pwd;

}

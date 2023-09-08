package com.comcast.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateContactsPage extends BasePage{

	public CreateContactsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public WebElement getLastnameTextField() {
		return lastnameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getSelectOrgnizationButton() {
		return selectOrgnizationButton;
	}

	public WebElement getStartDateTextField() {
		return startDateTextField;
	}

	public WebElement getEndDateTextField() {
		return endDateTextField;
	}


	@FindBy(name = "lastname")
	private WebElement lastnameTextField;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement saveButton;
	
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement selectOrgnizationButton;
	
	@FindBy(id = "jscal_field_support_start_date")
	private WebElement startDateTextField;
	
	@FindBy(id = "jscal_field_support_end_date")
	private WebElement endDateTextField;
	

}

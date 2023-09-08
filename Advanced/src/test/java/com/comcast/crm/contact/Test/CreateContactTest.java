package com.comcast.crm.contact.Test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.lang.reflect.Method;
//import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
import org.testng.annotations.Test;

//import com.comcast.crm.generic.browserutility.Browser;
import com.comcast.crm.generic.fileutility.ReadExcelData;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.genericutility.BaseClass;
import com.comcast.objectrepository.ContactInformationPage;
import com.comcast.objectrepository.ContactsPage;
import com.comcast.objectrepository.CreateContactsPage;
import com.comcast.objectrepository.HomePage;

public class CreateContactTest extends BaseClass {

	@Test
	public void createContactTest(Method method) throws Throwable {
		//Browser browser=new Browser();
		//browser.navigateToWebpage();
		ReadExcelData excel=new ReadExcelData();
		String name=excel.readExcel("Test", 2, 1);
		
		HomePage home=new HomePage(driver);
		home.getContactsLink().click();
		//driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		ContactsPage contacts=new ContactsPage(driver);
		contacts.getCreateContactButton().click();
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		CreateContactsPage createContact=new CreateContactsPage(driver);
		createContact.getLastnameTextField().sendKeys(name);
		//driver.findElement(By.name("lastname")).sendKeys(name);
		createContact.getSaveButton().click();
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		ContactInformationPage contactInfo=new ContactInformationPage(driver);
		String actName=contactInfo.getActualLastName().getText();
		//String actName=driver.findElement(By.xpath("//div[@id='tblContactInformation']/table/tbody/tr[2]/td[2]/span")).getText();
		System.out.println(actName);
		
		WebDriverUtility web=new WebDriverUtility();
		web.takeScreenshot(driver, method);
		
		
		//assertEquals(actName, name);
		assertEquals(actName, name);
//		if(actName.contains(name)) {
//			System.out.println(name+" is displayed TS is Passed");
//		}
//		else
//			System.out.println(name+" is not displayed TS is Failed");
//	//	browser.logoutAndClose();
	}
	
	@Test
	public void heyYou() {
		Reporter.log("HeyYou", true);
	}
}
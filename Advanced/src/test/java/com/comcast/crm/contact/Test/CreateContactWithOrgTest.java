package com.comcast.crm.contact.Test;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

//import com.comcast.crm.generic.browserutility.Browser;
import com.comcast.crm.generic.fileutility.ReadExcelData;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.genericutility.BaseClass;
import com.comcast.objectrepository.ContactInformationPage;
import com.comcast.objectrepository.ContactsPage;
import com.comcast.objectrepository.CreateContactsPage;
import com.comcast.objectrepository.HomePage;
import com.comcast.objectrepository.ListOfOrganizationsPage;

public class CreateContactWithOrgTest extends BaseClass {

	@Test(groups = "regression")
	public void createContactTest(Method method) throws Throwable {
		//Browser browser=new Browser();
		//browser.navigateToWebpage();
		WebDriverUtility web=new WebDriverUtility();
		ReadExcelData excel=new ReadExcelData();
		String name=excel.readExcel("Test", 2, 1);
		String homeHandle = driver.getWindowHandle();
		//System.out.println(homeHandle);
		
		HomePage home=new HomePage(driver);
		home.getContactsLink().click();
		//driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		ContactsPage contacts=new ContactsPage(driver);
		contacts.getCreateContactButton().click();
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		CreateContactsPage createContact=new CreateContactsPage(driver);
		createContact.getLastnameTextField().sendKeys(name);
		//driver.findElement(By.name("lastname")).sendKeys(name);
		createContact.getSelectOrgnizationButton().click();
		//driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		Set<String> handles = driver.getWindowHandles();
		String handle=null;
		for(String handle1:handles) {
			if(!(handle1.contains(homeHandle))) {
				web.switchWindow(driver, handle1);
				handle=driver.getWindowHandle();
			}
		}
		web.switchWindow(driver, handle);
		ListOfOrganizationsPage list=new ListOfOrganizationsPage(driver);
		list.getOrgName().click();
		//driver.findElement(By.xpath("//a[text()='TYSS']")).click();
		web.switchWindow(driver, homeHandle);
		createContact.getSaveButton().click();
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		ContactInformationPage contactInfo=new ContactInformationPage(driver);
		String actName=contactInfo.getActualLastName().getText();
		//String actName=driver.findElement(By.xpath("//div[@id='tblContactInformation']/table/tbody/tr[2]/td[2]/span")).getText();
		//System.out.println(actName);
		web.takeScreenshot(driver, method);
		assertEquals(actName, name);
//		if(actName.contains(name)) {
//			System.out.println(name+" is displayed TS is Passed");
//		}
//		else
//			System.out.println(name+" is not displayed TS is Failed");
//		//browser.logoutAndClose();
//		
	}
}

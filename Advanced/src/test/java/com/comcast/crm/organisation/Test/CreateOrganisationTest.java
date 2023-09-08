package com.comcast.crm.organisation.Test;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ReadExcelData;
import com.comcast.crm.generic.webdriverutility.JavaUtilty;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.genericutility.BaseClass;
//import com.comcast.crm.genericutility.Browser;
import com.comcast.objectrepository.CreateOrganizationPage;
import com.comcast.objectrepository.HomePage;
import com.comcast.objectrepository.OrganizationInformationPage;
import com.comcast.objectrepository.OrganizationsPage;

public class CreateOrganisationTest extends BaseClass {
	@Test
	public void createOrg(Method method) throws Throwable {
		
	//Browser browser=new Browser();
	//browser.navigateToWebpage();
	JavaUtilty java=new JavaUtilty();
	int num = java.generateRandomNum();
	
	ReadExcelData excel=new ReadExcelData();
	String orgName=excel.readExcel("Sheet1", 3, 0)+num;
	
	HomePage homePage=new HomePage(driver);
	homePage.getOrganizationsLink().click();
	//driver.findElement(By.xpath("(//a[contains(text(),'Organizations')])[1]")).click();
	OrganizationsPage org=new OrganizationsPage(driver);
	org.getCreateOrganizationButton().click();
	//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	CreateOrganizationPage createOrg=new CreateOrganizationPage(driver);
	createOrg.getOrgNameTextField().sendKeys(orgName);
	//driver.findElement(By.name("accountname")).sendKeys(orgName);
	createOrg.getSaveOrganizationButton().click();
	//driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	OrganizationInformationPage orgInfo=new OrganizationInformationPage(driver);
	String confMsg=orgInfo.getActualOrgName().getText();
	//String confMsg=driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]")).getText();
	WebDriverUtility web=new WebDriverUtility();
	web.takeScreenshot(driver, method);
	assertEquals(confMsg, orgName);
	//	if(confMsg.contains(orgName)) {
//		System.out.println(orgName+" is visible TC is pass");
//	}else
//	{
//		System.out.println(orgName+"is not visible TC is fail");
//	}
	//browser.logoutAndClose();
	
	}
	
	@Test
	public void abc() {
		System.out.println("abc");
	}
}

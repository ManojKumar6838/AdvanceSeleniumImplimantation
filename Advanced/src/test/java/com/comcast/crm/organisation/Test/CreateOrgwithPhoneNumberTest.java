package com.comcast.crm.organisation.Test;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

public class CreateOrgwithPhoneNumberTest extends BaseClass{
	@Test
	public void createOrgWithPhone(Method method) throws Throwable {
	//Browser browser=new Browser();
	//browser.navigateToWebpage();
	JavaUtilty java=new JavaUtilty();
	int num = java.generateRandomNum();
	
	ReadExcelData excel=new ReadExcelData();
	String orgName=excel.readExcel("Sheet1", 3, 0)+num;
	String phoneNum=excel.readExcel("Test", 1, 1);
	
	HomePage homePage=new HomePage(driver);
	homePage.getOrganizationsLink().click();
	//driver.findElement(By.xpath("(//a[contains(text(),'Organizations')])[1]")).click();
	OrganizationsPage org=new OrganizationsPage(driver);
	org.getCreateOrganizationButton().click();
	//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	CreateOrganizationPage createOrg=new CreateOrganizationPage(driver);
	createOrg.getOrgNameTextField().sendKeys(orgName);
	//driver.findElement(By.name("accountname")).sendKeys(orgName);
	createOrg.getPhoneNumTextField().sendKeys(phoneNum);
	//driver.findElement(By.id("phone")).sendKeys(phoneNum);
	createOrg.getSaveOrganizationButton().click();
	//driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	OrganizationInformationPage orgInfo=new OrganizationInformationPage(driver);
	String actOrgName=orgInfo.getActualOrgName().getText();
	//String actOrgName=driver.findElement(By.xpath("//div[@id='tblOrganizationInformation']/table/tbody/tr[1]/td[2]/span")).getText();
	System.out.println(actOrgName);
	String actPhoneNum=orgInfo.getActualPhoneNum().getText();
	//String actPhoneNum=driver.findElement(By.xpath("//div[@id='tblOrganizationInformation']/table/tbody/tr[2]/td[4]/span")).getText();
	System.out.println(actPhoneNum);
	WebDriverUtility web=new WebDriverUtility();
	web.takeScreenshot(driver, method);
	assertEquals(actOrgName, orgName);
//	if(actOrgName.contains(orgName)&& actPhoneNum.contains(phoneNum) ) {
//		System.out.println(orgName+" is visible TC is pass");
//	}else
//	{
//		System.out.println(orgName+"is not visible TC is fail");
//	}
	//browser.logoutAndClose();
}
}

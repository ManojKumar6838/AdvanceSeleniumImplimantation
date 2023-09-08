package com.TestScripts;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class CreateOrgUsingExcel {

	static WebDriver driver;
	@Test
	public void createOrg(XmlTest test) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\manug\\OneDrive\\Desktop\\VTiger\\CommenData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String url=pObj.getProperty("url");
		String browser=pObj.getProperty("browser");
		String username=pObj.getProperty("username");
		String password=pObj.getProperty("password");
		System.out.println(url);
		System.out.println(browser);
		System.out.println(username);
		System.out.println(password);
		
		Random ran=new Random();
		int num=ran.nextInt(100);
		
		FileInputStream fis1 = new FileInputStream("C:\\Users\\manug\\OneDrive\\Desktop\\VTiger\\TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		String orgName=wb.getSheet("Sheet1").getRow(1).getCell(0).toString()+num;
		
		
		
		
		
		if(browser.equals("chrome")) {
			driver=new ChromeDriver(); 	
		}
		else if(browser.equals("edge")) {
			driver=new EdgeDriver(); 	
		}
		else if(browser.equals("firefox")) {
			driver=new FirefoxDriver(); 	
		}
		else {
			driver=new ChromeDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.get(url); 
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Organizations')])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		Thread.sleep(2000);
		WebElement confMsg=driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]"));
		System.out.println(orgName);
		if(confMsg.isDisplayed()) {
			System.out.println(confMsg.getText());
		}
		else
			System.out.println("Org is not created");
		
		driver.quit();
	}
	
	
}

package com.TestScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchPropertiesData {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream("C:\\Users\\manug\\OneDrive\\Desktop\\VTiger\\CommenData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		/*
		 * System.out.println(pObj.getProperty("url"));
		 * System.out.println(pObj.getProperty("browser"));
		 * System.out.println(pObj.getProperty("username"));
		 * System.out.println(pObj.getProperty("password"));
		 */
		String url=pObj.getProperty("url");
		String browser=pObj.getProperty("browser");
		String username=pObj.getProperty("username");
		String password=pObj.getProperty("password");
		
		WebDriver driver=new ChromeDriver(); driver.manage().window().maximize();
		driver.get(url);
		//Thread.sleep(2000);
		//System.out.println(driver.getTitle()); 
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		System.out.println(driver.getTitle()); 
		driver.quit();
		
	}

}

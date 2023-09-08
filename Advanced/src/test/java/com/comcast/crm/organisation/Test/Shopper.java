package com.comcast.crm.organisation.Test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shopper {
	static final String shoppersStactLoginUrl="https://www.shoppersstack.com/user-signin";
	public static void main(String[] args) {
		
		String loginButtonXpath="//span[normalize-space(.)='Login']";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.get(shoppersStactLoginUrl);
		
		driver.findElement(By.xpath(loginButtonXpath)).click();
		//Alert alert=driver.switchTo().alert();
		
		//System.out.println(alert.getText());
		//driver.quit();
	}
}

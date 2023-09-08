package com.comcast.crm.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {

	public void switchWindow(WebDriver driver, String windowHandle) {
		driver.switchTo().window(windowHandle);
	}
	public void dropDownHandling(WebElement dropdown, String text) {
		Select dd=new Select(dropdown);
		dd.selectByValue(text);	
	}
	
	public void takeScreenshot(WebDriver driver, Method method) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshots/"+method.getName()+".png");
		FileHandler.copy(src, dest);
	}
	
	
	
	
}

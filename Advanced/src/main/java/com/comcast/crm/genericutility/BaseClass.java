package com.comcast.crm.genericutility;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.fileutility.ReadDataPropertiesFile;
import com.comcast.objectrepository.HomePage;
import com.comcast.objectrepository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	ReadDataPropertiesFile rdpf=new ReadDataPropertiesFile();
	//@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void navigateToWebpage()throws Throwable {

		String browser=rdpf.readDataProperties("browser");
		String url=rdpf.readDataProperties("url");


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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
	}

	@BeforeMethod(alwaysRun = true)
	public void login() throws Throwable {
		String username=rdpf.readDataProperties("username");
		String password=rdpf.readDataProperties("password");
		LoginPage login=new LoginPage(driver);
		login.getUserNameTextField().sendKeys(username);
		//driver.findElement(By.name("user_name")).sendKeys(username);
		login.getPasswordTextField().sendKeys(password);
		//driver.findElement(By.name("user_password")).sendKeys(password);
		login.getSubmitButton().click();
		//driver.findElement(By.id("submitButton")).click();
	}

	@AfterMethod(alwaysRun = true)
	public void logout() throws Throwable {
		Actions act=new Actions(driver);
		HomePage homePage=new HomePage(driver);
		act.moveToElement(homePage.getLogoutIcon()).perform();
		//act.moveToElement(driver.findElement(By.xpath("//td[@style='padding-right:10px;']/table/tbody/tr/td[2]"))).perform();
		//Thread.sleep(2000);
		homePage.getSignoutButton().click();
		//driver.findElement(By.partialLinkText("Sign Out")).click();

	}
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

}

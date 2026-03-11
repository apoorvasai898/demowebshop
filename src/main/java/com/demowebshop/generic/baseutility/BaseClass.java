package com.demowebshop.generic.baseutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.JSONUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.demowebshop.generic.utilityclassobject.UtilityClassobject;
import com.demowebshop.objectrepositoryutility.LandingPage;
import com.demowebshop.objectrepositoryutility.SignInPage;

public class BaseClass {
	public WebDriver driver = null;
	WebDriverUtility wdutil = new WebDriverUtility();
	ExcelUtility exUtil = new ExcelUtility();
	FileUtility fUtil = new FileUtility();
	JSONUtility jsUtil = new JSONUtility();
	JavaUtility jUtility = new JavaUtility();

	@BeforeClass
	public void launchBrowser() throws IOException {
		String BROWSER = fUtil.getDataFromPropertyFile("browser");
		String URL = fUtil.getDataFromPropertyFile("url");
		String timeOut = fUtil.getDataFromPropertyFile("timeout");
		int timeOutInt = Integer.parseInt(timeOut);
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOutInt));
		driver.get(URL);
		UtilityClassobject.setDriver(driver);

	}

	@BeforeMethod
	public void login() throws IOException {
		
		FileUtility fUtility = new FileUtility();
		LandingPage lp = new LandingPage(driver);
		lp.getLoginBtn().click();

		SignInPage signInPage = new SignInPage(driver);
		String email = fUtility.getDataFromPropertyFile("email");
		String password = fUtility.getDataFromPropertyFile("password");
		signInPage.signIn(driver, email, password);
	}
	
	@AfterMethod
	public void logout()
	{
		LandingPage lp = new LandingPage(driver);
		lp.getLogOutBtn().click();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}

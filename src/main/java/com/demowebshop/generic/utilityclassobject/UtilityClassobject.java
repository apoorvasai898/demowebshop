package com.demowebshop.generic.utilityclassobject;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassobject {
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	public static void setDriver(WebDriver actDriver) {
		driver.set(actDriver);
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setTest(ExtentTest actTest)
	{
		test.set(actTest);
	}
	public static ExtentTest getTest() {
		return test.get();
	}
}

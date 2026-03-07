package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LandingPage {
	@FindBy(xpath = "//ul[@class=\"top-menu\"]/descendant::a[contains(text(),'Computers')]")
	private WebElement computersEl;
	
	@FindBy(xpath = "//ul[@class='sublist firstLevel active']/descendant::a[contains(text(),'Desktops')]")
	private WebElement DesktopsLink;
	
	@FindBy(xpath = "//a[text()='Log in']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//a[@href='/logout']")
	private WebElement logOutBtn;
	
	public LandingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getComputersDrpDownEl() {
		return computersEl;
	}

	public WebElement getDesktopsLink() {
		return DesktopsLink;
	}
		
	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}

	public void clickOnDesktops(WebDriver driver)
	{
		WebDriverUtility wdUtility = new WebDriverUtility();
		wdUtility.mouseMoveOnElement(driver, computersEl);
		wdUtility.waitForElementPresent(driver, DesktopsLink);
		wdUtility.clickOn(driver, DesktopsLink);
	}

}

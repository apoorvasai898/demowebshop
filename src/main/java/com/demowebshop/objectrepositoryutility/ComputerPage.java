package com.demowebshop.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class ComputerPage {
	@FindBy(xpath = "//label[contains(text(),'400 GB')]/preceding-sibling::input")
	private WebElement hddSlRadioEl;
	
	@FindBy(xpath = "//input[@id='add-to-cart-button-16']")
	private WebElement addToCartBtn;
	
	public ComputerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getHddSlRadioEl() {
		return hddSlRadioEl;
	}

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}
	
	public void selectHddAndAddToCart(WebDriver driver,String hddValue)
	{
		WebDriverUtility wdUtility = new WebDriverUtility();
		wdUtility.clickOn(driver, hddSlRadioEl);
		
		wdUtility.waitForElementPresent(driver, addToCartBtn);
		addToCartBtn.click();
	}

}

package com.demowebshop.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonElements {

	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement cartBtn;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement ordCreatedPageContBtn;

	@FindBy(xpath = "//div[@class='page-body checkout-data']/descendant::li[contains(text(),'Order num')]")
	private WebElement ordIdTxtContainer;

	public WebElement getCartBtn() {
		return cartBtn;
	}

	public WebElement getOrdCreatedPageContBtn() {
		return ordCreatedPageContBtn;
	}

	public WebElement getOrdIdTxtContainer() {
		return ordIdTxtContainer;
	}

	public CommonElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}

package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopsPage {
	@FindBy(xpath = "//a[contains(text(),'Build your own computer')]/ancestor::div[@class='item-box']")
	private WebElement item1CardEl;
	
	public DesktopsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getItem1CardEl() {
		return item1CardEl;
	}
	
	

}

package com.demowebshop.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class ShoppingCartPage {
	@FindBy(id = "CountryId")
	private WebElement countrySl;
	
	@FindBy(id = "StateProvinceId")
	private WebElement stateSl;
	
	@FindBy(xpath = "//input[@value='Estimate shipping']")
	private WebElement estimateBtn;
	
	@FindBy(id = "termsofservice")
	private WebElement termsChk;
	
	@FindBy(id = "checkout")
	private WebElement choutBtn;
	
	public ShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCountrySl() {
		return countrySl;
	}

	public WebElement getStateSl() {
		return stateSl;
	}

	public WebElement getEstimateBtn() {
		return estimateBtn;
	}

	public WebElement getTermsChk() {
		return termsChk;
	}

	public WebElement getChoutBtn() {
		return choutBtn;
	}

	public void checkOut(WebDriver driver,String country) throws InterruptedException
	{
		WebDriverUtility wdUtility = new WebDriverUtility();
		wdUtility.select(countrySl, country);
		
		estimateBtn.click();
		Thread.sleep(1000);
		termsChk.click();
		
		choutBtn.click();
		
	}

}

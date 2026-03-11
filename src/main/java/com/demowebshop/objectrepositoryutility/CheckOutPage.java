package com.demowebshop.objectrepositoryutility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.JSONUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CheckOutPage {
	WebDriverUtility wdutil = new WebDriverUtility();
	ExcelUtility exUtil = new ExcelUtility();
	FileUtility fUtil = new FileUtility();
	JSONUtility jsUtil = new JSONUtility();
	JavaUtility jUtility = new JavaUtility();

	@FindBy(id = "BillingNewAddress_CountryId")
	private WebElement countrySl;

	@FindBy(id = "BillingNewAddress_City")
	private WebElement cityEdt;

	@FindBy(id = "BillingNewAddress_Address1")
	private WebElement address1Ed;

	@FindBy(id = "BillingNewAddress_Address2")
	private WebElement address2Ed;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	private WebElement zipCdEdt;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	private WebElement phoneEdt;

	@FindBy(id = "BillingNewAddress_FaxNumber")
	private WebElement faxNumEdt;

	@FindBy(xpath = "//input[@onclick='Billing.save()']")
	private WebElement bilAdrConBtn;

	@FindBy(xpath = "//input[@onclick='Shipping.save()']")
	private WebElement shippAdrConBtn;

	@FindBy(xpath = "//input[@onclick='ShippingMethod.save()']")
	private WebElement shipMtdConBtn;

	@FindBy(xpath = "//input[@class='button-1 payment-method-next-step-button']")
	private WebElement paymentMtdConBtn;

	@FindBy(xpath = "//input[@class='button-1 payment-info-next-step-button']")
	private WebElement paymentInfoConBtnn;

	@FindBy(xpath = "//input[@class='button-1 confirm-order-next-step-button']")
	private WebElement ordConfBtn;

//	@FindBy(xpath = )
	public WebElement getPhoneEdt() {
		return phoneEdt;
	}

	public WebElement getShippAdrConBtn() {
		return shippAdrConBtn;
	}

	public WebElement getShipMtdConBtn() {
		return shipMtdConBtn;
	}

	public WebElement getPaymentMtdConBtn() {
		return paymentMtdConBtn;
	}

	public WebElement getPaymentInfoConBtnn() {
		return paymentInfoConBtnn;
	}

	public WebElement getOrdConfBtn() {
		return ordConfBtn;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCountrySl() {
		return countrySl;
	}

	public WebElement getCityEdt() {
		return cityEdt;
	}

	public WebElement getAddress1Ed() {
		return address1Ed;
	}

	public WebElement getAddress2Ed() {
		return address2Ed;
	}

	public WebElement getZipCdEdt() {
		return zipCdEdt;
	}

	public WebElement getFaxNumEdt() {
		return faxNumEdt;
	}

	public WebElement getBilAdrConBtn() {
		return bilAdrConBtn;
	}

	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriverUtility wdUtil = new WebDriverUtility();

	public void enterShipDetails() throws EncryptedDocumentException, IOException, InterruptedException {
		String country = exUtil.getDataFromExcel("billAddress", 1, 0);
		String city = exUtil.getDataFromExcel("billAddress", 1, 1);
		String adr1 = exUtil.getDataFromExcel("billAddress", 1, 2);
		String adr2 = exUtil.getDataFromExcel("billAddress", 1, 3);
		String zipCode = exUtil.getDataFromExcel("billAddress", 1, 4);
		String phoneNm = exUtil.getDataFromExcel("billAddress", 1, 5);
		String faxNum = exUtil.getDataFromExcel("billAddress", 1, 6);
		try {
			cityEdt.sendKeys(city);
			address1Ed.sendKeys(adr1);
			address2Ed.sendKeys(adr2);
			zipCdEdt.sendKeys(zipCode);
			phoneEdt.sendKeys(phoneNm);
			faxNumEdt.sendKeys(faxNum);

			wdUtil.select(countrySl, country);

//			wdutil.switchToAlertAndDismiss(driver);
			wdUtil.waitForElementPresent(driver, bilAdrConBtn);
			Actions a = new Actions(driver);
			a.click(bilAdrConBtn).build().perform();
		} catch (Exception e) {

		}

		wdUtil.waitForElementPresent(driver, bilAdrConBtn);
		Actions a = new Actions(driver);
		a.click(bilAdrConBtn).build().perform();

		shippAdrConBtn.click();

		shipMtdConBtn.click();

		paymentMtdConBtn.click();

		paymentInfoConBtnn.click();

		Actions aa = new Actions(driver);
		wdUtil.waitForElementPresent(driver, ordConfBtn);
		aa.click(ordConfBtn).perform();

	}

	public boolean wbtExcelAndVerify() throws EncryptedDocumentException, IOException {
		Boolean res = false;
		CommonElements ces = new CommonElements(driver);

		WebElement orderIDTextEl = ces.getOrdIdTxtContainer();
		wdutil.waitForElementPresent(driver, orderIDTextEl);
		
		if(orderIDTextEl.isDisplayed())
		{
			res = true;
		}
		else {
			res = false;
		}
		String orderIDText = ces.getOrdIdTxtContainer().getText();
		String orderID = orderIDText.substring(14);
//		System.out.println(orderID);

		ExcelUtility excUt = new ExcelUtility();
		excUt.setDataBackToExcel("orders", 1, 0, orderID);

		ces.getOrdCreatedPageContBtn().click();
		
		return res;
	}

}

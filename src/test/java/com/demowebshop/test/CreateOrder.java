package com.demowebshop.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.generic.baseutility.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.CheckOutPage;
import com.comcast.crm.objectrepositoryutility.CommonElements;
import com.comcast.crm.objectrepositoryutility.ComputerPage;
import com.comcast.crm.objectrepositoryutility.DesktopsPage;
import com.comcast.crm.objectrepositoryutility.LandingPage;
import com.comcast.crm.objectrepositoryutility.ShoppingCartPage;

@Listeners(com.demowebshop.listenerImplementation.LIstenerImplementationClass.class)
public class CreateOrder extends BaseClass {
	@Test
	public void getOrderId() throws IOException, InterruptedException {
		
		ExcelUtility excUtility = new ExcelUtility();
		FileUtility fUtility = new FileUtility();

		LandingPage lp = new LandingPage(driver);
		lp.clickOnDesktops(driver);

	
		DesktopsPage dsktppage = new DesktopsPage(driver);
		dsktppage.getItem1CardEl().click();

		String hddvalue = fUtility.getDataFromPropertyFile("hdd");
		ComputerPage compage = new ComputerPage(driver);
		compage.selectHddAndAddToCart(driver, hddvalue);

		CommonElements comEls = new CommonElements(driver);
		comEls.getCartBtn().click();

		String country = excUtility.getDataFromExcel("data", 1, 0);

		ShoppingCartPage shopcrp = new ShoppingCartPage(driver);
		shopcrp.checkOut(driver, country);

		CheckOutPage chkPage = new CheckOutPage(driver);
		chkPage.enterShipDetails();

		boolean res = chkPage.wbtExcelAndVerify();

		Assert.assertEquals(res, true);

	}
}

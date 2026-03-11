package com.demowebshop.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.demowebshop.generic.baseutility.BaseClass;
import com.demowebshop.objectrepositoryutility.CheckOutPage;
import com.demowebshop.objectrepositoryutility.CommonElements;
import com.demowebshop.objectrepositoryutility.ComputerPage;
import com.demowebshop.objectrepositoryutility.DesktopsPage;
import com.demowebshop.objectrepositoryutility.LandingPage;
import com.demowebshop.objectrepositoryutility.ShoppingCartPage;

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

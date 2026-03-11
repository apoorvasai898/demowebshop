package com.demowebshop.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	@FindBy(id = "Email")
	private WebElement emailEd;
	
	@FindBy(id = "Password")
	private WebElement pswdEd;
	
	@FindBy(id = "RememberMe")
	private WebElement rememberMeChk;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginBtn;
	
	public SignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmailEd() {
		return emailEd;
	}

	public WebElement getPswdEd() {
		return pswdEd;
	}

	public WebElement getRememberMeChk() {
		return rememberMeChk;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void signIn(WebDriver driver,String username,String password)
	{
		emailEd.sendKeys(username);
		pswdEd.sendKeys(password);
		rememberMeChk.click();
		loginBtn.click();
	}
}

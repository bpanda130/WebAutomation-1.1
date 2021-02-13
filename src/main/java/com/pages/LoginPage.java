package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Component.*;

public class LoginPage {
	
	private WebDriver driver;
	
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signOnBtn = By.id("SubmitLogin");
	private By forgotPassword = By.partialLinkText("Forgot your password?11");
	ElementUtil elementUtil;
	TextBoxUtil textboxUtil;
	ButtonUtil buttonUtil;

	public LoginPage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		textboxUtil = new TextBoxUtil(driver);
		buttonUtil = new ButtonUtil(driver);
	}
	
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean isForgotPasswordLinkExist(){
		return elementUtil.checkWebElementPresent(forgotPassword);
	}
	
	public void enterUserName(String username){
		textboxUtil.doSendKeys(emailId, username);
	}
	
	public void enterPassword(String pwd){
		textboxUtil.doSendKeys(password, pwd);
	}
	
	public void clickOnLogin(){
		buttonUtil.doClick(signOnBtn);
	}
	
	public AccountsPage doLogin(String username, String pwd){
		System.out.println("Login with UserName : "+ username + " and Password : "+ pwd);
		textboxUtil.doSendKeys(emailId, username);
		textboxUtil.doSendKeys(password, pwd);
		buttonUtil.doClick(signOnBtn);
		
		return new AccountsPage(driver);
		
	}
	
}

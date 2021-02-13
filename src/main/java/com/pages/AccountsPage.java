package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Component.*;

public class AccountsPage {
	private WebDriver driver;
	ElementUtil elementUtil;
	TextBoxUtil textboxUtil;
	ButtonUtil buttonUtil;
	
	private By accountItems = By.xpath("//div[@id='center_column']//ul[@class='myaccount-link-list']//span");
	
	public AccountsPage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		textboxUtil = new TextBoxUtil(driver);
		buttonUtil = new ButtonUtil(driver);
	}
	
	public String getAccountsPageTitle(){
		return driver.getTitle();
	}
	
	public int getAccountSectionCount(){
		return elementUtil.getElementSize(accountItems);
	}
	
	public List<String> getAccountsSectionList(){
		List<String> SectionList = new ArrayList<>();
		List<WebElement> accountSectionList = driver.findElements(accountItems);
		for(WebElement wb : accountSectionList){
			String sectionName = wb.getText();
			SectionList.add(sectionName);
		}
		return SectionList;
	}
}
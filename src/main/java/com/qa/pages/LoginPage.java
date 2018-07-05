package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class LoginPage extends BaseClass{

	@FindBy(id = "lgn_name")
	WebElement username;
	
	@FindBy(id = "lgn_mob")
	WebElement mobile;
	
	@FindBy(id = "lgn_smtn")
	WebElement sendOtpBtn;
	
	@FindBy(className = "pop-logo")
	WebElement logo;
	
	@FindBy(id = "h_login")
	WebElement loginLink;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	} 
	
	public Boolean validateLogo(){
		loginLink.click();
		return logo.isDisplayed();
	}
	
	public HomePage login(String user, String phn){
			
		loginLink.click();
		
		username.sendKeys(user);
		mobile.sendKeys(phn);
		sendOtpBtn.click();
		return new HomePage();
	}
	
}

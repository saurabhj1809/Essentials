package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(className = "logo")
	WebElement logo;
	
	@FindBy(className = "search-button")
	WebElement searchBtn;
	
	@FindBy(id = "city")
	WebElement cityDropDown;
	
	@FindBy(className = "jdscl")
	WebElement socialTab;
	
	@FindBy(id = "ContextualHotkey_2")
	WebElement jdPayLink;
	
	@FindBy(id = "h_login")
	WebElement login;
	
	@FindBy(id = "h_sin_up")
	WebElement signup;
	
	@FindBy(id = "f_abut_us")
	WebElement aboutusLink;
	
	@FindBy(id = "footer_sprite fb-icon")
	WebElement fbShareIcon;
	
	@FindBy(css = "#cuto li")
	List<WebElement> location;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	} 
	
	public Boolean validateLogo(){
		return logo.isDisplayed();
	}
	
	public Boolean validateSearchIcon(){
		return searchBtn.isDisplayed();
	}
	
	public void checkCity(int locationIndex){
		cityDropDown.click();
		location.get(locationIndex).click();
	}
	
	public int getLocationsCount() {
		return location.size();
	}
	
	public void navigateToSocial(){
		socialTab.click();
	}
	
	public void navigateToJdPay(){
		jdPayLink.click();
	}
	
	public void checkLogin(){
		login.click();
	}
	
	public void checksignup(){
		signup.click();
	}
	
	public void checkAboutus(){
		aboutusLink.click();
	}
	
	public void checkSocialLink(){
		fbShareIcon.click();
	}
	
}

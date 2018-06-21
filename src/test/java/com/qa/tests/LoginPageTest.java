package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends BaseClass{
	
	LoginPage loginPage;
	HomePage homepage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		connect();
	    loginPage = new LoginPage();
	}
	
	@Test(priority =1)
	public void loginTitleTest(){
		String title = loginPage.getPageTitle();
		Assert.assertEquals(title, "Justdial - Local Search, Order Food, Travel, Movies, Online Shopping");
	}
	
	@Test(priority = 2)
	public void verifyLogoTest(){
		Boolean logo = loginPage.validateLogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority = 3)
	public void loginTest(){
				
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("phone"));
		System.out.println(homepage);
	}
	 
	@AfterMethod
	public void quit(){
		driver.quit();
	}
}

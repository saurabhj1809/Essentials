package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePage;

public class HomepPageTest extends BaseClass {

	HomePage homepage;
	
	public HomepPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		connect();
		homepage = new HomePage();
	}
	
	@Test
	public void loginTitleTest(){
		String title = homepage.getPageTitle();
		Assert.assertEquals(title, "Justdial - Local Search, Order Food, Travel, Movies, Online Shopping");
	}
	
	@Test(dependsOnMethods={"loginTitleTest"}, alwaysRun = true)
	public void verifyLogoTest(){
		Boolean logo = homepage.validateLogo();
		Assert.assertTrue(logo);
	} 
	
	@Test(dependsOnMethods={"verifyLogoTest"}, alwaysRun = true)
	public void validateSearchIconTest(){
		Boolean searchIcon = homepage.validateSearchIcon();
		Assert.assertTrue(searchIcon);
	}
	
	@Test(dependsOnMethods={"validateSearchIconTest"}, alwaysRun = true)
	public void validatecheckCityTest(){
		 homepage.checkCity(1);
	}
	
	@Test(dependsOnMethods={"validatecheckCityTest"}, alwaysRun = true)
	public void navigateToSocialTest(){
		homepage.validateSearchIcon();
	}
	
	@AfterMethod
	public void quit(){
		driver.quit();
	}
}

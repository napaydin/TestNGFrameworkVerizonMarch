package com.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.verizon.base.BasePage;
import com.verizon.pages.VerizonMainPage;
import com.verizon.util.Constants;

public class VerizonMainPageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	VerizonMainPage verizonMainPage;
	
	@BeforeMethod
	//setUp
	public void setUp(){
		basePage=new BasePage();
		prop=basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);
		verizonMainPage=new VerizonMainPage(driver);	
	}
	@Test(priority=1)
	public void getTitle(){
		String title=verizonMainPage.getVerizonTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.VERIZON_HOME_PAGE_TITLE);
	}
	@Test(priority=2)
	public  void moveToSmartPhone(){
		verizonMainPage.clickSmart();
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}

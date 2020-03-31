package com.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.verizon.base.BasePage;
import com.verizon.pages.PhoneFeaturesPage;
import com.verizon.pages.SmartPhonePage;
import com.verizon.pages.VerizonMainPage;
import com.verizon.pages.verifyCart;
import com.verizon.util.Constants;

public class verifyCartTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	verifyCart verifyCart;
	PhoneFeaturesPage phoneFeaturesPage;
	SmartPhonePage smartPhonePage;
	VerizonMainPage verizonMainPage;
	
	@BeforeMethod
	public void setUp(){
	   basePage=new BasePage();
	   prop=basePage.initialize_properties();
	   driver=basePage.initialize_driver(prop);   
	   verizonMainPage=new VerizonMainPage(driver);
	   smartPhonePage= verizonMainPage.clickSmart();
	   phoneFeaturesPage=smartPhonePage.clickIphone11();
	   verifyCart=phoneFeaturesPage.selectFeaturesClick();
	}
	 @Test(priority=1)
	 public void verifyName(){
			String name = verifyCart.getPhoneName();
			System.out.println("Phone in the cart is: " + name);
			Assert.assertEquals(name, Constants.VERIZON_PHONE_NAME);
		}
	@AfterMethod
	public void tearDown(){
			driver.quit();
		}
}

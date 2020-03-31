package com.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.verizon.base.BasePage;
import com.verizon.pages.SmartPhonePage;
import com.verizon.pages.VerizonMainPage;
import com.verizon.util.Constants;

public class SmartPhonePageTest  {
   WebDriver driver;
   Properties prop;
   BasePage basePage;
   SmartPhonePage smartPhonePage;
   VerizonMainPage verizonMainPage;
  
   @BeforeMethod
   public void setUp(){
	   basePage=new BasePage();
	   prop=basePage.initialize_properties();
	   driver=basePage.initialize_driver(prop);
	   verizonMainPage=new VerizonMainPage(driver);
	   smartPhonePage= verizonMainPage.clickSmart();
	   
   }
   @Test(priority=1)
   public void getTitle(){
	   String title=smartPhonePage.getIphone11Title();
	   System.err.println(title);
	   Assert.assertEquals(title, Constants.VERIZON_SMARTPHONES_TITLE);
   }
   @Test(priority=2)
   public void clickAppleIphone11(){
	   smartPhonePage.clickIphone11();
   }
   @AfterMethod
   public void tearDown(){
	   driver.quit();
   }
}

package com.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.verizon.base.BasePage;
import com.verizon.util.Constants;
import com.verizon.util.ElementUtil;

public class SmartPhonePage extends BasePage{
	
    WebDriver driver;
    ElementUtil elementUtil;
    
    By iphone11=By.xpath("//a[@aria-label='Apple iPhone 11']");
    
    //constructor
    public SmartPhonePage(WebDriver driver){
    	this.driver=driver;
    	elementUtil=new ElementUtil(driver);
    }
    //getTitle
    public String getIphone11Title(){
    return 	elementUtil.waitForGetPageTitle(Constants.VERIZON_SMARTPHONES_TITLE);
    
    }
    //click
    public PhoneFeaturesPage clickIphone11(){

    	elementUtil.doClick(iphone11);
    	
  	return new PhoneFeaturesPage(driver);
  	
    }
}

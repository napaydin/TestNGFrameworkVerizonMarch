package com.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.verizon.base.BasePage;
import com.verizon.util.Constants;
import com.verizon.util.ElementUtil;

public class verifyCart extends BasePage{
WebDriver driver;
ElementUtil elementUtil;

//locator
By selectedPhone=By.xpath("//span[text()='iPhone 11']");
//span[text()='iPhone 11']



//constructor-sinif ile ismi ayni olmali
public verifyCart(WebDriver driver){
	this.driver=driver;
	elementUtil=new ElementUtil(driver);
}
public String getPhoneName(){
	elementUtil.waitForElementPresent(selectedPhone);
	return elementUtil.doGetText(selectedPhone);
}
}

package com.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.verizon.base.BasePage;
import com.verizon.util.Constants;
import com.verizon.util.ElementUtil;

import net.bytebuddy.asm.Advice.Return;

public class VerizonMainPage extends BasePage{
	
        WebDriver driver;
        ElementUtil elementUtil;
        
        //By
        By phones=By.xpath("//button[contains(text(),'Phones list')]");
        By smartPhone=By.id("thirdLevel00");
        
        //constructor
        public VerizonMainPage(WebDriver driver){
        	this.driver=driver;
        	elementUtil=new ElementUtil(driver);
        }
        
        //get title
        public String getVerizonTitle(){
        	return elementUtil.waitForGetPageTitle(Constants.VERIZON_HOME_PAGE_TITLE);
        }
        public  SmartPhonePage clickSmart(){   
       	elementUtil.moveToElement(phones);
       	elementUtil.doClick(smartPhone);
       	return new SmartPhonePage(driver);
        }
}

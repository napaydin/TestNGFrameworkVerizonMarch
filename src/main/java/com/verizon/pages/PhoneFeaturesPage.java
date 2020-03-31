package com.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.verizon.base.BasePage;
import com.verizon.util.Constants;
import com.verizon.util.ElementUtil;

public class PhoneFeaturesPage extends BasePage{
//butun secenekleri bi metoda koyalim
	//color-size-price-continue
	//(url bu esnada degisecek)kodumuz girelim
	//     //span[text()=‘iPhone 11’] locator
	//
	//green-//div[contains(@class,'positionRelative color-swatch-selected borderRadius50 cursorPointer')]
   //  size-//p[contains(text(),'256GB')]
   //price-//div[contains(text(),'Retail price')]
   //xpath-id-ATC-Btn
   //Apple Iphone11
   // next-//button[@type='button']
	
    WebDriver driver;
    ElementUtil elementUtil;
    
    //locator 
    By color=By.xpath("//div[contains(@class,' borderRadius50 cursorPointer')]");//positionRelative color-swatch-selected
   //  /div[contains(@style,‘rgb(204, 197, 215)’)]
    By size=By.xpath("//p[contains(text(),'256GB')]");//bak
    By price=By.xpath("//div[contains(text(),'Retail price')]");
    By continueBtn=By.id("ATC-Btn");
    By zipcode=By.id("zipcode");
    By confirmZipcode=By.xpath("//button[contains(@class,'defaultPrimaryCTA')]");//bak id
    By newCustomer=By.xpath("//button[contains(text(),'New Customer')]");
    
    //constructor
    public PhoneFeaturesPage(WebDriver driver){
    	this.driver=driver;
    	elementUtil=new ElementUtil(driver);
    }
    //getTitle
    public String getTitleShopping(){
    	return elementUtil.waitForGetPageTitle(Constants.VERIZON_SHOPPING_TITLE);
    }
public verifyCart selectFeaturesClick(){
		
		//javaScriptUtil.clickElementByJS(elementUtil.getElement(selectedDevice), driver);
		elementUtil.doClick(color);
		elementUtil.doClick(size);
		elementUtil.doClick(price);
		elementUtil.doClick(continueBtn);
		elementUtil.waitForElementPresent(zipcode);
		elementUtil.doSendKeys(zipcode, "07013");
		elementUtil.doClick(confirmZipcode);
		elementUtil.doClick(newCustomer);
		
		return new verifyCart(driver);
	}
    
    
    
}

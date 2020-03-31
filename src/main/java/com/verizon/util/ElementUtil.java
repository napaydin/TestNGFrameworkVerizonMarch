package com.verizon.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.verizon.base.BasePage;
import com.verizon.util.JavaScriptUtil;



public class ElementUtil extends BasePage{

    WebDriver driver;
	
    /**
     * Constructor
     * @param driver
     */
	public ElementUtil(WebDriver driver){
		this.driver = driver;
	}
	
	public void moveToElement(By locator){
	 	WebElement element=driver.findElement(locator);
    	    Actions actions=new Actions(driver);
   	    actions.moveToElement(element).build().perform();
	}
	/**
	 * Get element method
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator){
		waitForElementPresent(locator);
		
		WebElement element = null;
		try{
		element = driver.findElement(locator);
		if(flash.equalsIgnoreCase("yes")){
		   JavaScriptUtil.flash(element, driver);
		 }
		}catch (Exception e) {
			System.out.println("Some exception occured while creating webelement " +locator);
		}
		return element;
	}
	
	/**
	 * Wait for Element Present
	 * @param locator
	 */
	public void waitForElementPresent(By locator){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	/**
	 * ClickOn 
	 * @param locator
	 */
	public void doClick(By locator){
		try{
		getElement(locator).click();
		}
		catch(Exception e){
			System.out.println("Some exception occured while click on  webelement " +locator);
		}
	}
	
	/**
	 * SendKeys
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator, String value){
		try{
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
		}
		catch(Exception e){
			System.out.println("Some exception occured while sending to  webelement " + locator);
		}
	}
	
	/**
	 * Get text method
	 */
	public String doGetText(By locator){
		String text = null;
		try{
		text = getElement(locator).getText();
		}
		catch(Exception e){
			System.out.println("Some exception occured while sending to  webelement " +locator);
		}
		return text;
	}
	
	/**
	 * Page title
	 * @param title
	 * @return
	 */
	public String waitForGetPageTitle(String title){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	
	/**
	 * is Displayed
	 * @param locator
	 * @return
	 */
	public boolean isElementDisplayed(By locator){
		try{
		return getElement(locator).isDisplayed();
		}catch(Exception e){
			System.out.println("Some exception occured while checking webelement displayed "+ locator);
			return false;
		}
	}

}

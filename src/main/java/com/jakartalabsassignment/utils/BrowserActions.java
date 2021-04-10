package com.jakartalabsassignment.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class BrowserActions {
		private static WebDriverWait explicitWait;
		
		private static void setExplicitWait(WebDriver driver) {
		explicitWait = new WebDriverWait(driver,(60));	
		
		}
		
		private static void checkExplicitWait(WebDriver driver) {
			if (explicitWait == null) {
				BrowserActions.setExplicitWait(driver);
			}
		}
		
		public static void clickElementByXpath(WebDriver driver, String elementXpath) {
			checkExplicitWait(driver);
			WebElement elementByXpath = explicitWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(elementXpath))));
			elementByXpath.click();
		}
		
		public static void clickPresenceOfElementByXpath(WebDriver driver, String elementXpath) {
			checkExplicitWait(driver);
			WebElement elementByXpath = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
			elementByXpath.click();
		}
		
		public static void clickElementByID(WebDriver driver, String elementID) {
			checkExplicitWait(driver);
			WebElement elementByID = explicitWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(elementID))));
			elementByID.click();
		}
		
		public static void clickElementByCSS(WebDriver driver, String elementCSS) {
			checkExplicitWait(driver);
			WebElement elementByCSS = explicitWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(elementCSS))));
			elementByCSS.click();
		}
		
		public static void sendKeysToElementByXpath(WebDriver driver, String elementXpath, String keys) {
			checkExplicitWait(driver);
			WebElement elementByXpath = explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elementXpath))));
			elementByXpath.sendKeys(keys);
		}
		
		public static void sendKeysTopresenceOfElementbyXpath(WebDriver driver, String elementXpath, String keys) {
			checkExplicitWait(driver);
			WebElement elementByXpath = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
			elementByXpath.sendKeys(keys);
			
		}
		
		public static String getTextOfElementByCSS(WebDriver driver, String elementCSS) {
			checkExplicitWait(driver);
			WebElement elementInPage = explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(elementCSS))));
			return elementInPage.getText();
		}
		
		public static void assertElementByXpath (WebDriver driver, String elementXpath, String keys) {
			checkExplicitWait(driver);
			WebElement elementByXpath = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
			Assert.assertEquals(elementByXpath.getText(), keys);
			
		}
	
		public static void performMouseHoverByCSS(WebDriver driver, String elementCSS) {
			Actions mouseAction = new Actions(driver);
			mouseAction.moveToElement(driver.findElement(By.cssSelector(elementCSS))).perform();
			
		}
		
		public static void performMouseHoverByXpath(WebDriver driver, String elementXpath) {
			Actions mouseAction = new Actions(driver);
			mouseAction.moveToElement(driver.findElement(By.xpath(elementXpath))).perform();
			
		}
		
		public static void performMouseHoverClickByCSS(WebDriver driver, String elementCSS) {
			Actions mouseAction = new Actions(driver);
			mouseAction.moveToElement(driver.findElement(By.cssSelector(elementCSS))).click().build().perform();;
			
		}
		
		public static void performMouseHoverClickByXpath(WebDriver driver, String elementXpath) {
			Actions mouseAction = new Actions(driver);
			mouseAction.moveToElement(driver.findElement(By.xpath(elementXpath))).click().build().perform();;
			
		}
		
		public static String getTextOfElementByXpath(WebDriver driver, String elementXpath, String keys, String keys1) {
			checkExplicitWait(driver);
			WebElement elementInPage = explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elementXpath))));
			return elementInPage.getText().replaceAll(keys, keys1);
		
		}
		
		public static String getTextPresenceOfElementByXpath(WebDriver driver, String elementXpath, String keys, String keys1) {
			checkExplicitWait(driver);
			WebElement elementInPage = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));;
			return elementInPage.getText().replaceAll(keys, keys1);
		
		}
		
		public static void assertString (WebDriver driver, String keys1, String keys2) {
			Assert.assertEquals(keys1, keys2);
			
		}
		
		public static void waitInvisibility (WebDriver driver, String elementXpath)  
		 { 
		 
		  WebDriverWait wait = new WebDriverWait(driver, 15);
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementXpath)));

		  System.out.print("The Card builder is deleted");      
		 }
			
		
		
}

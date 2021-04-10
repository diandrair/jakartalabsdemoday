package com.jakartalabsassignment.diandra_irdianti;




import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jakartalabsassignment.pageObjects.BuildCardPage;
import com.jakartalabsassignment.pageObjects.DashboardPage;
import com.jakartalabsassignment.pageObjects.DeliveryPage;
import com.jakartalabsassignment.pageObjects.FeaturesPage;
import com.jakartalabsassignment.pageObjects.HomePage;
import com.jakartalabsassignment.pageObjects.LoginPage;
import com.jakartalabsassignment.pageObjects.TutorialPage;
import com.jakartalabsassignment.utils.BrowserActions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BuilderUITest {

	WebDriver driver;
	
	@BeforeTest
	public void setUpSystemUnderTest() {		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		driver.get("https://staging.engineer.ai/home");
	}
	
	@AfterTest(alwaysRun = true)
	public void cleanUp () {
		
		driver.quit();
	}

	@Test(priority=0)
	public void login() throws InterruptedException {
		
		BrowserActions.performMouseHoverByCSS(driver, HomePage.signInButtonCssSelector);
		BrowserActions.clickElementByXpath(driver, HomePage.loginButtonXpath);
		BrowserActions.sendKeysToElementByXpath(driver, LoginPage.usernameFieldXpath, "jogidemo321@gmail.com");
		BrowserActions.sendKeysToElementByXpath(driver, LoginPage.passwordFieldXpath, "builder123");
		BrowserActions.clickElementByCSS(driver, LoginPage.submitButtonCss);
		BrowserActions.assertElementByXpath(driver, HomePage.accountNameXpath, "Hello john");		
	}
	
	@Test(priority=1)
	public void createBuilder() throws InterruptedException{
		Thread.sleep(2000);
		BrowserActions.clickPresenceOfElementByXpath(driver, HomePage.mobileAppsXpath);
		BrowserActions.clickPresenceOfElementByXpath(driver, HomePage.snapChatXpath);
		BrowserActions.clickElementByXpath(driver, HomePage.getStartedButtonXpath);
	}
	
	@Test(priority=2)
	public void getStarted() {
		
		BrowserActions.clickElementByXpath(driver, TutorialPage.skipButtonXpath);
	}
	
	@Test(priority=3)
	public void deliveryAndDeleteCard() throws InterruptedException{
		
		String initialPrice = BrowserActions.getTextPresenceOfElementByXpath(driver, FeaturesPage.priceXpath, "[^0-9]", "");
		BrowserActions.clickElementByXpath(driver, FeaturesPage.planDeliveryButtonXpath);
		String finalprice = BrowserActions.getTextPresenceOfElementByXpath(driver, DeliveryPage.priceXpath, "[^0-9]", "");
		BrowserActions.assertString(driver, finalprice, initialPrice);
		BrowserActions.clickPresenceOfElementByXpath(driver, DeliveryPage.doneButtonXpath);
		String s = RandomStringUtils.randomAlphabetic(8);
		BrowserActions.sendKeysTopresenceOfElementbyXpath(driver, DeliveryPage.buildCardNameFieldXpath, s);
		BrowserActions.clickElementByXpath(driver, DeliveryPage.saveButtonXpath);
		String buildCardPrice = BrowserActions.getTextPresenceOfElementByXpath(driver, BuildCardPage.priceXpath, "[^0-9]", "");
		BrowserActions.assertString(driver, buildCardPrice, initialPrice);		
		
		BrowserActions.clickPresenceOfElementByXpath(driver, HomePage.accountNameXpath);
		BrowserActions.clickElementByXpath(driver, HomePage.myDashboardButtonXpath);
		BrowserActions.assertElementByXpath(driver, DashboardPage.nameOfCardXpath, s);
		BrowserActions.performMouseHoverClickByXpath(driver, DashboardPage.threeDotsButtonXpath);
		Thread.sleep(3000);
		BrowserActions.performMouseHoverClickByCSS(driver, DashboardPage.deleteButtonCSS);
		BrowserActions.clickPresenceOfElementByXpath(driver, DashboardPage.deleteConfirmationButtonXpath);
		//BrowserActions.waitInvisibility(driver, DashboardPage.nameOfCardXpath);
		
	}
}







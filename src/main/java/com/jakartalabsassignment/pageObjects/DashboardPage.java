package com.jakartalabsassignment.pageObjects;

public class DashboardPage {

	public static final String nameOfCardXpath = "//app-completed-cards//div[@class='cardHead']//h3";
	public static final String statusOfCardXpath = "//h4[normalize-space()='Last edited: less than a minute ago']";
	public static final String threeDotsButtonXpath = "//body//app[@class='eiApp']//div[@class='ng-star-inserted']//div[@class='ng-star-inserted']//div[1]//div[1]//div[2]//div[1]//em[1]";
	//public static final String deleteButtonXpath ="//body//app[@class='eiApp']//div[@class='ng-star-inserted']//div[@class='ng-star-inserted']//div[1]//div[1]//div[2]//div[1]//div[1]//ul[1]//li[5]";
	public static final String deleteButtonCSS = "body > app:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > main:nth-child(1) > app-dashboard:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > app-dashboard-main:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > app-completed-cards:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(5)";
	public static final String deleteButtonXpath = "/html/body/app/div[1]/div[1]/div[2]/main/app-dashboard/div/div[2]/div/app-dashboard-main/div/div/div[3]/app-completed-cards/div[2]/div[1]/div[1]/div[2]/div/div/ul/li[5]";
	public static final String deleteConfirmationButtonXpath = "//div[@class='popHolder confirmPopup']//button[@class='doneButton']";
}

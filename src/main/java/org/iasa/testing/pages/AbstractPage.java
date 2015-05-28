package org.iasa.testing.pages;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AbstractPage {
	
	protected static RemoteWebDriver DRIVER = new FirefoxDriver();
	
	public static void go(String address){
		if (DRIVER.toString() == null){
			DRIVER = new FirefoxDriver();
		}
		DRIVER.get(address);
	}
	
	public static void checkMessage(String message){
		DRIVER.getPageSource().contains(message);
	}
	
	public static void noMessage(String message){
		DRIVER.findElementsByPartialLinkText(message).isEmpty();
	}
	
	public static void isPresent(String field){
		DRIVER.findElementByLinkText(field); //button is present
	}
	
	public boolean inOut(String field){
		return DRIVER.findElementByLinkText(field).equals(field); //button is present
	}
	
	public static void runGame(String game){
		DRIVER.findElementByPartialLinkText(game).click();
	}
	
	public static void goTo(String value){
		DRIVER.findElementByXPath("//*[contains(text(), value)]").click(); //press button
	}
	
	public static void quit(){
		DRIVER.quit();
	}
	
	public static String titleIs(){
		String result = DRIVER.getTitle();
		return result;
	}
	

}

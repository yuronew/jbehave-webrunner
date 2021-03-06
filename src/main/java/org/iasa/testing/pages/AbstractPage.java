package org.iasa.testing.pages;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionNotFoundException;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractPage {
	private static final Logger LOG = LoggerFactory.getLogger(AbstractPage.class);
	protected static RemoteWebDriver DRIVER;
	
	public static void go(String address){
		if (DRIVER == null){
			reloadWebDriver();
		}
		try {
			DRIVER.get(address);
		} catch (SessionNotFoundException | UnreachableBrowserException e){
			reloadWebDriver();			
			DRIVER.get(address);
		}
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
		DRIVER = null;
	}
	
	public static String titleIs(){
		String result = DRIVER.getTitle();
		return result;
	}
	
	public void tryFiveTimes(Executable func){
		boolean finished = false;
		int i = 0;
		while (finished != true){
			try {
				func.run();
				finished = true;
			} catch (Exception e){
				LOG.error("Failed to perform");
			}
			
			if (i++ >= 5){
				finished = true;
			}
		}
	}
	
	public interface Executable {
		public void run () throws Exception; 
	}

	public static void reloadWebDriver() {
		DRIVER = new FirefoxDriver();
		DRIVER.manage().window().maximize();
	}

}
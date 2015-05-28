package org.iasa.testing.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


public class RegistryForm extends AbstractPage  {
	
	public void fillTheForm(String username, String email, String password){
		DRIVER.findElementByXPath("/html/body/div[1]/div[1]/div/div[2]/div[3]/div[3]/ul/li[3]/a").click(); //Register
		DRIVER.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		DRIVER.switchTo().frame(DRIVER.findElementByXPath("/html/body/div[5]/div/div/div/iframe"));
		DRIVER.findElementById("identity_nickname").clear();
		DRIVER.findElementById("identity_nickname").sendKeys(username);
		DRIVER.findElementById("meta_email").clear();
		DRIVER.findElementById("meta_email").sendKeys(email);
		DRIVER.findElementById("meta_password").clear();
		DRIVER.findElementById("meta_password").sendKeys(password); 
		DRIVER.findElementById("meta_gender_male").click();
		selectValueInDropDown("meta[date_of_birth(2i)]","5");
		selectValueInDropDown("meta[date_of_birth(1i)]","1994");
		selectValueInDropDown("meta[country]","UKR");
		DRIVER.findElementByName("commit").click();
	} 
	
	public static void selectValueInDropDown(String name, String value) { 
		JavascriptExecutor js = (JavascriptExecutor) DRIVER; 
		String jsCmd = "document.getElementsByName('" + name + "')[0].value='" + value + "'"; 
		js.executeScript(jsCmd); 
	}

}

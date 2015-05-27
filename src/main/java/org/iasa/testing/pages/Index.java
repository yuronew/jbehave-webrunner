package org.iasa.testing.pages;

import java.util.concurrent.TimeUnit;


public class Index extends AbstractPage  {
	
	public Index(){
		go("http://www.y8.com/");
		DRIVER.findElementByXPath("/html/body/div[1]/div[1]/div/div[2]/div[3]/div[5]/ul/li/a").click(); //change language
		DRIVER.findElementByXPath("/html/body/div[1]/div[1]/div/div[2]/div[3]/div[5]/div/ul/li[1]/a").click(); //select language
	}
	
	public void logIn(String email, String password){
		DRIVER.findElementByXPath("/html/body/div[1]/div[1]/div/div[2]/div[3]/div[3]/ul/li[2]/a").click();
		DRIVER.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		DRIVER.switchTo().frame(DRIVER.findElementByXPath("/html/body/div[5]/div/div/div/iframe"));
		DRIVER.findElementById("account_email").clear();
		DRIVER.findElementById("account_email").sendKeys(email);
		DRIVER.findElementById("account_password").clear();
		DRIVER.findElementById("account_password").sendKeys(password); 
		DRIVER.findElementByName("commit").click();
	} 
	
	public void inSystem(){
//		String in = "Log out";
//		String out = "Log in";
//		if(inOut(out)){
			DRIVER.findElementByXPath("/html/body/div[1]/div[1]/div/div[2]/div[3]/div[3]/ul/li[2]/a").click();
			DRIVER.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			DRIVER.switchTo().frame(DRIVER.findElementByXPath("/html/body/div[5]/div/div/div/iframe"));
			DRIVER.findElementById("account_email").clear();
			DRIVER.findElementById("account_email").sendKeys("usertesty8@gmail.com");
			DRIVER.findElementById("account_password").clear();
			DRIVER.findElementById("account_password").sendKeys("qwerty777"); 
			DRIVER.findElementByName("commit").click();
//		} else if(inOut(in)){
//			isPresent("My Profile");
//		}
	} 
	
	public void search(String thing){
		DRIVER.findElementById("q").sendKeys(thing);
		DRIVER.findElementByXPath("/html/body/div[1]/div[1]/div/div[2]/div[2]/form/button").click();  
	} 
	
	public void close(){
		DRIVER.close();
	}
	
}

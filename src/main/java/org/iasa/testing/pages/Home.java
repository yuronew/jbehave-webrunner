package org.iasa.testing.pages;

import org.openqa.selenium.By;

public class Home extends AbstractPage {
	
	public void search(String thing){
		DRIVER.findElementById("q").sendKeys(thing);
		DRIVER.findElementById("header-search").findElement(By.xpath("//form/button")).click();
	} 
	
	public void choose(String game){
		DRIVER.findElement(By.id("search_items_container")).findElement(By.xpath("//div[1]/div[3]/a[1]")).click();
	}
	
	public void myProfile(){
		DRIVER.findElementById("header").findElement(By.xpath("//div[2]/div[3]/div[2]/ul/li[3]/a")).click();
		//DRIVER.findElementByXPath("/html/body/div[1]/div[1]/div/div[2]/div[3]/div[2]/ul/li[3]/a").click();
	}
	
	public void logOut(){
		DRIVER.findElementByXPath("/html/body/div[1]/div[1]/div/div[2]/div[3]/div[2]/ul/li[4]/a").click();
	}
	
	public void chooseCategory(String category){
		DRIVER.findElementByPartialLinkText(category).click();
	}

}


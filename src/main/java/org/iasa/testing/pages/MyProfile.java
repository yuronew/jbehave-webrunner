package org.iasa.testing.pages;

import org.openqa.selenium.By;

public class MyProfile extends AbstractPage {
	
	public void editProfile(){
		DRIVER.findElementByXPath("/html/body/div[2]/div[3]/div[1]/div/div[1]/div[1]/div[1]/div/a").click();
	}
	
	public void checkInfo(String info){
		DRIVER.findElementByClassName("container").findElement(By.xpath("//div[3]/div[1]/div/div[1]/div[1]/div[2]/p"));
	}

}


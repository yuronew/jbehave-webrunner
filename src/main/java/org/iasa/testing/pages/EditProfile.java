package org.iasa.testing.pages;

public class EditProfile extends AbstractPage {
	
	public void backToProfile(){
		DRIVER.findElementByXPath("/html/body/div[2]/div[3]/div[1]/div/div[1]/div[1]/form/fieldset/a").click();
	}
	
	public void aboutMe(String info){
		DRIVER.findElementByXPath("/html/body/div[2]/div[3]/div[1]/div/div[1]/div[1]/form/fieldset/textarea").sendKeys(info);
	}
	
	public void deleteAccount(){
		DRIVER.findElementByXPath("/html/body/div[2]/div[3]/div[1]/div/div[1]/div[1]/div[5]/div/a").click();
		DRIVER.findElementByName("ok").click();
	}
	
	/*public void changePic(){
		DRIVER.findElementByXPath("/html/body/div[2]/div[3]/div[1]/div/div[1]/div[1]/div[1]/a").click();
		DRIVER.findElementByXPath("/html/body/div[2]/div[2]/form/input[1]").click();
		
	}*/

}


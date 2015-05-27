package org.iasa.testing.pages;

public class GamePage extends AbstractPage {
	
	public void markFavourite(){
		DRIVER.findElementById("favorites").click();
	} 
	
	public void markHeart(){
		markFavourite();
		DRIVER.findElementById("hearted").click();
	}
	
	public void zoom(String value){
		if (value.equals("+")){
			DRIVER.findElementByXPath("/html/body/div[2]/div[4]/div[2]/div/div/div[1]/a[3]").click();
		}
		if (value.equals("-")){
			DRIVER.findElementByXPath("/html/body/div[2]/div[4]/div[2]/div/div/div[1]/a[2]").click();
		} 
	}
	
	public void rateGame(String like){
		if (like.equals("yes")){
			DRIVER.findElementByXPath("/html/body/div[2]/div[4]/div[9]/div/div[3]/button[1]").click();
		}
		if (like.equals("no")){
			DRIVER.findElementByXPath("/html/body/div[2]/div[4]/div[9]/div/div[3]/button[2]").click();
		}
	}
	
	public void comment(String text){
		DRIVER.findElementById("idnet-comment-text-top").sendKeys(text);
		DRIVER.findElementById("submit-comment-top").click();
	}

}


package org.iasa.testing.steps;

import org.iasa.testing.pages.AbstractPage;
import org.iasa.testing.pages.GamePage;
import org.iasa.testing.pages.Home;
import org.iasa.testing.pages.Index;
import org.iasa.testing.pages.MyProfile;
import org.iasa.testing.pages.RegistryForm;
import org.jbehave.core.annotations.*;

public class GameSteps{
	Index index = new Index();
	RegistryForm registryForm = new RegistryForm();
	Home home = new Home();
	GamePage gamePage = new GamePage();
	MyProfile myProfile = new MyProfile();
	
	@Given("user is in system")
	public void givenUserRequestSite(){
		index.go("http://www.y8.com/");
		index.inSystem();
	}
	
	@When("search $game")
	public void searchGame(String game){
		home.search(game);
	}
	
	@Then("verify found $game")
	public void verifyFoundGame(String game){
		gamePage.checkMessage(game);
		gamePage.checkMessage("GAME");
	}
	
	@When("goes to $category")
	public void goesToCategory(String category){
		AbstractPage.goTo(category);
	}
	
	@When("choose \"$game\"")
	public void whenChooseGame(String game){
		home.choose(game);
	}
	
	@When("run $game")
	public void whenRunGame(String game){
		AbstractPage.runGame(game);
	}
	
	@Given("user is in $game")
	public void userIsInGame(String game){
		AbstractPage.go("http://www.y8.com/");
		home.search("My Friend Pedro");
		AbstractPage.runGame("My Friend Pedro");
	}
	
	@When ("add to favourites")
	public void addToFavourites(){
		gamePage.markFavourite();
	}
	
	@When ("remove from favourites")
	public void removeFromFavourites(){
		gamePage.markFavourite();
	}
	
	@Then("goes to My Profile")
	public void goesToMyProfile(){
		home.myProfile();
	}
	
	@Then("verify \"$game\" is present")
	public void thenVerifyfieldIsPresent(String field){
		 AbstractPage.isPresent(field);  
	}
	
	@Then("verify $game is not present")
	public void verifyGameIsNotPresent(String game){
		myProfile.noMessage(game);
	}
	
	@When("hearted the game")
	public void heartedTheGame(){
		gamePage.markHeart();
	}
	@When("unhearted the game")
	public void nuheartedTheGame(){
		gamePage.markHeart();
	}

	@When("user goes to \"$address\"")
	public void userGoesToAddress(String address){
		AbstractPage.goTo(address);
	}
	
	@Then("verify message is \"$message\"")
	public void thenVerifyMessageIsmessage(String message){
		 AbstractPage.checkMessage(message);
	}
	
	@When("add comment \"$text\"")
	public void addCommentText(String text){
		gamePage.comment(text);
	}
	
}
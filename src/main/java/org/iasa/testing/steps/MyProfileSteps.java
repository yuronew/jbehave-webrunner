package org.iasa.testing.steps;
import org.iasa.testing.pages.AbstractPage;
import org.iasa.testing.pages.EditProfile;
import org.iasa.testing.pages.Home;
import org.iasa.testing.pages.Index;
import org.iasa.testing.pages.MyProfile;
import org.iasa.testing.pages.RegistryForm;
import org.jbehave.core.annotations.*;

public class MyProfileSteps {
	
	Index index = new Index();
	RegistryForm registryForm = new RegistryForm();
	Home home = new Home();
	MyProfile myProfile = new MyProfile();
	EditProfile editProfile = new EditProfile();
	
	@Given("user request site")
	public void givenUserRequestSite(){
		 index.go("http://www.y8.com/");
	}
	
	@Then("verify \"$field\" is present")
	public void thenVerifyfieldIsPresent(String field){
		 myProfile.isPresent(field);  
	}
	
	@Given("user is in system")
	public void userInSystem(){
		index.go("http://www.y8.com/");
		index.inSystem();
	}
	
	@When("user goes to \"$address\"")
	public void userGoesToAddress(String address){
		AbstractPage.goTo(address);
	}
	
	@When("user goes to MyProfile")
	public void userGoesToMyProfile(){
		home.myProfile();
	}
	
	@When("input text \"$text\"")
	public void inputText(String text){
		editProfile.aboutMe(text);
	}
	
	@Then("verify message is \"$message\"")
	public void thenVerifyMessageIsmessage(String message){
		 AbstractPage.checkMessage(message);
	}
	
	@Then("verify $text is not present")
	public void verifyTextIsNotPresent(String text){
		userGoesToMyProfile();
		AbstractPage.noMessage(text);
	}
	
	@When ("user logs in with $email and $password")
	public void userLogsInWithMailAndPassword(String email, String password){
		index.logIn(email, password);
	}
	
}

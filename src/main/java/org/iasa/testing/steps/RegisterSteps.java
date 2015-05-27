package org.iasa.testing.steps;
import org.iasa.testing.pages.AbstractPage;
import org.iasa.testing.pages.Home;
import org.iasa.testing.pages.Index;
import org.iasa.testing.pages.RegistryForm;
import org.jbehave.core.annotations.*;

public class RegisterSteps{
	Index index = new Index();
	RegistryForm registryForm = new RegistryForm();
	Home home = new Home();
	
	@Given("user request site")
	public void givenUserRequestSite(){
		 index.go("http://www.y8.com/");
	}
	
	@When("user fill in the form with $username, $email, $password")
	public void whenUserFillInTheForm(String username, String email, String password){
		registryForm.fillTheForm(username, email, password);
	}
	
	@Then("verify \"$field\" is present")
	public void thenVerifyfieldIsPresent(String field){
		 home.isPresent(field);  
	}
	
	@Then("verify message is \"$message\"")
	public void thenVerifyMessageIsmessage(String message){
		 AbstractPage.checkMessage(message);
	}
	
	@When("user goes to \"$address\"")
	public void userGoesToAddress(String address){
		AbstractPage.goTo(address);
	}
	
	@When ("user logs in with $email and $password")
	public void userLogsInWithMailAndPassword(String email, String password){
		index.logIn(email, password);
	}
	
	@Given("user is in system")
	public void userInSystem(){
		index.go("http://www.y8.com/");
		index.inSystem();
	}
	
	@Then("user log out")
	public void userLogOut(){
		home.logOut();
	}
	
}
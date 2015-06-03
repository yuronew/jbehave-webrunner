package org.iasa.testing.steps;
import org.iasa.testing.pages.AbstractPage;
import org.iasa.testing.pages.Home;
import org.iasa.testing.pages.Index;
import org.iasa.testing.pages.RegistryForm;
import org.jbehave.core.annotations.*;

public class RegisterSteps{
	private Index index;
	private RegistryForm registryForm;
	private Home home;
	
	@Given("user request site")
	public void givenUserRequestSite(){
//		 AbstractPage.go("http://www.y8.com/");
	}
	
	@When("user fill in the form with $username, $email, $password")
	public void whenUserFillInTheForm(String username, String email, String password){
		getRegistryForm().fillTheForm(username, email, password);
	}
	
	@Then("verify \"$field\" is present")
	public void thenVerifyfieldIsPresent(String field){
		AbstractPage.isPresent(field);  
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
		getIndex().logIn(email, password);
	}
	
	@Given("user is in system")
	public void userInSystem(){
		AbstractPage.go("http://www.y8.com/");
		getIndex().inSystem();
	}
	
	@Then("user log out")
	public void userLogOut(){
		getHome().logOut();
	}

	public Index getIndex() {
		if (index == null){
			index = new Index();
		}
		return index;
	}

	public RegistryForm getRegistryForm() {
		if (registryForm == null){
			registryForm = new RegistryForm();
		}
		return registryForm;
	}

	public Home getHome() {
		if (home == null){
			home = new Home();
		}
		return home;
	}
}
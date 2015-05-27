package org.iasa.testing.steps;
import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
public class FirstSteps {
	private RemoteWebDriver driver;
	
	@When("user request site $url")
	public void whenUserRequestSite(String url){
		driver = new FirefoxDriver();
		driver.get(url);
	}
	
	@Then("verify header is  \"$header\"")
	public void thenVerifyHeaderIsheader(String header){
		String title = driver.getTitle();
		driver.quit();
		assertEquals(header, title);
	}
}
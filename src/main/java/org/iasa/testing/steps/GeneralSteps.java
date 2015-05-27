package org.iasa.testing.steps;

import org.jbehave.core.annotations.When;

public class GeneralSteps {  
    
    @When("user request site $site")
    public void requestSite(String site){
    	
    }
    
    @When("user logs in with $username and $password")
    public void logsInWithUsernameAndPassword(String username, String password) {
       
    }
    
    @When("verify $field is present")
    public void verifyField(String field){
    	
    }
    

}

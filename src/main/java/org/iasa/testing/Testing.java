 package org.iasa.testing;

import org.iasa.testing.pages.AbstractPage;
import org.iasa.testing.pages.Home;
import org.iasa.testing.pages.Index;
import org.iasa.testing.pages.RegistryForm;
import org.iasa.testing.pages.MyProfile;
import org.junit.Test;

public class Testing {

	@Test
	public void test(){
		Index index = new Index();
		RegistryForm registryForm = new RegistryForm();
		Home home = new Home();
		home.search("My Friend Pedro");
		home.choose("My Friend Pedro");
		
//		MyProfile myProfile = new MyProfile();
//		index.logIn("portnova.elena94@gmail.com", "lenyska2508");
//		home.myProfile();
//		myProfile.checkInfo("lalalala");
//		registryForm.fillTheForm("userTest-1", "portnova.elena+4@gmail.com", "");
//		registryForm.checkMessage("can't be blank");
//		index.close();
//		index.logIn("portnova.elena94@gmail.com", "lenyska2508");
//		home.goTo("My profile");
//		myProfile.checkMessage("portnova.elena94@gmail.com");
//		myProfile.isPresent("Log in");
//		home.logOut();
	}
	
}
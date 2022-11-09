package testClass;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	
	@Test(priority=1)
	public void verifyUrlofLoginPage() {
		AssertJUnit.assertEquals(loginPage.getURLOfLoginPage(),"https://qa-refapp.openmrs.org/openmrs/login.htm");
		
	}
	
	@Test(priority=2)
	public void verifyTitleofLoginPage() {
		AssertJUnit.assertEquals(loginPage.getTitleOfLoginPage(),"Login");
	}
	
	@Test(priority=3)
	public void verifyLoginPage() {
		loginPage.login("Admin", "Admin123");
		AssertJUnit.assertEquals(homePage.getTitleOfHomePage(), "Home");
		homePage.selectRegisterPatient();
	}

}

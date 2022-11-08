package testClass;

import java.awt.AWTException;

import org.jsoup.select.Evaluator.ContainsText;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EMRTest extends BaseTest{
	
	
	@BeforeClass
	public void loginPageAndSelectCategory() {
		loginPage.login("Admin", "Admin123");
		homePage.selectRegisterPatient();
	}
		
	@Test(priority=4)
	public void verifyTitleOfEMRPage() {
		Assert.assertEquals(emrPage.getTitleOfEMRPage(), "OpenMRS Electronic Medical Record");
	}
	
	@Test(priority=5)
	public void addPatientDemographic() {
		emrPage.addPatientDetails("Sharad","Sahu");
		emrPage.selectGender();
		emrPage.addDOB("15","August","1992");
		emrPage.addAddress();
		emrPage.addMobileNumber();
	}
	
	@Test(priority=6)
	public void verifyPatientDetails() {		
		emrPage.getPatientDetails();
	}
	
	@Test(priority=7)
	public void clickOnConfirmBtn() {
		emrPage.confirmDetails();
	}
	
	@Test(priority=8)
	public void verifyDOBisCorrectOrNot() {
		Assert.assertEquals(emrPage.checkAge(), "30 year(s) ( 15.Aug.1992)");
	}
	@Test(priority=9)
	public void clickOnStartVisit() throws AWTException {
		emrPage.selectStartVisit();
		emrPage.clickAttachment();
	}
	
	
}



















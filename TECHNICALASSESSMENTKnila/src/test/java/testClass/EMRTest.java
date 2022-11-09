package testClass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
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
		AssertJUnit.assertEquals(emrPage.getTitleOfEMRPage(), "OpenMRS Electronic Medical Record");
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
		AssertJUnit.assertEquals(emrPage.checkAge(), "30 year(s) ( 15.Aug.1992)");
	}
	@Test(priority=9)
	public void clickOnStartVisit() throws AWTException, InterruptedException {
		emrPage.selectStartVisit();
		emrPage.clickAttachment();
		emrPage.enterCaptionAndClickUploadFile();
		emrPage.clickObBreadCrum();
	}
	
	@Test(priority=10)
	public void goToVerifyVital() throws InterruptedException {
		emrPage.endVisitClick();
		Thread.sleep(2000);
		emrPage.selectStartVisit();
	}
	
	@Test(priority=11)
	public void collectVital() throws InterruptedException {
		emrPage.captureVital();
	}
	
	@Test(priority=12)
	public void mergeVital() throws InterruptedException {
		emrPage.mergeVisit();
		emrPage.clickAllCheckBox();
		emrPage.clickOnMergeBtn();
	}
	
	@Test(priority=13)
	public void checkCalenderandDeleteRecord() {
		emrPage.handleCalenderPastVisit();
		emrPage.deletePatientRecord();
	
	}
	
}



















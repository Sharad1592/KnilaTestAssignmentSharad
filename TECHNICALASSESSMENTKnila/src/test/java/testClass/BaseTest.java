package testClass;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageClass.BaseClass;
import pageClass.EMRPage;
import pageClass.HomePage;
import pageClass.LoginPage;

public class BaseTest extends BaseClass {
	
	@BeforeClass
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().getPageLoadTimeout();
		driver.get("https://qa-refapp.openmrs.org/openmrs/login.htm");
	}
	
	@BeforeClass
	public void pageObject() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		emrPage = new EMRPage(driver);
	
	}
	
//	@AfterClass
//	public void tearDownEnvironment() {
//		driver.quit();
//	}

}

package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
	

	@FindBy(xpath="//i[@class='icon-user']")
	private WebElement registerPatient;
		
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectRegisterPatient() {
		registerPatient.click();
	}
	
	public String getTitleOfHomePage() {
		return driver.getTitle();
	}
			
}

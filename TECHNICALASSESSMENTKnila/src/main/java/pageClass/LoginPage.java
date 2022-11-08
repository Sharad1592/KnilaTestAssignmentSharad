package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	
	@FindBy(xpath="//*[@id='username']")
	private WebElement userName;
	
	@FindBy(xpath="//*[@id='password']")
	private WebElement passWord;
	
	@FindBy(xpath="//*[@id='Outpatient Clinic']")
	private WebElement Location;
	
	@FindBy(xpath="//*[@id='loginButton']")
	private WebElement btnLogin;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String usnm, String pwd) {
		userName.sendKeys(usnm);
		passWord.sendKeys(pwd);
		Location.click();
		btnLogin.click();
	}
	
	public String getTitleOfLoginPage() {
		return driver.getTitle();
	}
	
	public String getURLOfLoginPage() {
		return driver.getCurrentUrl();
	}
}

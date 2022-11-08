package pageClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EMRPage extends BaseClass {
	
	@FindBy(xpath="//input[@name='givenName']")
	private WebElement givenName;
	
	@FindBy(xpath="//input[@name='familyName']")
	private WebElement familyName;
	
	@FindBy(xpath="//*[@id='next-button']")
	private WebElement nextBtn;
	
	@FindBy(xpath="//*[@id='gender-field']")
	private WebElement gender;
		
	@FindBy(xpath="//*[@id='birthdateDay-field']")
	private WebElement day;
	
	@FindBy(xpath="//*[@id='birthdateMonth-field']")
	private WebElement month;
	
	@FindBy(xpath="//*[@id='birthdateYear-field']")
	private WebElement year;
	
	@FindBy(xpath="//*[@id='address1']")
	private WebElement address1;
	
	@FindBy(xpath="//*[@id='cityVillage']")
	private WebElement city;
	
	@FindBy(xpath="//*[@id='stateProvince']")
	private WebElement state;
	
	@FindBy(xpath="//*[@id='country']")
	private WebElement country;
	
	@FindBy(xpath="//*[@id='postalCode']")
	private WebElement postalCode;
	
	@FindBy(xpath="//*[@id='phoneNumberLabel']//p//input")
	private WebElement mobileNo;
	
	@FindBy(xpath="//*[@id='dataCanvas']//p")
	private List<WebElement> patientDetails;
	
	@FindBy(xpath="//input[@id='submit']")
	private WebElement confirmDetails;
	
	@FindBy(xpath="//div[@class='gender-age col-auto']//span[2]")
	private WebElement checkAge;
	
	@FindBy(xpath="//div[@class='col-11 col-lg-10']")
	private List<WebElement> generalAction;
	
	@FindBy(xpath="//button[@id='start-visit-with-visittype-confirm']")
	private WebElement confirmBtn;
	
	@FindBy(xpath="//a[@id='attachments.attachments.visitActions.default']")
	private WebElement attachmentBtn;
	
	@FindBy(xpath="//*[@id='visit-documents-dropzone']")
	private WebElement uploadFile;
	
	public EMRPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addPatientDetails(String fname, String lname) {
		givenName.sendKeys(fname);
		familyName.sendKeys(lname);
		nextBtn.click();
	}
	
	public void selectGender() {
		Select selGender = new Select(gender);
		selGender.selectByValue("M");
		nextBtn.click();
	}
	
	public void addDOB(String days, String months, String years)  {
		day.sendKeys(days);
		Select selMonth = new Select(month);
		selMonth.selectByVisibleText(months);
		year.sendKeys(years);
		nextBtn.click();
	}
	
	public void addAddress() {
		address1.sendKeys("Shristi Village");
		city.sendKeys("Bangalore");
		state.sendKeys("Karnataka");
		postalCode.sendKeys("123456");
		nextBtn.click();
	}
	
	public void addMobileNumber() {
		mobileNo.sendKeys("1234567890");
		nextBtn.click();
		nextBtn.click();
	}
	
	public void getPatientDetails() {
		
		for(WebElement pd:patientDetails) {
			System.out.println(pd.getText()); 
		}
		
	}
	
	public void confirmDetails() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		confirmDetails.click();
	}
	
	public String checkAge() {
		String age = checkAge.getText();
		return age;
	}
	
	public void selectStartVisit() {
		for(WebElement ga:generalAction) {
			if(ga.getText().equals("Start Visit"))
				ga.click();
			break;
		}
		confirmBtn.click();
	}
	
	public void clickAttachment() throws AWTException {
		attachmentBtn.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click",uploadFile);
		Robot rb = new Robot();
		rb.delay(1000);
		StringSelection ss = new StringSelection("C:\\Users\\shara\\OneDrive\\Desktop\\uploadfile.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	public String getTitleOfEMRPage() {
		return driver.getTitle();
	}
}

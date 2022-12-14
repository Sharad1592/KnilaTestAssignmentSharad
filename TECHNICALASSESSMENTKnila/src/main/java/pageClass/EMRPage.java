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
	
	@FindBy(xpath="//*[@placeholder='Enter a caption']")
	private WebElement textArea;
	
	@FindBy(xpath="//button[@class='confirm ng-binding']")
	private WebElement btnUploadFile;
	
	@FindBy(xpath="//i[@class='icon-chevron-right link']//parent::li//a")
	private WebElement breadCrum;
	
	
	@FindBy(xpath="/html/body/div[1]/div[3]/div[9]/div[3]/div/ul[1]/li[1]/a/div/div[2][1]")
	private WebElement endVisit;
	
	@FindBy(xpath="//input[@id='visitId']//parent::div//button[@class='confirm right']")
	private WebElement btnYes;
	
	@FindBy(xpath="//a[@id='referenceapplication.realTime.vitals']")
	private WebElement captureVitalBtn;
	
	@FindBy(xpath="//input[@id='w8']")
	private WebElement heightInput;
	
	@FindBy(xpath="//input[@id='w10']")
	private WebElement weightInput;
	
	@FindBy(xpath="//a[@id='save-form']")
	private WebElement saveForm;
	
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//a[text()=' End Visit']")
	private WebElement endBtn;
	
	@FindBy(xpath="//div[@id='end-visit-dialog']//button[@class='confirm right']")
	private WebElement confirmYes;
	
	@FindBy(xpath="//div[@class='col-12 col-sm-auto']")
	private WebElement nameBtn;
	
	@FindBy(xpath="/html/body/div[1]/div[3]/div[9]/div[2]/div/ul/li[3]/a/div/div[2][1]")
	private WebElement mergeVisit;
	
	
	@FindBy(xpath="//input[@class='selectVisit']")
	private List<WebElement> checkBox;
	
	@FindBy(xpath="//input[@id='mergeVisitsBtn']")
	private WebElement mergeBtn;
	
	@FindBy(xpath="//input[@class='cancel']")
	private WebElement returnBtn;
	
	@FindBy(xpath="/html/body/div[1]/div[3]/div[9]/div[2]/div/ul/li[2]/a/div/div[2][1]")
	private WebElement pastVisit;
	
	@FindBy(xpath="//label[@for='startDate']//parent::p//i")
	private WebElement calenderIcon;
	
	@FindBy(xpath="/html/body/div[2]/div[3]/table/tbody/tr[3]/td[5]")
	private WebElement dateCheck;
	
	@FindBy(xpath="/html/body/div[5]/div/div/div[2]/button[1][1]")
	private WebElement cancleBtn;
	
	@FindBy(xpath="/html/body/div[1]/div[3]/div[9]/div[2]/div/ul/li[8]/a/div/div[2][1]")
	private WebElement deletePatient;
	
	@FindBy(xpath="//input[@id='delete-reason']")
	private WebElement addReason;
	
	@FindBy(xpath="//div[@id='delete-patient-creation-dialog']//button[@class='confirm right']")
	private WebElement deleteConfirmBtn;
	
	
	
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
		mobileNo.sendKeys("9518331398");
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
		rb.delay(2000);
		StringSelection ss = new StringSelection("C:\\Users\\shara\\Downloads\\uploadfiless.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void enterCaptionAndClickUploadFile() throws InterruptedException {
		textArea.sendKeys("TestFile");
		Thread.sleep(2000);
		btnUploadFile.click();
	}
	
	public void clickObBreadCrum()  {
		breadCrum.click();
	}
	
	public void endVisitClick() {
		endVisit.click();
		btnYes.click();
	}
	
	public void captureVital() throws InterruptedException {
		captureVitalBtn.click();
		heightInput.sendKeys("184");
		nextBtn.click();
		weightInput.sendKeys("84");
		saveForm.click();
		saveBtn.click();
		endBtn.click();
		confirmYes.click();
		Thread.sleep(1000);
		nameBtn.click();
	}
	
	public void mergeVisit() {
		mergeVisit.click();
	}
		
	public void clickAllCheckBox() throws InterruptedException{
		Thread.sleep(1000);
		for(WebElement cb:checkBox) {
			cb.click();
		}
		
	}
	
	public void clickOnMergeBtn() throws InterruptedException {
		Thread.sleep(1000);
		mergeBtn.click();
		Thread.sleep(2000);
		returnBtn.click();
	}
	
	public void handleCalenderPastVisit() {
		pastVisit.click();
		calenderIcon.click();
		System.out.println(dateCheck.isDisplayed());
		cancleBtn.click();
	}
	
	public void deletePatientRecord() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		deletePatient.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		addReason.sendKeys("This is Test");
		deleteConfirmBtn.click();
		
	}
	
	public String getTitleOfEMRPage() {
		return driver.getTitle();
	}
}

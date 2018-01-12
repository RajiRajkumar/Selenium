package pages.govtech.bgp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusinessGrantsPortal {
	public static WebDriver driver;

	public static void bgpLoginUntilProceed() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://public:Let$BeC001@bgp-qa.gds-gov.tech");
		driver.manage().window().maximize();
		driver.findElement(By.id("login-button")).click();

		WebElement predefinedUser = driver.findElement(By.name("SAMLart"));
		Select sel = new Select(predefinedUser);

		sel.selectByValue("S9111111A");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		WebElement myGrants = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.presenceOfElementLocated(By
						.xpath("//p[text()='Apply for a grant to support your project']")));
		myGrants.click();

		WebElement BldgNConstr = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By
						.xpath("//input[@id='Building & Construction']")));
		BldgNConstr.click();

		driver.findElement(By.xpath("//div[text()='Builders (Contractors)']"))
				.click();
		driver.findElement(
				By.xpath("//div[text()='Upgrade key business areas, such as adopt technology, improve business processes or raise service standards']"))
				.click();
		driver.findElement(
				By.xpath("//div[text()='Pre-Approved Productivity Solutions']"))
				.click();

		WebElement Apply = driver.findElement(By
				.xpath("//button[text()='Apply']"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Apply);

		WebElement Proceed = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By
						.xpath("//button[text()='Proceed']")));
		Proceed.click();

	}

	public static void eligibilityCriteriaClickYes() {

		WebElement criteriaNo = driver.findElement(By
				.xpath("//span[text()='Yes']"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", criteriaNo);

	}

	public static void eligibilityCriteriaClickNo() {

		WebElement criteriaNo = driver.findElement(By
				.xpath("//span[text()='No']"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", criteriaNo);

	}

	public static boolean isNextEnabled() {
		boolean status = driver.findElement(
				By.xpath("//button[@id='next-btn']")).isEnabled();
		return status;
	}

	public static boolean isEligibilityEnabled() {
		boolean status = driver.findElement(
				By.xpath("//span[text()='Eligibility']")).isEnabled();
		return status;
	}

	public static boolean isContactDetailsEnabled() {
		boolean status = driver.findElement(
				By.xpath("//span[text()='Contact Details']")).isEnabled();
		return status;
	}

	public static boolean isProposalEnabled() {
		boolean status = driver.findElement(
				By.xpath("//span[text()='Proposal']")).isEnabled();
		return status;
	}

	public static boolean isCostEnabled() {
		boolean status = driver.findElement(By.xpath("//span[text()='Cost']"))
				.isEnabled();
		return status;
	}

	public static boolean isBusinessImpactEnabled() {
		boolean status = driver.findElement(
				By.xpath("//span[text()='Business Impact']")).isEnabled();
		return status;
	}

	public static boolean isDeclareReviewEnabled() {
		boolean status = driver.findElement(
				By.xpath("//span[text()='Declare & Review']")).isEnabled();
		return status;
	}

	public static String verifyWarningMessage() {
		String WarnMsg = driver.findElement(By.partialLinkText("SME portal"))
				.getText();
		return WarnMsg;
	}

	public static String verifySMEPortal() {
		driver.findElement(
				By.xpath("//a[@href='https://smeportal.sg/content/smeportal/en/moneymatters.html#saText']"))
				.click();
		;
		String SMEPortalTitle = driver.getTitle();

		return SMEPortalTitle;
	}

	public static void verifySaveFunction() {
		driver.findElement(By.id("react-contact_info-name")).sendKeys("Rajeswari Rajkumar");
		driver.findElement(By.id("react-contact_info-designation")).sendKeys("Test Automation Engineer");
		driver.findElement(By.id("react-contact_info-phone")).sendKeys("98765432");

		driver.findElement(By.id("react-contact_info-primary_email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("contact_info-correspondence_address")).click();
		driver.findElement(By.id("react-contact_info-copied")).click();
		driver.findElement(By.xpath("//button[@id='save-btn']")).click();
	}

	public static String verifySavedDraftOnHomePage() {
		driver.navigate().to("https://bgp-qa.gds-gov.tech/dashboard");

		driver.findElement(By.xpath("//a[text()='Drafts (207)']")).click();
		String ProjTitle = driver.findElement(By.xpath("//div[text()='Personnel lift')]")).getText();
		return ProjTitle;
	}

	public static String submitApplicationForm() {
		driver.navigate().to("https://bgp-qa.gds-gov.tech/dashboard");
		driver.findElement(By.xpath("//a[text()='Drafts (207)']")).click();
		driver.findElement(By.xpath("//a[text()='Project Title']")).click();
		driver.findElement(By.id("react-contact_info-primary_email")).sendKeys("abc@email.com");
		driver.findElement(By.id("contact_info-correspondence_address")).click();
		driver.findElement(By.id("react-contact_info-copied")).click();
		driver.findElement(By.xpath("//button[@id='next-btn']")).click();

		Select sel1 = new Select(driver.findElement(By.id("react-select-project_cost-psg_payment_mode_id--value-item")));
		sel1.selectByVisibleText("Direct Purchase");
		driver.findElement(By.xpath("//button[@id='next-btn']")).click();

		driver.findElement(By.id("react-project-locations-0-project_ref_num  ")).sendKeys("E1234-56789-0123");
		driver.findElement(By.xpath("//button[@id='next-btn']")).click();

		List<WebElement> radioList = driver.findElements(By.xpath("//span[text()='No']"));

		for(WebElement ele :radioList){

			ele.click();
		}
		driver.findElement(By.id("react-declaration-consent_acknowledgement_check")).click();

		String ApplRefID = "Application_Ref_ID";
		return ApplRefID;
	}

}

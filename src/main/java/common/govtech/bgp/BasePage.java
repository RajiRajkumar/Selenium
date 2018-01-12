package common.govtech.bgp;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static final Logger log = Logger.getLogger(BasePage.class);
	WebDriverWait wait;
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		this.driver = driver;
	}

	public void waitForPageToLoad() {
		log.info("Waiting for DOM to be ready.");
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				String javaScript = "return document.readyState";
				return ((JavascriptExecutor) driver).executeScript(javaScript)
						.toString().equals("complete");
			}
		});
	}

	public boolean isClickable(String locator, Locator type) {
		try {

			log.info("Waiting for element to be clickable. " + locator);
			wait.until(ExpectedConditions.elementToBeClickable(Utils
					.getLocator(locator, type)));
			log.info(locator + " is clickable.");
		} catch (TimeoutException t) {
			log.warn(locator + " is not clickable");
			return false;
		}
		return true;
	}

}

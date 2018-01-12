package govtech.bgp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;


public class TestBase {
	protected WebDriver driver;
	@BeforeClass
	public void initializeBrowser(){

		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
}



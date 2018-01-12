package common.govtech.bgp;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;



public class Utils {

    final static Logger log = Logger.getLogger(Utils.class);

	public static By getLocator(String locator, Locator type){
		By loc;
		switch (type) {
			case CLASS_NAME:
				loc = By.className(locator);
				break;
			case CSS_SELECTOR:
				loc = By.cssSelector(locator);
				break;
			case ID:
				loc = By.id(locator);
				break;
			case LINK_TEXT:
				loc = By.linkText(locator);
				break;
			case NAME:
				loc = By.name(locator);
				break;
			case PARTIAL_LINK_TEXT:
				loc = By.partialLinkText(locator);
				break;
			case XPATH:
				loc = By.xpath(locator);
				break;
			default:
				return null;
		}
		return loc;
	}
}


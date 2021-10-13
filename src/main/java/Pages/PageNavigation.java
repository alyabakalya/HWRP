package Pages;

import org.openqa.selenium.WebDriver;

import cucumberDriver.DriverManager;

public class PageNavigation extends BasePage {

	public static WebDriver openPage(WebDriver driver, String pageUrl) {
		DriverManager.getDriver().get(pageUrl);
		return driver;
	}
}

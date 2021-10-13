package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
import cucumberDriver.DriverManager;
import util.WebDriverWaiter;

public class BasePage extends WebDriverWaiter {
	public BasePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public BasePage clickElement(WebElement element) {
		element.click();
		return this;
	}

	public BasePage sendValueToInputField(WebElement element, String value) {
		element.sendKeys(value);
		return this;
	}

	public String getPageUrl() {
		return DriverManager.getDriver().getCurrentUrl();
	}

	public String getTextValue(WebElement text) {
		return text.getText();
	}

}

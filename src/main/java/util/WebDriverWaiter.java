package util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import cucumberDriver.DriverManager;

public class WebDriverWaiter {
	public WebDriverWaiter waitForElement(WebElement element, long seconds){
		getWebDriverWait(seconds).until(elementIsDisplayed(element));
		return this;
	}

	private WebDriverWait getWebDriverWait(long seconds) {
		return new WebDriverWait(DriverManager.getDriver(), seconds);
	}

	private ExpectedCondition<Boolean> elementIsDisplayed(WebElement element) {
		return driver -> element.isDisplayed();
	}
}
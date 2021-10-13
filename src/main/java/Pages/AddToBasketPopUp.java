package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddToBasketPopUp extends BasePage {

	@FindBy(xpath = "//h3[@class='modal-title']")
	WebElement successMessage;

	@FindBy(xpath = "//a[@class='btn btn-primary pull-right continue-to-basket string-to-localize link-to-localize']")
	WebElement basketCheckoutButton;

	public String getSuccessMessage() {
		waitForElement(successMessage, 10);
		return getTextValue(successMessage);
	}

	public void clickOnBasketCheckoutButton() {
		waitForElement(basketCheckoutButton, 10);
		clickElement(basketCheckoutButton);
	}
}

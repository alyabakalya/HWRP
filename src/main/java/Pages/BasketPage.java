package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage{
	@FindBy(xpath = "//div[@class = 'basketHeaderButtons']/a[@class = 'checkout-btn btn optimizely-control']")
	WebElement checkoutButton;

	public void clickOnCheckoutButton() {
		clickElement(checkoutButton);
	}
}

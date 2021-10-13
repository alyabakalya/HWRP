package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PaymentDetailsPage extends BasePage{
	@FindBy(xpath = "//div[@class='sidebar right']//span[@class='item-total']")
	WebElement totalInHeader;

	@FindBy(xpath = "//div[@class='sidebar right']//dd[@class='text-right total-price']")
	WebElement ultimateTotal;

	@FindBy(xpath = "//div[@class='sidebar right']//strong[contains(text(), 'Sub-total')]/parent::dt/following-sibling::dd")
	WebElement subtotal;

	public String getTotalInHeaderText() {
		return getTextValue(totalInHeader);
	}

	public String getSubtotalText() {
		return getTextValue(subtotal);
	}
}

package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

	@FindBy(xpath = "//a[@data-isbn='9780345538376']")
	WebElement addToBasketButtonForAProduct;

	public void clickOnAddToBasketButton(){
		clickElement(addToBasketButtonForAProduct);
	}
}
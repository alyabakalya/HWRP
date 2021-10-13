package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	@FindBy(xpath = "//input[@name='searchTerm']")
	WebElement searchInput;

	@FindBy(xpath = "//button[@aria-label='Search']")
	WebElement searchButton;

	@FindBy(xpath = "//div[@class='user-nav-wrap ']//i[@class='icon-user']")
	WebElement signInJoinButton;

	@FindBy(xpath = "//div[@class = 'user-nav']//a[text() = 'My Account']")
	WebElement myAccountButton;

	@FindBy(xpath = "//div[@class='message-success']/div[@class='text']")
	WebElement successfulRegisterMessage;

	public void enterSearchTerm(String searchTerm) {
		sendValueToInputField(searchInput, searchTerm);
	}

	public void clickOnSearchButton() {
		clickElement(searchButton);
	}

	public String getSuccessfulRegisterMessage() {
		return getTextValue(successfulRegisterMessage);
	}

	public void clickOnSignInJoinButton() {
		clickElement(signInJoinButton);
	}

	public void clickOnMyAccountButton() {
		clickElement(myAccountButton);
	}


}

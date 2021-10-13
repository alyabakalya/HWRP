package cucumberStepDefinitions;

import org.junit.Assert;

import Pages.*;
import cucumberDriver.DriverManager;
import io.cucumber.java.en.*;

public class AddToBasketStepDefinitions {
	private HomePage homePage = new HomePage();
	private SearchResultsPage searchResultsPage = new SearchResultsPage();
	private AddToBasketPopUp addToBasketPopUp = new AddToBasketPopUp();

	@Given("User opens Home Page")
	public void openHOmePage() {
		PageNavigation.openPage(DriverManager.getDriver(), "https://www.bookdepository.com/");
	}

	@And("^User enters ([\\w\\s]+) for product$")
	public void enterSearchTerm(String searchTerm) {
		homePage.enterSearchTerm(searchTerm);
	}

	@And("User is able to click on Search button")
	public void clickOnSearchButton() {
		homePage.clickOnSearchButton();
	}

	@When("User clicks on Add to Basket button at Search Results page")
	public void clickOnAddToBasketButton() {
		searchResultsPage.clickOnAddToBasketButton();
	}

	@Then("^Add to Basket pop-up with a success message is shown - ([\\w\\s]+)$")
	public void popUpWithSuccessMessageIsDisplayed(String expectedMessage) {
		Assert.assertEquals("Success message is incorrect",
				expectedMessage, addToBasketPopUp.getSuccessMessage());
	}
}

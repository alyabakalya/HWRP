package cucumberStepDefinitions;

import org.junit.Assert;

import Pages.*;
import cucumberDriver.DriverManager;
import io.cucumber.java.en.*;

public class SearchStepDefinitions {
	private BasePage basePage = new BasePage();
	private HomePage homePage = new HomePage();

	@Given("User is at Home Page")
	public void openHomePage() {
		PageNavigation.openPage(DriverManager.getDriver(), "https://www.bookdepository.com/");
	}

	@When("^User enters ([\\w\\s]+) into the search input")
	public void enterSearchTerm(String searchTerm) {
		homePage.enterSearchTerm(searchTerm);
	}

	@And("^User clicks on Search button$")
	public void clickOnSearchButton() {
		homePage.clickOnSearchButton();
	}

	@Then("^Search Results Page with URL ((?:http|https):\\/\\/[\\w+./?=&]+) is displayed$")
	public void verifyHomePageURL(String expectedURL) {
		Assert.assertEquals("Page URL is incorrect" , expectedURL, basePage.getPageUrl());
	}
}
package cucumberStepDefinitions;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import Pages.*;
import cucumberDriver.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class CheckTotalAndSubtotalStepDefinitions {
	private BasePage basePage = new BasePage();
	private HomePage homePage = new HomePage();
	private SearchResultsPage searchResultsPage = new SearchResultsPage();
	private AddToBasketPopUp addToBasketPopUp = new AddToBasketPopUp();
	private BasketPage basketPage = new BasketPage();
	private PaymentDetailsPage paymentDetailsPage = new PaymentDetailsPage();

	@Given("User goes to Home Page")
	public void goToHomePage() {
		PageNavigation.openPage(DriverManager.getDriver(), "https://www.bookdepository.com/");
	}

	@And("^User enters ([\\w\\s]+) into the search input field$")
	public void enterSearchTerm(String searchTerm) {
		homePage.enterSearchTerm(searchTerm);
	}

	@And("User can click on Search button")
	public void clickSearchButton() {
		homePage.clickOnSearchButton();
	}

	@When("User clicks on Add to Basket button at Search Page")
	public void clickOnAddToBasketButton() {
		searchResultsPage.clickOnAddToBasketButton();
	}

	@And("User clicks on Basket \\ Checkout button at Add to Basket pop-up")
	public void clickOnBasketCheckoutButton() {
		addToBasketPopUp.clickOnBasketCheckoutButton();
	}

	@And("User clicks on Checkout button at Your basket page")
	public void clickOnCheckoutButton() {
		basketPage.clickOnCheckoutButton();
	}

	@Then("^Payment Details Page is displayed with URL (https?:\\/\\/[.\\w\\s\\/?=+&]+)$")
	public void verifyPaymentDetailsPageURL(String expectedURL) {
		Assert.assertEquals("Page URL is incorrect" , basePage.getPageUrl(), expectedURL);
	}

	@And("^Subtotal and total are as following:$")
	public void subtotalIsAsFollowing(DataTable table) {
		List<Map<String, String>> rows = table.asMaps(String.class, String.class);

		assertSoftly(
				softAssertions -> {
					softAssertions.assertThat(paymentDetailsPage.getTotalInHeaderText())
							.as("Total is incorrect")
							.isEqualTo(rows.get(0).get("value"));
					softAssertions.assertThat(paymentDetailsPage.getSubtotalText())
							.as("Total is incorrect")
							.isEqualTo(rows.get(1).get("value"));
				});

	}
}

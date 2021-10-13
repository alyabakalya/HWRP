package cucumberStepDefinitions;

import org.junit.Assert;
import Pages.*;
import cucumberDriver.DriverManager;
import io.cucumber.java.en.*;

public class CreateNewAccountStepDefinitions {
	BasePage basePage = new BasePage();
	HomePage homePage = new HomePage();
	JoinPage joinPage  = new JoinPage();

	@Given("A user opens Home Page")
	public void openHomePage() {
		PageNavigation.openPage(DriverManager.getDriver(), "https://www.bookdepository.com/");
	}

	@And("User clicks on Sign In-Join button at Home Page")
	public void clickOnSignInJoinButton() {
		homePage.clickOnSignInJoinButton();
	}

	@When("User fills {string}, {string}, and {string} at Join form")
	public void aUserFillsAndAtJoinForm(String name, String email, String password) {
		joinPage.enterUserInfo(name, email, password);
	}

	@And("User clicks on Create Your Account button")
	public void clickOnCreateYourAccountButton() {
		joinPage.clickOnCreateYourAccountButton();
	}

	@Then("^Message about successful registration is shown - ([\\w\\s!.]+)$")
	public void goToMyAccountPage(String expectedSuccessMesage) {
		Assert.assertEquals("Page title is incorrect", expectedSuccessMesage, homePage.getSuccessfulRegisterMessage());
	}

	@When("Registered user clicks on My Account button")
	public void clickOnMyAccountButton() {
		homePage.clickOnMyAccountButton();
	}

	@Then("^My Account Page is displayed with the URL ((?:http|https):\\/\\/[\\w+./?=&]+)$")
	public void verifyMayAccountPageURL(String expectedURL) {
		Assert.assertEquals("Page URL is incorrect" , basePage.getPageUrl(), expectedURL);
	}
}

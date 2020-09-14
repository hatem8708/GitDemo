package stepDefinitions;

import org.junit.runner.RunWith;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPageO;
import pageObjects.PortalHomePage;
import resources.Bases;

@RunWith(Cucumber.class)
public class stepDefinitions extends Bases {

	@And("^Click on Login in home page to land on secure Sign in page$")
	public LoginPageO click_on_login_in_home_page_to_land_on_secure_sign_in_page() {
		LandingPage lp = new LandingPage(driver);
		if (lp.getPopUpSize() > 0) {
			lp.getPopUp().click();
		}
		LoginPageO lpo = lp.getLogin();
		return lpo;

	}

	@And("^close browser$")
	public void close_browser() {
		driver.quit();
	}

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver = intializeDriver();
	}

	@And("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_Site(String strArg1) {
		driver.get(strArg1);
	}

	@When("^User enters (.+) and (.+) and logs in$")
	public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		LoginPageO lpo = new LoginPageO(driver);
		lpo.emailField().sendKeys(username);
		lpo.passwordField().sendKeys(password);
		lpo.loginButton().click();
	}

	@Then("^Verify that user is successfully loged in$")
	public void verify_that_user_is_successfully_loged_in() {
		PortalHomePage p = new PortalHomePage(driver);
		Assert.assertTrue(p.getSeachBox().isDisplayed());
	}

}

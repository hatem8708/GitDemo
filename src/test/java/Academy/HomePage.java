package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPageO;
import resources.Bases;

public class HomePage extends Bases {
	public static Logger log = LogManager.getLogger(Bases.class.getName());
	public WebDriver driver;

	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException {

		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");

		LandingPage lp = new LandingPage(driver);
		LoginPageO lpo = lp.getLogin();

		lpo.emailField().sendKeys(username);
		lpo.passwordField().sendKeys(password);
		lpo.loginButton().click();
		log.info(text);
		ForgotPassword fp = lpo.forgotPassword();
		fp.getEmail().sendKeys("abc.email.com");
		fp.sendInstructions().click();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];// [2]: 0,1: 2 types of data that should be tested = rows (here restricted
											// user and nonrestricted user)
											// [3]: 0,1,2: 3 values per row used in the tests (here username, password
											// and user type)
		// Oth row
		data[0][0] = "nonrestricteduser@email.com";
		data[0][1] = "123456";
		data[0][2] = "NonRestricted User";

		// 1st Row
		data[1][0] = "restricteduser@email.com";
		data[1][1] = "56789";
		data[1][2] = "Restricted User";

		return data;

	}

	@BeforeTest
	// Executed only once
	// So if the test case (methode) requires hitting same url twice or more, we
	// shouldn't write
	// the
	// instruction in the BeforeTest block
	public void initialize() throws IOException {
		driver = intializeDriver();
		log.info("Driver is initialized");

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}

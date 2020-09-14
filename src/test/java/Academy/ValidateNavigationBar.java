package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Bases;

public class ValidateNavigationBar extends Bases {
	public static Logger log = LogManager.getLogger(Bases.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = intializeDriver();

		driver.get(prop.getProperty("url"));

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

	@Test
	public void validateNavigationBar() throws IOException {

		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		log.info("Navigation bar is displayed");

	}
}

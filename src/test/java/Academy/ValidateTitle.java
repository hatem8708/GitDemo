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

public class ValidateTitle extends Bases {
	public static Logger log = LogManager.getLogger(Bases.class.getName());
	public WebDriver driver;
	LandingPage lp;

	@BeforeTest
	public void initialize() throws IOException {
		driver = intializeDriver();
		log.info("Driver is initialized");

		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

	@Test
	public void validateHeader() throws IOException {
		lp = new LandingPage(driver);
		Assert.assertEquals(lp.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Successfully validated Text message");
	}

	@Test
	public void ValidateTitle() throws IOException {
		// Object for invoking LandingPage
		lp = new LandingPage(driver);

		Assert.assertEquals(lp.getCenteredText().getText().toLowerCase(), "featured courses");
		log.info("Successfully validated Text message");
	}

}

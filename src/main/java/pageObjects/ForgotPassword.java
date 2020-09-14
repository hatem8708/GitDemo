package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	public WebDriver driver;

	By emailfield = By.id("user_email");

	By sendMeInstructions = By.cssSelector("input[type='submit']");

	public ForgotPassword(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement getEmail() {
		return driver.findElement(emailfield);
	}

	public WebElement sendInstructions() {
		return driver.findElement(sendMeInstructions);
	}
}

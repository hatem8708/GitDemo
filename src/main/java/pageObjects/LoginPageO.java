package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageO {
	public WebDriver driver;

	By emailfield = By.id("user_email");

	By passworfield = By.cssSelector("#user_password");

	By loginbutton = By.name("commit");

	By forgetpassword = By.cssSelector("[href*='password/new']");

	public LoginPageO(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement emailField() {
		return driver.findElement(emailfield);
	}

	public ForgotPassword forgotPassword() {
		driver.findElement(forgetpassword).click();
		return new ForgotPassword(driver);

	}

	public WebElement loginButton() {
		return driver.findElement(loginbutton);
	}

	public WebElement passwordField() {
		return driver.findElement(passworfield);
	}
}

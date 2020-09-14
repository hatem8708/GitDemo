package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;

	private By signin = By.cssSelector("a[href*='sign_in']");
	private By title = By.cssSelector("div.text-center>h2");
	private By navbar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	private By header = By.cssSelector("div[class*='video-banner'] h3");
	private By popup = By.xpath("//button[text()='NO THANKS']");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCenteredText() {
		return driver.findElement(title);
	}

	public WebElement getHeader() {
		return driver.findElement(header);
	}

	public LoginPageO getLogin() {
		driver.findElement(signin).click();
		LoginPageO lpo = new LoginPageO(driver);
		return lpo;
	}

	public WebElement getNavigationBar() {
		System.out.println("Trying to identify navigation bar");
		return driver.findElement(navbar);
	}

	public WebElement getPopUp() {
		return driver.findElement(popup);
	}

	public int getPopUpSize() {

		return driver.findElements(popup).size();
	}
}

package driverfactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

	public WebDriver initializeBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			tdriver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			tdriver.set(new EdgeDriver());
		} else {
			System.out.println("****** BROWSER IS NOT DEFINED");
		}
		return getDriver();

	}

	public static WebDriver getDriver() {
		return tdriver.get();
	}

	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return webElement;
	}
}

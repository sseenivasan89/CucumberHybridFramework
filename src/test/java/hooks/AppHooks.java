package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverfactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class AppHooks {

	ConfigReader configReader;
	Properties properties;
	DriverFactory driverFactory;
	WebDriver driver;

	@Before(order = 0)
	public void getPropertyValues() {
		configReader = new ConfigReader();
		properties = configReader.intializeProperties();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = configReader.getBrowserName();
		driverFactory = new DriverFactory();
		driver = driverFactory.initializeBrowser(browserName);
		driver.get(configReader.getUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@After
	public void closeBrowser(Scenario sceanrio) {
		String scenarioName = sceanrio.getName();
		if (sceanrio.isFailed()) {
			TakesScreenshot takescreenshot = (TakesScreenshot) driver;
			byte[] screnshot = takescreenshot.getScreenshotAs(OutputType.BYTES);
			sceanrio.attach(screnshot, "image/png", scenarioName);
		}
		driver.quit();
	}

}

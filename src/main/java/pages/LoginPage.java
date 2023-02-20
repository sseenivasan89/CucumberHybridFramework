package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(name = "username")
	WebElement usernameBox;
	
	@FindBy(name = "password")
	WebElement passwordBox;
	
	@FindBy(css = "[type='submit']")
	WebElement loginBox;
	
	@FindBy(css = "[class='oxd-userdropdown-tab'] img")
	WebElement userProfileImg;
	
	public boolean loginToApplication(io.cucumber.datatable.DataTable dataTable) {
		boolean isLoginSuccess = false;
		List<Map<String, String>>  mapData = dataTable.asMaps(String.class, String.class);
		elementUtils.waitForElement(loginBox, 10);
		for(Map<String, String> mapDatas : mapData) {
			usernameBox.sendKeys(mapDatas.get("username"));
			passwordBox.sendKeys(mapDatas.get("password"));
		}
		loginBox.click();
		elementUtils.waitForElement(userProfileImg, 20);
		if(userProfileImg.isDisplayed()) {
			isLoginSuccess = true;
		}
		return isLoginSuccess;
	}
	
	

}

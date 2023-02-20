package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class AdminPage {
	
	WebDriver driver;
	ElementUtils elementUtils;
	
	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//*[@class='oxd-main-menu']//*[text()='Admin']")
	WebElement sideMenuAdminButton;
	
	public void goToAdminPage() {
		sideMenuAdminButton.click();
	}
	
	@FindBy(xpath = "(//*[text()='Username']//following::input[1])[1]")
	WebElement usernameSearchBox;
	
	@FindBy(xpath = "//*[@type='submit']")
	WebElement searchButton;
	
	public void searchUser(String usernameToSearch) {
		elementUtils.waitForElement(usernameSearchBox, 10).sendKeys(usernameToSearch);
		searchButton.click();
	}
	
	@FindBy(xpath = "//*[@class='oxd-table-card']/div/div[2]/div")
	WebElement searchResultUserName;
	
	public boolean searchResults(String usernameSearched) throws InterruptedException {
		boolean isUsernameMatch = false;
		Thread.sleep(2000);
		elementUtils.waitForVisibilityOfElement(searchResultUserName, 10);
		if(searchResultUserName.getText().equalsIgnoreCase(usernameSearched)) {
			isUsernameMatch = true;
		}
		return isUsernameMatch;
	}
	
}

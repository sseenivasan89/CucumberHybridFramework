package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class PimPage {
	
	WebDriver driver;
	ElementUtils elementUtils;
	
	public PimPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//*[@class='oxd-main-menu']//*[text()='PIM']")
	WebElement sideMenuPimButton;
	
	public void goToPimPage() {
		sideMenuPimButton.click();
	}
	
	@FindBy(xpath = "((//*[text()='Job Title'])[1]//following::div//*[@class='oxd-select-text-input'])[1]")
	WebElement jobTitleDropDown;
	
	@FindBy(xpath = "(//*[text()='Job Title'])[1]//following::div//*[@role='listbox']/div")
	List <WebElement> jobtitlesList;
	
	@FindBy(xpath = "//*[@type='submit']")
	WebElement searchButton;
	
	public void searchEmployee(String jobtitle) {
		jobTitleDropDown.click();
		for(WebElement jobtitles: jobtitlesList) {
			if(jobtitles.getText().equalsIgnoreCase(jobtitle)) {
				jobtitles.click();
				break;
			}
		}
		searchButton.click();
	}
	
	@FindBy(xpath = "//*[@class='oxd-table-card']/div/div[5]/div")
	List<WebElement> searchResultsJobTitle;
	
	public boolean searchResults(String usernameSearched) throws InterruptedException {
		boolean isJobTtitleMatch = false;
		Thread.sleep(2000);
		for(WebElement results: searchResultsJobTitle) {
			if(results.getText().equalsIgnoreCase(usernameSearched)) {
				isJobTtitleMatch = true;
			}
		}
		return isJobTtitleMatch;
	}

}

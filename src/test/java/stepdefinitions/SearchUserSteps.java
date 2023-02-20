package stepdefinitions;

import org.junit.Assert;
import driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AdminPage;
import pages.LoginPage;

public class SearchUserSteps {

	LoginPage loginPage;
	AdminPage adminPage = new AdminPage(DriverFactory.getDriver());
	
	@Given("I login to the application with below details")
	public void i_login_to_the_application_with_below_details(io.cucumber.datatable.DataTable dataTable) {
		loginPage = new LoginPage(DriverFactory.getDriver());
		 Assert.assertEquals(true,loginPage.loginToApplication(dataTable));
	}

	@Then("I navigate to admin page")
	public void i_navigate_to_admin_page() {
		adminPage.goToAdminPage();
	}

	@When("I search for the {string} user")
	public void i_search_for_the_user(String usernameToSearch) {
	     adminPage.searchUser(usernameToSearch);
	}

	@When("I validate the search results have only {string} user")
	public void i_validate_the_search_results_have_only_user(String usernameSearched) throws InterruptedException {
	   Assert.assertEquals(true, adminPage.searchResults(usernameSearched));
	}
}

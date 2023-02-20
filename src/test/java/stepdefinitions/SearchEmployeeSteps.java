package stepdefinitions;

import org.junit.Assert;

import driverfactory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PimPage;

public class SearchEmployeeSteps {
	
	PimPage pimPage;
	
	@Then("I navigate to pim page")
	public void i_navigate_to_pim_page() {
		pimPage = new PimPage(DriverFactory.getDriver());
		pimPage.goToPimPage();
	}

	@When("I search for the employees in {string}")
	public void i_search_for_the_employees_in(String jobtitle) {
		pimPage.searchEmployee(jobtitle);
	}
	
	@When("I validate the search results of {string}")
	public void i_validate_the_search_results_of(String jobtitle) throws InterruptedException {
		Assert.assertEquals(true, pimPage.searchResults(jobtitle));
	}

}

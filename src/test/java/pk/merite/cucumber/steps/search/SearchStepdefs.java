package pk.merite.cucumber.steps.search;

import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pk.merite.cucumber.pages.search.SearchPage;

public class SearchStepdefs {

	@Autowired
	private SearchPage searchPage;

	@Given("^user visits google home page$")
	public void user_visits_google_home_page() throws Throwable {
		searchPage.load();
	}

	@When("^user enters \"([^\"]*)\" into the search input$")
	public void user_enters_into_the_search_input(String search) throws Throwable {
		searchPage.enterSearchText(search);
	}

	@When("^user clicks on search button$")
	public void user_clicks_on_search_button() throws Throwable {
		searchPage.clickSearch();
	}

	@Then("^search results for \"([^\"]*)\" are shown$")
	public void results_for_search_are_shown(String search) throws Throwable {
		Assertions.assertTrue(searchPage.title().startsWith(search));
	}
}

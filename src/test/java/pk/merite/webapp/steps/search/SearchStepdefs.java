package pk.merite.webapp.steps.search;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pk.merite.webapp.pages.search.SearchPage;
import pk.merite.webapp.steps.Stepdefs;

public class SearchStepdefs extends Stepdefs {

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
        Assert.assertTrue("search results for \"" + search + "\" are shown", searchPage.title().startsWith(search));
    }
}

package com.github.stanvk.fyberchallenge.stepdefinitions;

import com.github.stanvk.fyberchallenge.services.context.UiContextService;
import com.github.stanvk.fyberchallenge.services.webdriver.WebDriverService;
import com.github.stanvk.fyberchallenge.ui.imdb.TopRatedMoviesByWesternGenrePage;
import com.google.inject.Inject;
import com.jayway.awaitility.Awaitility;
import com.jayway.awaitility.Duration;
import com.jayway.awaitility.pollinterval.FibonacciPollInterval;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

/**
 * Created by Stanislav Kostsov on 07.11.2016.
 */
@ScenarioScoped
public class TopRatedMoviesByWesternGenrePageSteps {
    @Inject
    private WebDriverService webDriverService;
    @Inject
    private UiContextService contextService;

    @When("IMDB top rated movies by Western genre page is shown")
    public void whenPageIsShown() {
        pageShown();
    }

    @When("IMDB top rated movies by Western genre page is opened")
    public void whenPageIsOpened() {
        pageOpened();
    }

    @Then("IMDB top rated movies by Western genre page should be shown")
    public void thenPageShouldBeShown() {
        pageShown();
    }

    @Then("IMDB top rated movies by Western genre page should be opened")
    public void thenPageShouldBeOpened() {
        pageOpened();
    }

    private void pageOpened() {
        contextService.setContextPage(new TopRatedMoviesByWesternGenrePage(webDriverService.getWebDriver()));
        pageShown();
    }

    private void pageShown() {
        Awaitility.await()
                .timeout(Duration.TEN_SECONDS)
                .pollInterval(FibonacciPollInterval.fibonacci())
                .until(() -> contextService.getContextPage() instanceof TopRatedMoviesByWesternGenrePage
                        && contextService.getContextPage().isDisplayed());
    }
}

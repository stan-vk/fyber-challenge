package com.github.stanvk.fyberchallenge.stepdefinitions;

import com.github.stanvk.fyberchallenge.services.context.UiContextService;
import com.github.stanvk.fyberchallenge.services.webdriver.WebDriverService;
import com.github.stanvk.fyberchallenge.ui.enums.SortingOrder;
import com.github.stanvk.fyberchallenge.ui.imdb.TopRatedMoviesPage;
import com.github.stanvk.fyberchallenge.ui.imdb.TopRatesMoviesSortingControl;
import com.google.inject.Inject;
import com.jayway.awaitility.Awaitility;
import com.jayway.awaitility.Duration;
import com.jayway.awaitility.pollinterval.FibonacciPollInterval;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

/**
 * Created by Stanislav Kostsov on 06.11.2016.
 */
@ScenarioScoped
public class TopRatesMoviesPageSteps {
    @Inject
    private WebDriverService webDriverService;
    @Inject
    private UiContextService contextService;

    @When("IMDB top rated movies page is shown")
    public void whenPageIsShown() {
        pageShown();
    }

    @When("^user applies \"([^\"]*)\" sorting by \"([^\"]*)\" to \"([^\"]*)\"$")
    public void userAppliesSortingByTo(SortingOrder sortingOrder, String item, String controlName) {
        TopRatesMoviesSortingControl sortingControl =
                contextService.getChild(controlName, TopRatesMoviesSortingControl.class);

        sortingControl.getDropDown().selectItemWithKeyboard(item);

        sortingControl.getSortingOrderButton().applySortingOrder(sortingOrder);
        Awaitility.await()
                .timeout(Duration.TEN_SECONDS)
                .pollInterval(FibonacciPollInterval.fibonacci())
                .until(() -> sortingControl.getSortingOrderButton().getSortingOrder().equals(sortingOrder));

    }

    @Then("IMDB top rated movies page should be shown")
    public void thenPageShouldBeShown() {
        pageShown();
    }

    private void pageShown() {
        Awaitility.await()
                .timeout(Duration.TEN_SECONDS)
                .pollInterval(FibonacciPollInterval.fibonacci())
                .until(() -> contextService.getContextPage() instanceof TopRatedMoviesPage
                        && contextService.getContextPage().isDisplayed());
    }
}

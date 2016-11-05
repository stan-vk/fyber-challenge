package com.github.stanvk.fyberchallenge.stepdefinitions;

import com.github.stanvk.fyberchallenge.services.context.UiContextService;
import com.github.stanvk.fyberchallenge.services.webdriver.WebDriverService;
import com.github.stanvk.fyberchallenge.ui.common.Table;
import com.github.stanvk.fyberchallenge.ui.common.TableRow;
import com.google.inject.Inject;
import com.jayway.awaitility.Awaitility;
import com.jayway.awaitility.Duration;
import com.jayway.awaitility.pollinterval.FibonacciPollInterval;
import cucumber.api.java.en.Then;
import cucumber.runtime.java.guice.ScenarioScoped;

/**
 * Created by Stanislav Kostsov on 05.11.2016.
 */
@ScenarioScoped
public class TableSteps {
    @Inject
    private WebDriverService webDriverService;
    @Inject
    private UiContextService contextService;

    @Then("^\"([^\"]*)\" should contain \"([^\"]*)\" rows$")
    public void tableShouldContainNumberOfRows(String name, long rows) {
        Table table = contextService.getChild(name, Table.class);
        Awaitility.await()
                .timeout(Duration.FIVE_SECONDS)
                .pollInterval(FibonacciPollInterval.fibonacci())
                .until(() -> table.getRows().size() == rows);
    }

    @Then("^\"([^\"]*)\" should contain at least one row$")
    public void shouldContainAtLeastOneRow(String name) {
        Table table = contextService.getChild(name, Table.class);
        Awaitility.await()
                .timeout(Duration.FIVE_SECONDS)
                .pollInterval(FibonacciPollInterval.fibonacci())
                .until(() -> table.getRows().stream().anyMatch(TableRow::isDisplayed));
    }
}

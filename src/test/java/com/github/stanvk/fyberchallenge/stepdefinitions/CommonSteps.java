package com.github.stanvk.fyberchallenge.stepdefinitions;

import com.github.stanvk.fyberchallenge.services.context.UiContextService;
import com.github.stanvk.fyberchallenge.services.webdriver.WebDriverService;
import com.github.stanvk.fyberchallenge.ui.interfaces.Visible;
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
public class CommonSteps {
    @Inject
    private WebDriverService webDriverService;
    @Inject
    private UiContextService contextService;

    @Then("^\"([^\"]*)\" should be displayed$")
    public void shouldBeDisplayed(String name) {
        Visible visible = contextService.getChild(name, Visible.class);
        visible.isDisplayed();
        Awaitility.await()
                .timeout(Duration.FIVE_SECONDS)
                .pollInterval(FibonacciPollInterval.fibonacci())
                .until(visible::isDisplayed);
    }
}

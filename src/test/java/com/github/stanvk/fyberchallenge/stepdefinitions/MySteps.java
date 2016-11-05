package com.github.stanvk.fyberchallenge.stepdefinitions;

import com.github.stanvk.fyberchallenge.services.context.UiContextService;
import com.github.stanvk.fyberchallenge.services.webdriver.WebDriverService;
import com.github.stanvk.fyberchallenge.ui.imdb.TopRatedMoviesPage;
import com.google.inject.Inject;

import com.jayway.awaitility.Awaitility;
import com.jayway.awaitility.Duration;
import com.jayway.awaitility.pollinterval.FibonacciPollInterval;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.runtime.java.guice.ScenarioScoped;

import java.util.Objects;

@ScenarioScoped
public class MySteps {
    @Inject
    private WebDriverService webDriverService;
    @Inject
    private UiContextService contextService;

    @Given("browser is opened and IMDB is loaded")
    public void openBrowser() {
        webDriverService.getWebDriver().get("http://www.imdb.com/chart/top");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                if (!Objects.isNull(webDriverService.getWebDriver())) {
                    webDriverService.getWebDriver().quit();
                }
            }
        });
        contextService.setContextPage(new TopRatedMoviesPage(webDriverService.getWebDriver()));
    }

    @Then("page should be shown")
    public void pageShouldBeShown() {
        Awaitility.await()
                .timeout(Duration.TEN_SECONDS)
                .pollInterval(FibonacciPollInterval.fibonacci())
                .until(() -> webDriverService.getWebDriver().findElementById("home_img_holder").isDisplayed());
    }

    @Then("browser is closed")
    public void browserIsClosed() {
        webDriverService.getWebDriver().quit();
    }
}

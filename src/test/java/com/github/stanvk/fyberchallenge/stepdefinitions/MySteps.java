package com.github.stanvk.fyberchallenge.stepdefinitions;

import java.util.Objects;

import com.github.stanvk.fyberchallenge.services.webdriver.WebDriverService;
import com.google.inject.Inject;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.jayway.awaitility.Awaitility;
import com.jayway.awaitility.Duration;
import com.jayway.awaitility.pollinterval.FibonacciPollInterval;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class MySteps {
    @Inject
    private WebDriverService webDriverService;

    @Given("browser is opened and IMDB is loaded")
    public void openBrowser() {
        webDriverService.getWebDriver().get("http://www.imdb.com/chart/top");

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

package com.github.stanvk.fyberchallenge.stepdefinitions;

import java.util.Objects;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.jayway.awaitility.Awaitility;
import com.jayway.awaitility.Duration;
import com.jayway.awaitility.pollinterval.FibonacciPollInterval;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class MySteps {
	private FirefoxDriver driver;
	
	@Given("browser is opened and IMDB is loaded")
	public void openBrowser() {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.imdb.com/chart/top");

	}
	
	@Then("page should be shown")
	public void pageShouldBeShown() {
		Awaitility.await()
		.timeout(Duration.TEN_SECONDS)
		.pollInterval(FibonacciPollInterval.fibonacci())
		.until(() -> driver.findElementById("home_img_holder").isDisplayed());
	}
	
	@Then("browser is closed")
	public void browserIsClosed() {
		if (!Objects.isNull(driver)) {
			driver.quit();
		}
	}
}

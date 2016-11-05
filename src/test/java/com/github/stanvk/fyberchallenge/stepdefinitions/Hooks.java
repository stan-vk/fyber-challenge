package com.github.stanvk.fyberchallenge.stepdefinitions;

import com.github.stanvk.fyberchallenge.services.context.UiContextService;
import com.github.stanvk.fyberchallenge.services.webdriver.WebDriverService;
import com.github.stanvk.fyberchallenge.ui.imdb.TopRatedMoviesPage;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.util.Objects;

/**
 * Created by Stanislav Kostsov on 05.11.2016.
 */
@Singleton
public class Hooks {
    @Inject
    WebDriverService webDriverService;
    @Inject
    private UiContextService contextService;

    @Before("@IMDB")
    public void imdbBefore() {
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

    @After("@IMDB")
    public void imdbAfter() {
    }
}

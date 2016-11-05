package com.github.stanvk.fyberchallenge.ui.imdb;

import com.github.stanvk.fyberchallenge.ui.common.AbstractPage;
import com.github.stanvk.fyberchallenge.ui.common.Table;
import com.github.stanvk.fyberchallenge.ui.common.UiException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Optional;

/**
 * Created by Stanislav Kostsov on 05.11.2016.
 */
public class TopRatedMoviesPage extends AbstractPage {
    private static final String TOP_250_MOVIE_TABLE_XPATH = "//table[@data-caller-name='chart-top250movie']";

    private final RemoteWebDriver webDriver;

    @FindBy(xpath = TOP_250_MOVIE_TABLE_XPATH)
    private WebElement moviesListRootElement;

    public TopRatedMoviesPage(RemoteWebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public Table getTop250MovieTable() {
        return Optional.ofNullable(moviesListRootElement)
                .map(e -> new Table(webDriver, e))
                .orElseThrow(() -> new UiException("Root element was not found by selector: " + TOP_250_MOVIE_TABLE_XPATH));
    }
}

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
    private static final String ROOT_ELEMENT_XPATH = "//h1[text()='Top Rated Movies']";
    private static final String TOP_250_MOVIE_TABLE_XPATH = "//table[@data-caller-name='chart-top250movie']";
    private static final String SORTING_CONTROL_CLASS = "nav";
    private static final String BY_GENRE_LIST_XPATH = "//span[h3/text()='Top Rated Movies by Genre']/ul";

    @FindBy(xpath = ROOT_ELEMENT_XPATH)
    private WebElement rootElement;

    @FindBy(xpath = TOP_250_MOVIE_TABLE_XPATH)
    private WebElement moviesListRootElement;

    @FindBy(className = SORTING_CONTROL_CLASS)
    private WebElement sortingControlRootElement;

    @FindBy(xpath = BY_GENRE_LIST_XPATH)
    private WebElement byGenreListRootElement;

    public TopRatedMoviesPage(RemoteWebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public boolean isDisplayed() {
        return rootElement.isDisplayed();
    }

    public Table getTop250MovieTable() {
        return Optional.ofNullable(moviesListRootElement)
                .map(e -> new Table(webDriver, e))
                .orElseThrow(() -> new UiException("Root element was not found by selector: " + TOP_250_MOVIE_TABLE_XPATH));
    }

    public TopRatesMoviesSortingControl getMovieTableSortingControl() {
        return Optional.ofNullable(sortingControlRootElement)
                .map(e -> new TopRatesMoviesSortingControl(webDriver, e))
                .orElseThrow(() -> new UiException("Root element was not found by selector: " + SORTING_CONTROL_CLASS));
    }

    public TopRatedMoviesByGenreList getMoviesByGenreList() {
        return Optional.ofNullable(byGenreListRootElement)
                .map(e -> new TopRatedMoviesByGenreList(webDriver, e))
                .orElseThrow(() -> new UiException("Root element was not found by selector: " + BY_GENRE_LIST_XPATH));
    }
}

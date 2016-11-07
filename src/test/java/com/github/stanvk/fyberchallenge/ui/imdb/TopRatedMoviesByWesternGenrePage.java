package com.github.stanvk.fyberchallenge.ui.imdb;

import com.github.stanvk.fyberchallenge.ui.common.AbstractElement;
import com.github.stanvk.fyberchallenge.ui.common.AbstractPage;
import com.github.stanvk.fyberchallenge.ui.common.UiException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Optional;

/**
 * Created by Stanislav Kostsov on 07.11.2016.
 */
public class TopRatedMoviesByWesternGenrePage extends AbstractPage {
    private static final String ROOT_ELEMENT_XPATH = "//h1[contains(text(), 'Highest Rated Western Feature Films With At Least 25000 Votes')]";
    private static final String MOVIES_LIST_ROOT_CLASS = "lister-list";

    @FindBy(xpath = ROOT_ELEMENT_XPATH)
    private WebElement rootElement;

    @FindBy(className = MOVIES_LIST_ROOT_CLASS)
    private WebElement moviesListRootElement;

    public TopRatedMoviesByWesternGenrePage(RemoteWebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public boolean isDisplayed() {
        return rootElement.isDisplayed();
    }

    public TopMoviesList getTopMoviesList() {
        return Optional.ofNullable(moviesListRootElement)
                .map(e -> new TopMoviesList(webDriver, e))
                .orElseThrow(() -> new UiException("Root element was not found by selector: " + MOVIES_LIST_ROOT_CLASS));
    }
}

package com.github.stanvk.fyberchallenge.ui.imdb;

import com.github.stanvk.fyberchallenge.ui.common.ListBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Stanislav Kostsov on 07.11.2016.
 */
public class TopRatedMoviesByGenreList extends ListBase {
    public TopRatedMoviesByGenreList(RemoteWebDriver webDriver, WebElement rootElement) {
        super(webDriver, rootElement);
    }

    @Override
    public TopRatedMoviesByGenreListItem getItemByText(String text) {
        return new TopRatedMoviesByGenreListItem(webDriver, getWebElementItemByText(text));
    }
}

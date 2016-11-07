package com.github.stanvk.fyberchallenge.ui.imdb;

import com.github.stanvk.fyberchallenge.ui.common.ButtonBase;
import com.github.stanvk.fyberchallenge.ui.common.ListBaseItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Stanislav Kostsov on 07.11.2016.
 */
public class TopRatedMoviesByGenreListItem extends ListBaseItem {
    public TopRatedMoviesByGenreListItem(RemoteWebDriver webDriver, WebElement rootElement) {
        super(webDriver, rootElement);
    }

    @Override
    public void leftMouseClick() {
        ButtonBase link = new ButtonBase(webDriver, rootElement.findElement(By.xpath("a")));
        link.leftMouseClick();
    }
}

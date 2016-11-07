package com.github.stanvk.fyberchallenge.ui.imdb;

import com.github.stanvk.fyberchallenge.ui.common.AbstractElement;
import com.github.stanvk.fyberchallenge.ui.common.Div;
import com.github.stanvk.fyberchallenge.ui.interfaces.HasItems;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Stanislav Kostsov on 08.11.2016.
 */
public class TopMoviesList extends AbstractElement implements HasItems<Div> {
    protected TopMoviesList(RemoteWebDriver webDriver, WebElement rootElement) {
        super(webDriver, rootElement);
    }

    @Override
    public List<Div> getItems() {
        return rootElement.findElements(By.xpath("./div[@class='lister-item mode-advanced']"))
                .stream()
                .map(element -> new Div(webDriver, element))
                .collect(Collectors.toList());
    }

    @Override
    public Div getItemByText(String text) {
        throw new UnsupportedOperationException("Cannot get TopMoviesList item by text");
    }
}
